package ds.problems.string;

import java.util.*;

public class Interview {
    public static void main(String[] args) {
        Interview interview = new Interview();
        List<String> possibleFeatures = new ArrayList<>();

        interview.popularNFeatures(5,2,new ArrayList<>(),1,new ArrayList<>());
    }
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        possibleFeatures = new ArrayList<>();
        numFeatures = 5;
        topFeatures  =2;
        possibleFeatures.add("anacell");
        possibleFeatures.add("betacellular");
        possibleFeatures.add("cetracular");
        possibleFeatures.add("deltacellular");
        possibleFeatures.add("eurocell");
        featureRequests = new ArrayList<>();
        featureRequests.add("Best services provided by anacell");
        featureRequests.add("betacellular has great services");
        featureRequests.add("anacell provides much better services than all other");


        Map<String, Integer> map = new HashMap<>();

        PossibleFeature[] featuresCount = new PossibleFeature[possibleFeatures.size()];

        for (int i = 0; i < possibleFeatures.size(); i++) {
            map.put(possibleFeatures.get(i), i);
        }

        for (int i = 0; i < featureRequests.size(); i++) {
            String[] words = featureRequests.get(i).split(" ");
            boolean[] appeared = new boolean[possibleFeatures.size()];
            for (String word : words) {
                if (map.containsKey(word.toLowerCase())) {
                    int index = map.get(word.toLowerCase());
                    if (!appeared[index]) {
                        if (featuresCount[index] == null) {
                            PossibleFeature pc = new PossibleFeature();
                            pc.count = 1;
                            pc.index = index;
                            featuresCount[index] = pc;
                        } else {
                            featuresCount[index].count++;
                        }
                        appeared[index] = true;
                    }
                }
            }
        }

        //System.out.print("featuresList" + Arrays.toString(featuresCount));
        List<PossibleFeature> featuresList = new ArrayList<PossibleFeature>();
        for(int i=0;i<featuresCount.length;i++) {
            if(featuresCount[i] !=null){
                featuresList.add(featuresCount[i]);
            }
        }

        Collections.sort(featuresList, new Comparator<PossibleFeature>() {
            @Override
            public int compare(PossibleFeature o1, PossibleFeature o2) {
                return o1.count - o2.count;
            }
        });
        ArrayList<String> ans = new ArrayList<String>();

        for(int i=featuresList.size()-1;i>=0 && topFeatures>0;i--) {
            int index = featuresList.get(i).index;
            //System.out.print(featuresList.get(i).count);
            //System.out.print(index);
            ans.add(possibleFeatures.get(index));
            topFeatures--;
        }
        System.out.println(ans);
        return ans;
    }

    class PossibleFeature {
        Integer count;
        Integer index;
    }
}
