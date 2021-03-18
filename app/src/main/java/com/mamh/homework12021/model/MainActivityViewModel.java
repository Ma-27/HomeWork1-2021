package com.mamh.homework12021.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mamh.homework12021.bean.ArticleBean;
import com.mamh.homework12021.repository.ArticleRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<List<ArticleBean>> mAllArticles;
    private final ArticleRepository articleRepository;

    public MainActivityViewModel() {
        articleRepository = new ArticleRepository();
        mAllArticles = articleRepository.getAllArticles();
    }

    public MutableLiveData<List<ArticleBean>> getAllArticles() {
        articleRepository.SendGetRequest();
        mAllArticles.setValue(articleRepository.getAllArticles().getValue());
        return mAllArticles;
    }
}
