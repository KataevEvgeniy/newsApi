package org.kataew.newsapi.repositories;

import org.kataew.newsapi.entities.ArticleTextBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTextBlockRepository extends JpaRepository<ArticleTextBlock, Long> {
}