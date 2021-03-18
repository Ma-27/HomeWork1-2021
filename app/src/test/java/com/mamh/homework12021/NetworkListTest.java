package com.mamh.homework12021;

import com.mamh.homework12021.repository.ArticleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class NetworkListTest {
    ArticleRepository repository;

    @Before
    public void setUp() {
        repository = new ArticleRepository();
    }

    @Test
    public void sendRequest() {
        repository.SendGetRequest();
        assertThat(repository.getAllArticles(), is(""));
    }
}
