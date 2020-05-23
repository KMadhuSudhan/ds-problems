package ds.problems.string;
//https://leetcode.com/problems/html-entity-parser/
//1410. HTML Entity Parser

import java.util.HashMap;
import java.util.Map;

public class _1410HTMLEntityParser {
    public static void main(String[] args) {
        _1410HTMLEntityParser htmlEntityParser = new _1410HTMLEntityParser();
        System.out.println(htmlEntityParser.entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }
    public String entityParser(String text) {
        Map<String,String> map = new HashMap();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        StringBuilder sb = new StringBuilder();
        char[] chars = text.toCharArray();
        int i=0;
        while(i<chars.length) {
            if(chars[i] == '&') {
                StringBuilder entity = new StringBuilder();
                while(i<chars.length && chars[i] != ';') {
                    entity.append(chars[i]);
                    i++;
                }
                entity.append(";");
                String htmlEntity = entity.toString();
                String val = map.get(htmlEntity);
                if(val!=null) {
                    sb.append(val);
                } else {
                    sb.append(entity.toString());
                }
                i++;
            } else {
                sb.append(chars[i]);
                i++;
            }
        }
        return sb.toString();
    }
}
