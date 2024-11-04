package org.kataew.newsapi.services;

import lombok.RequiredArgsConstructor;
import org.kataew.newsapi.entities.ArticleQuoteBlock;
import org.kataew.newsapi.entities.User;
import org.kataew.newsapi.repositories.ArticleQuoteBlockRepository;
import org.kataew.newsapi.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleQuoteBlockService {

    private final ArticleQuoteBlockRepository repository;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    public ArticleQuoteBlock create(ArticleQuoteBlock block) {
        validateAuthor(block.getArticleId());
        return repository.save(block);
    }

    public Optional<ArticleQuoteBlock> update(Long id, ArticleQuoteBlock newBlock) {
        ArticleQuoteBlock existingBlock = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Цитатный блок не найден"));

        validateAuthor(existingBlock.getArticleId());

        existingBlock.setPosition(newBlock.getPosition());
        existingBlock.setQuote(newBlock.getQuote());
        existingBlock.setAuthor(newBlock.getAuthor());
        return Optional.of(repository.save(existingBlock));
    }

    public void delete(Long id) {
        ArticleQuoteBlock block = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Цитатный блок не найден"));

        validateAuthor(block.getArticleId());
        repository.delete(block);
    }

    private void validateAuthor(Long articleId) {
        User currentUser = userService.getCurrentUser();
        Long authorId = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Статья не найдена"))
                .getAuthorId();

        if (!authorId.equals(currentUser.getId())) {
            throw new RuntimeException("Нет прав на редактирование/удаление блока этой статьи");
        }
    }
}
