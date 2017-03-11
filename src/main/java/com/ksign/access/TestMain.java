package com.ksign.access;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by mkh on 2017-03-07.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {

        String endpoint = "http://" + "127.0.0.1" + ":19091/cs-duplicate.jsp";
        String postData = "uid=" + "bin" + "&client_ip=" + "0.0.0.0";



        URL obj = null;
        HttpURLConnection con = null;
        OutputStream os = null;
        BufferedReader in = null;
        try
        {
            obj = new URL(endpoint);

            con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "KSignAccessServer");

            con.setDoOutput(true);
            con.setDoInput(true);

            os = con.getOutputStream();
            os.write(postData.getBytes());
            os.flush();
            os.close();

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();  } catch (Exception localException3) {
            }try {
                if (in != null) in.close();
            } catch (Exception localException4) {
            }
            if (con != null) con.disconnect();

        }

    }

}
