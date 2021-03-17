package com.mamh.homework12021.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mamh.homework12021.bean.ArticleBean;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private LiveData<List<ArticleBean>> mAllArticles;
}
