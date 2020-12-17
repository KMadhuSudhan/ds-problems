package ds.problems.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.stream.JsonReader;

class Result {

        /*
         * Complete the 'calculateNAV' function below.
         *
         * The function is expected to return a DOUBLE.
         * The function accepts STRING date as parameter.
         */
        abstract class AbstractModel {
            int totalRecords;
            int recordsPerPage;
            int page;
            String nextPage;
            public void setTotalRecords(int totalRecords) {
                this.totalRecords = totalRecords;
            }
            public void setRecordsPerPage(int recordsPerPage) {
                this.recordsPerPage = recordsPerPage;
            }
            public void setPage(int page) {
                this.page = page;
            }
            public void setNextPage(String nextPage) {
                this.nextPage = nextPage;
            }
            public int getTotalRecords() {
                return this.totalRecords;
            }
            public int getRecordsPerPage() {
                return this.recordsPerPage;
            }
            public int getPage() {
                return this.page;
            }
            public String getNextPage() {
                return this.nextPage;
            }
        }
        class HoldingResponseModel extends AbstractModel {
            List<Holding> data;
            public void setData(List<Holding> data) {
                this.data = data;
            }
            public List<Holding> getData() {
                return this.data;
            }
        }
        class PriceResponseModel extends AbstractModel {
            List<Price> data;
            public void setData(List<Price> data) {
                this.data = data;
            }
            public List<Price> getData() {
                return this.data;
            }
        }
        class Price {
            String date;
            String security;
            double price;
            public void setDate(String date) {
                this.date = date;
            }
            public void setSecurity(String security) {
                this.security = security;
            }
            public void setPrice(double price) {
                this.price = price;
            }

            public String getDate() {
                return this.date;
            }

            public String getSecurity() {
                return this.security;
            }

            public double getPrice() {
                return  this.price;
            }
        }

        class Holding  {
            String date;
            String security;
            int quantity;
            String portfolio;
            public void setDate(String date) {
                this.date = date;
            }
            public void setSecurity(String security) {
                this.security = security;
            }
            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
            public void setPortfolio(String portfolio) {
                this.portfolio = portfolio;
            }
            public String getDate() {
                return this.date;
            }
            public String getSecurity() {
                return this.security;
            }
            public int getQuantity() {
                return this.quantity;
            }
            public String getPortfolio() {
                return this.portfolio;
            }
        }

        private static final String holdingRestEndPoint = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/holding_start";
        private static final String pricingRestEndPoint = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/pricing_start";

        public static double calculateNAV(String date) {
            try {
                Date inputDate = new SimpleDateFormat("yyyyMMdd").parse(date);

                //get holdings
                HoldingResponseModel holdingResponseModel = findHoldingPaginationRecords(inputDate);
                if(holdingResponseModel == null) return 0.0;
                List<Holding> holdings = findHoldingRecords(holdingResponseModel,inputDate);
                if(holdings.size() == 0) return 0.0;

                //get prices
                PriceResponseModel priceResponseModel = findPricePaginationRecords(inputDate);
                if(priceResponseModel == null) return 0.0;
                List<Price> prices = findPriceRecords(priceResponseModel,inputDate);
                if(prices.size() == 0) return 0.0;
                return calulateNAV(holdings,prices);
            }  catch(Exception e) {
                System.out.println(e.getLocalizedMessage());
                return 0.0;
            }
        }
        private static double calulateNAV(List<Holding> holdings,List<Price> prices) {
            Map<String,Integer> holdingMap = new HashMap();
            Map<String,Double> priceMap = new HashMap();
            for(Holding holding: holdings) {
                String key = holding.getSecurity();
                int qty = holdingMap.getOrDefault(key, 0);
                holdingMap.put(key, qty + holding.getQuantity());
            }

            for(Price price: prices) {
                String key = price.getSecurity();
                priceMap.put(key, price.getPrice());
            }
            double total = 0.0;
            for(Map.Entry<String,Integer> mEntry: holdingMap.entrySet()) {
                double price = priceMap.get(mEntry.getKey());

                int qty = mEntry.getValue();
                total+= price*qty;
            }
            BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        private static List<Holding> findHoldingRecords(HoldingResponseModel holdingResponseModel,Date inputDate) {
            List<Holding> holdings = new ArrayList<>();
            try {
                List<Holding> dList = holdingResponseModel.getData();
                for(Holding holding: dList) {
                    Date recordDate = new SimpleDateFormat("yyyyMMdd").parse(holding.getDate());
                    if(inputDate.compareTo(recordDate) == 0) {
                        holdings.add(holding);
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            return holdings;
        }
        private static List<Price> findPriceRecords(PriceResponseModel priceResponseModel,Date inputDate) {
            List<Price> prices = new ArrayList<>();
            try {
                List<Price> dList = priceResponseModel.getData();
                for(Price price: dList) {
                    Date recordDate = new SimpleDateFormat("yyyyMMdd").parse(price.getDate());
                    if(inputDate.compareTo(recordDate) == 0) {
                        prices.add(price);
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            return prices;
        }

        private static HoldingResponseModel findHoldingPaginationRecords(Date inputDate) {
            List<Holding> holdings = new ArrayList<>();

            try {
                String nextPage = holdingRestEndPoint;
                while(nextPage!=null) {
                    HoldingResponseModel holdingResponseModel = getHoldings(nextPage);
                    if(holdingResponseModel!=null && holdingResponseModel.getData().size() > 0) {
                        int dataSize = holdingResponseModel.getData().size();
                        Holding lastRecord = holdingResponseModel.getData().get(dataSize-1);
                        Date lastRecordDate = new SimpleDateFormat("yyyyMMdd").parse(lastRecord.getDate());
                        if(lastRecordDate.compareTo(inputDate)>=0) {
                            return holdingResponseModel;
                        }
                        if(lastRecordDate.compareTo(inputDate) == 0) {
                            holdings.addAll(holdingResponseModel.getData());
                        } else if(lastRecordDate.compareTo(inputDate) > 0) {
                            holdings.addAll(holdingResponseModel.getData());
                            holdingResponseModel.setData(holdings);
                            return holdingResponseModel;
                        }
                        nextPage = holdingResponseModel.getNextPage();
                    } else {
                        return null;
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            return null;
        }

        private static PriceResponseModel findPricePaginationRecords(Date inputDate) {
            PriceResponseModel priceResponseModel = null;
            List<Price> prices = new ArrayList<>();
            try {
                String nextPage = pricingRestEndPoint;
                while(nextPage!=null) {
                    priceResponseModel = getPrices(nextPage);
                    if(priceResponseModel!=null && priceResponseModel.getData().size() > 0) {
                        int dataSize = priceResponseModel.getData().size();
                        Price lastRecord = priceResponseModel.getData().get(dataSize-1);
                        Date lastRecordDate = new SimpleDateFormat("yyyyMMdd").parse(lastRecord.getDate());
                        if(lastRecordDate.compareTo(inputDate) == 0) {
                            prices.addAll(priceResponseModel.getData());
                        } else if(lastRecordDate.compareTo(inputDate) > 0) {
                            prices.addAll(priceResponseModel.getData());
                            priceResponseModel.setData(prices);
                            return priceResponseModel;
                        }
                        nextPage = priceResponseModel.getNextPage();
                    } else {
                        return priceResponseModel;
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            return priceResponseModel;
        }

        private static HoldingResponseModel getHoldings(String urlString) {
            HoldingResponseModel holdingResponseModel = null;
            try {
                URL url = new URL(urlString);
                InputStreamReader reader = new InputStreamReader(url.openStream());
//                holdingResponseModel = new Gson().fromJson(reader, HoldingResponseModel.class);
            } catch(Exception e) {
                System.out.print("Exception: {}" + e.getLocalizedMessage());
            }
            return holdingResponseModel;
        }

        private static PriceResponseModel getPrices(String urlString) {
            PriceResponseModel priceResponseModel = null;
            try {
                URL url = new URL(urlString);
                InputStreamReader reader = new InputStreamReader(url.openStream());
//                priceResponseModel = new Gson().fromJson(reader, PriceResponseModel.class);
            } catch(Exception e) {
                System.out.print("Exception: {}" + e.getLocalizedMessage());
            }
            return priceResponseModel;
        }

    }
    public class Arcesim {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String date = bufferedReader.readLine();

            double result = Result.calculateNAV(date);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

