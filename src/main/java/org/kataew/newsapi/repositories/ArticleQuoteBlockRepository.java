package org.kataew.newsapi.repositories;

import org.kataew.newsapi.entities.ArticleQuoteBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleQuoteBlockRepository extends JpaRepository<ArticleQuoteBlock, Long> {
}