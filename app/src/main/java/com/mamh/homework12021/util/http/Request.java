package com.mamh.homework12021.util.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    private static final String TAG = "Request成功";

    /**
     * HttpGet请求封装
     */
    public void sendHttpGetRequest(String address, HttpCallbackListener listener) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            //连接
            connection.connect();

            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String lines;
            while ((lines = reader.readLine()) != null) {
                builder.append(lines);
                //让字符串分行显示，这将是debug更容易
                builder.append("\n");
            }

            String response = builder.toString();
            //使得listener获得回复响应
            if (listener != null) {
                listener.onResponse(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Response Fail!");
            if (listener != null) {
                listener.onError(e);
            }
        } finally {
            if (connection != null) {
                Log.e(TAG, "断开连接!");
                connection.disconnect();
            }
        }
    }
}
