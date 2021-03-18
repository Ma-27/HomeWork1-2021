package com.mamh.homework12021.util.http;

public interface HttpCallbackListener {
    void onResponse(String response);

    void onError(Exception e);
}
