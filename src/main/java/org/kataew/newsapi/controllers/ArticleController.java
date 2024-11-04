package org.kataew.newsapi.controllers;


import lombok.RequiredArgsConstructor;
import org.kataew.newsapi.entities.Article;
import org.kataew.newsapi.services.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        Article article = articleService.getById(id);
        return ResponseEntity.ok(article);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.create(article);
        return ResponseEntity.ok(createdArticle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Article article = articleService.update(id, updatedArticle);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity.ok("Статья удалена");
    }



}
