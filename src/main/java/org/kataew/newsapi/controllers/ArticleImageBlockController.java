package org.kataew.newsapi.controllers;

import org.kataew.newsapi.entities.ArticleImageBlock;
import org.kataew.newsapi.services.ArticleImageBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article-image-blocks")
public class ArticleImageBlockController {

    @Autowired
    private ArticleImageBlockService service;

    @PostMapping
    public ArticleImageBlock create(@RequestBody ArticleImageBlock block) {
        return service.create(block);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleImageBlock> update(@PathVariable Long id, @RequestBody ArticleImageBlock newBlock) {
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
