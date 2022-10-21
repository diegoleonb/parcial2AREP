package edu.escuelaing.arep;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;


public class SparkWebApp {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(System.getProperty("aws"));
        port(getPort());
        get("/collatzsequence",(req, res)->{
            res.type("application/json");
            return urlConnection("collatzsequence",req.queryParams("value"));
        });
    }


    static String urlConnection(String service,String param) throws IOException{
        URL url = new URL("http://localhost"+":5000/"+service+"?value="+param);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append("JSON Extraido de: " + url + "\n");
                        sb.append(line + "\n");
                    }
                    br.close();
        return sb.toString();
    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}