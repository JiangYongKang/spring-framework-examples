package com.vincent.spring.framework.example;

import java.util.List;

/**
 * author: vincent
 * date: 2019-05-19 23:44
 * comment:
 */

public interface ArticleService {

    /**
     * 获取文章列表
     * @return
     */
    List<Article> list();

    /**
     * 查询单个文章
     * @param id
     * @return
     */
    Article find(Integer id);

    /**
     * 保存文章
     * @param article
     * @return
     */
    boolean save(Article article);

    /**
     * 更新文章
     * @param article
     * @return
     */
    boolean update(Article article);

    /**
     * 删除文章
     * @param article
     * @return
     */
    boolean delete(Article article);

}
