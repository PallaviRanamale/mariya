package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static final String BASE = "http://localhost:5000";

    private static void call(String pathAndQuery) throws Exception {
        String url = BASE + pathAndQuery;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");

        int code = con.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        System.out.println("GET " + url);
        System.out.println("HTTP " + code);
        System.out.println("Server says: " + sb.toString());
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // 7.1 Simple Calculator
        call("/calc?a=10&b=4&op=add");

        // 7.2 Simple Interest
        call("/si?p=1000&r=5&t=2");

        // 7.3 Hello + Name
        call("/hello?name=Alice");

        // 7.4 / 7.5 Miles -> KM (same)
        call("/miles_to_km?miles=10");
    }
}
