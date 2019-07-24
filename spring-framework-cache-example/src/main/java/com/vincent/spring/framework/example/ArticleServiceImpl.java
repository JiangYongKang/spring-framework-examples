package com.vincent.spring.framework.example;

import java.util.ArrayList;
import java.util.List;

/**
 * author: vincent
 * date: 2019-06-09 14:06
 * comment:
 */

public class ArticleServiceImpl implements ArticleService {

    private static final List<Article> articleStore = new ArrayList<>();

    @Override
    public List<Article> list() {
        return articleStore;
    }

    @Override
    public Article find(Integer id) {
        return articleStore.stream()
                .filter(article -> article.getId().equals(id))
                .findAny().orElse(null);
    }

    @Override
    public boolean save(Article article) {
        return articleStore.add(article);
    }

    @Override
    public boolean update(Article article) {
        if (articleStore.removeIf(e -> e.getId().equals(article.getId()))) {
            articleStore.add(article);
        }
        return true;
    }

    @Override
    public boolean delete(Article article) {
        return articleStore.removeIf(e -> e.getId().equals(article.getId()));
    }
}
