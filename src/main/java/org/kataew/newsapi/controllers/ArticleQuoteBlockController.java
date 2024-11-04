package org.kataew.newsapi.controllers;


import org.kataew.newsapi.entities.ArticleQuoteBlock;
import org.kataew.newsapi.services.ArticleQuoteBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article-quote-blocks")
public class ArticleQuoteBlockController {

    @Autowired
    private ArticleQuoteBlockService service;

    @PostMapping
    public ArticleQuoteBlock create(@RequestBody ArticleQuoteBlock block) {
        return service.create(block);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleQuoteBlock> update(@PathVariable Long id, @RequestBody ArticleQuoteBlock newBlock) {
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