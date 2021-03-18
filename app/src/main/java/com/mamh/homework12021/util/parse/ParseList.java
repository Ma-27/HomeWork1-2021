package com.mamh.homework12021.util.parse;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mamh.homework12021.bean.ArticleBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseList {
    private static final String TAG = "ParseList成功";

    public static MutableLiveData<List<ArticleBean>> handleArticleListParse(String response) {
        MutableLiveData<List<ArticleBean>> mLiveArticleList = new MutableLiveData<>();
        List<ArticleBean> mArticles = new ArrayList<>();
        try {
            JSONObject wholeJsonData = new JSONObject(response);
            //从全文中得到data中的数据
            JSONObject data = wholeJsonData.getJSONObject("data");
            //解析datas得到每个item的array
            JSONArray dataArray = data.getJSONArray("datas");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject object = dataArray.getJSONObject(i);
                //FIXME：可能出现空指针
                mArticles.add(new ArticleBean(
                        object.getString("title"), object.getString("link")
                ));
                mLiveArticleList.postValue(mArticles);
            }
        } catch (JSONException e) {
            Log.e(TAG, "handleArticleListParse: ");
            e.printStackTrace();
        }
        return mLiveArticleList;
    }
}
