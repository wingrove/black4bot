// Use Google's GeoCode Api to Autocomplete a partital address provided 
// Google's Geocode library
// https://developers.google.com/maps/documentation/geocoding/    
// use the JSON output returned by the library to retrieve the information 
// Example 
// http://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway
// Input Partial Address
// OutPut List of possible Address Match

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

import java.net.URL;
import java.util.Scanner;
public class Geocoder {
    public static void main(String[] args)
    {
        String address =" 2233 Fort Benning Rd Columbus, GA";

        try {


            URL url = new URL("http://www.datasciencetoolkit.org/maps/api/geocode/json?address=address,+CA&sensor=true_or_false");
            String input ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><SingleServiceInteface><Header><VERSION>1.0</VERSION><CALLID>39de507e01e40051ad44000825a05f30</CALLID><APPLICATION>DTV_CVP</APPLICATION><CLIENT>DIRECTV</CLIENT></Header><State><STATE_NAME>GETDTVCALLDATA</STATE_NAME><DIALED_NUMBER>193995</DIALED_NUMBER></State><ActionLog/></SingleServiceInteface>";
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/xml");

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            System.out.println("HTTP code : "+ conn.getResponseCode());


            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {

                System.out.println(output);
            }

            conn.disconnect();

        } catch (Exception e) {

            e.printStackTrace();

        }


        //new NetClientPost(address);

        System.out.println("All the available options of the locations with the given" +
                "house number andstreet name are: "  );

    }
}
 

