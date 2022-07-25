package pay2park.util.functions;


import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;


public class Distance {
    public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        dist = Math.round(dist * 10.0) / 10.0;
        return (dist);
    }


    static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }


    static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static String getDistanceAndTimeGgApi(double lat1, double lon1, double lat2, double lon2) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        url = url + "destinations=" + lat1 + "," + lon1;
        url = url + "&origins=" + lat2 + "," + lon2;
        url = url + "&key=AIzaSyCuIMJTEeifSs3ISPf2WOCsoiMjsuurP5w";

        URL uri = new URL(url);
        HttpURLConnection con = (HttpURLConnection) uri.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();

        if (status == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            JSONObject result = new JSONObject(content.toString());
            if (result.get("status") == "OK") {
                JSONObject row = (JSONObject) Array.get(result.get("rows"),0);
                JSONObject elements = (JSONObject) Array.get(row.get("elements"), 0);
                JSONObject data = (JSONObject) Array.get(elements, 0);
                JSONObject distance = (JSONObject) data.get("distance");
                JSONObject time = (JSONObject) data.get("duration");
                return distance.get("value")+","+time.get("value");
             }
            else{
                return "0.0,0";
            }

        } else {
            return "0.0,0";
        }

    }





}
