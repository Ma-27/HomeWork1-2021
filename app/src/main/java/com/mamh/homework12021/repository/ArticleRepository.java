package com.mamh.homework12021.repository;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mamh.homework12021.bean.ArticleBean;
import com.mamh.homework12021.util.http.HttpCallbackListener;
import com.mamh.homework12021.util.http.Request;
import com.mamh.homework12021.util.parse.ParseList;

import java.util.List;

public class ArticleRepository {
    public static final String URI = "https://www.wanandroid.com/article/list/0/json";
    private static final String TAG = "ArticleRepository成功";
    MutableLiveData<List<ArticleBean>> mAllArticles;
    private String response;
    //单例模式
    private volatile static FetchArticleList INSTANCE;

    public ArticleRepository() {
        mAllArticles = new MutableLiveData<>();
    }

    public MutableLiveData<List<ArticleBean>> getAllArticles() {
        return mAllArticles;
    }

    private FetchArticleList getInstance() {
        if (INSTANCE == null) {
            synchronized (ArticleRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FetchArticleList();
                }
            }
        }
        return INSTANCE;
    }

    public void SendGetRequest() {
        Log.d(TAG, "发送请求");
        this.getInstance().execute();
    }

    public class FetchArticleList extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            Request.sendHttpGetRequest(URI, new HttpCallbackListener() {
                @Override
                public void onResponse(String response) {
                    mAllArticles =
                            ParseList.handleArticleListParse(response);
                }

                @Override
                public void onError(Exception e) {

                }
            });
            return null;
        }
    }
}
