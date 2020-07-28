package ds.problems.string;

public class _468ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP.contains(".")) {
            return isIP4(IP);
        } else if(IP.contains(":")) {
            return isIP6(IP);
        } else {
            return "Neither";
        }
    }

    String isIP4(String IP) {
        String[] parts = IP.split("\\.",-1);
        if(parts.length!=4) return "Neither";
        try{
            for(String part: parts) {
                if(part.equals("")) {
                    return "Neither";
                }
                if(part.length()>1&&Integer.parseInt(part)<=9&&Integer.parseInt(part)>=0)
                    return "Neither";
                if(part.length()>2&&Integer.parseInt(part)<=99&&Integer.parseInt(part)>=10)
                    return "Neither";
                if(part.length()==3&&Integer.parseInt(part)>255)
                    return "Neither";
                if(part.length()>3)
                    return "Neither";
            }
        }catch(NumberFormatException e)
        {
            return "Neither";
        }
        return "IPv4";
    }

    String isIP6(String IP) {
        if(IP.substring(IP.length()-1).equals(":")||IP.substring(0,1).equals(":"))
            return "Neither";
        String[] parts = IP.split("\\:");
        if(parts.length!=8) return "Neither";
        try
        {
            for(int i=0;i<parts.length;i++)
            {
                Long l=Long.parseLong(parts[i],16);
                if(parts[i].contains("-"))
                    return "Neither";
                if(l<0)
                    return "Neither";
                if(parts[i].equals("")||parts[i].length()>4)
                    return "Neither";
            }
        }
        catch(Exception e)
        {
            return "Neither";
        }
        return "IPv6";
    }
}
