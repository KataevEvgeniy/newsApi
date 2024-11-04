package org.kataew.newsapi.repositories;

import org.kataew.newsapi.entities.Article;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @EntityGraph(attributePaths = {"imageBlocks", "textBlocks", "quoteBlocks"})
    Optional<Article> findById(Long id);
}