package org.kataew.newsapi.controllers;

import org.kataew.newsapi.entities.ArticleTextBlock;
import org.kataew.newsapi.services.ArticleTextBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article-text-blocks")
public class ArticleTextBlockController {

    @Autowired
    private ArticleTextBlockService service;

    @PostMapping
    public ArticleTextBlock create(@RequestBody ArticleTextBlock block) {
        return service.create(block);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleTextBlock> update(@PathVariable Long id, @RequestBody ArticleTextBlock newBlock) {
        return service.update(id, newBlock)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("deleted");
    }
}
