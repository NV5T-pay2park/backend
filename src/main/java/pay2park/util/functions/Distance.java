package pay2park.util.functions;

import org.springframework.web.client.RestTemplate;

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

    public static String getDistanceAndTimeGgApi(double lat1, double lon1, double lat2, double lon2){
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        url = url + "destinations=" + lat1 + "," + lon1;
        url = url + "&origins=" + lon2 + "," + lat2;
        url = url + "&key=AIzaSyCuIMJTEeifSs3ISPf2WOCsoiMjsuurP5w";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "5.5,30";
    }





}
