package org.kataew.newsapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "article_text_block")
public class ArticleTextBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_text_block_id", nullable = false)
    private Long id;

    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @Column(name = "\"position\"", nullable = false)
    private Long position;

    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

}