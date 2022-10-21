package edu.escuelaing.arep;


import static spark.Spark.*;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/collatzsequence",(req, res)->{
            res.type("application/json");
            return "{\"operation\":\"collatzsequence\",\"input\":"+Double.valueOf(req.queryParams("value"))+            
                ",\"output\":"+collatzSequence(req.queryParams("value"))+"}";
        });
    }

    private static String collatzSequence(String value) {
        int n = Integer.parseInt(value);
        StringBuilder sb = new StringBuilder();
        while (n != 1) {
            sb.append(n);
            sb.append("->");
            int n2 = n % 2;
            if (n2 == 0) {
                n = (n / 2);
            } else {
                n = (3 * n + 1);
            }
        }
        sb.append(n);
        return sb.toString();
    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}