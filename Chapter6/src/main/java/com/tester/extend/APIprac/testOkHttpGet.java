package com.tester.extend.APIprac;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class testOkHttpGet {
    public  static void interfaceUtil(String path,String data){
        try {
            URL url = new URL(path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "keep-Alice");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestMethod("GET");

            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str="";
            while((str=br.readLine()) != null){
                str=new String(str.getBytes(),"UTF-8");
                System.out.println(str);
            }

            is.close();

            conn.disconnect();
            System.out.println("完整结束。。。");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        interfaceUtil("https://capi.gshopper.com/v1/product/80032966","");
    }
}
