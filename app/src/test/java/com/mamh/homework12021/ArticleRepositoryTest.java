package com.mamh.homework12021;

import com.mamh.homework12021.repository.ArticleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArticleRepositoryTest {
    ArticleRepository repository;

    @Before
    public void setUp() {
        repository = new ArticleRepository();
    }

    @Test
    public void sendRequest() {
        repository.SendGetRequest();

    }
}
