package org.kataew.newsapi.repositories;

import org.kataew.newsapi.entities.ArticleImageBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleImageBlockRepository extends JpaRepository<ArticleImageBlock, Long> {
}