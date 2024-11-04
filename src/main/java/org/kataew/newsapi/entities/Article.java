package org.kataew.newsapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;


    @Column(name = "author_id", nullable = false)
    private Long authorId;


    @OneToMany(mappedBy = "articleId", fetch = FetchType.LAZY)
    private List<ArticleImageBlock> imageBlocks;

    @OneToMany(mappedBy = "articleId", fetch = FetchType.LAZY)
    private List<ArticleTextBlock> textBlocks;

    @OneToMany(mappedBy = "articleId", fetch = FetchType.LAZY)
    private List<ArticleQuoteBlock> quoteBlocks;
}