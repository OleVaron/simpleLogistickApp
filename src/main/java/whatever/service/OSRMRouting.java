package whatever.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class OSRMRouting implements Routing{
    public static String OSRM_URL = "http://router.project-osrm.org/route/v1/driving/";

    public long getDistance(float startLat,float startLng,float endLat,float endLng) {
        Float fLoat = 0f;
        try {
            String urlString = OSRM_URL + startLat +","+ startLng+";"+ endLat+","+endLng; //+ "?overview=false";
//            String urlString = OSRM_URL + "53.183786,50.095143;" + "53.258624,50.278268" + "?overview=false";
            System.out.println(urlString);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            con.disconnect();
            JSONParser parser = new JSONParser();
            JSONObject responseJson = (JSONObject) parser.parse(content.toString());
            JSONArray msg = (JSONArray) responseJson.get("routes");
            fLoat = Float.parseFloat(((JSONObject) msg.get(0)).get("distance").toString());
        } catch (Exception e) {
            System.out.println("OSRMRouting:"+e);
        }
        return fLoat.longValue();
    }



    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        //        Map<String, String> parameters = new HashMap<>();
//        parameters.put("param1", "val");

//        con.setDoOutput(true);
//        DataOutputStream out = new DataOutputStream(con.getOutputStream());
//        out.writeBytes(OSRMRouting.getParamsString(parameters));
//        out.flush();
//        out.close();

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }



}
