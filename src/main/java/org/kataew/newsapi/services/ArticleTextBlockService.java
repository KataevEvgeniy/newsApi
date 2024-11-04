package org.kataew.newsapi.services;


import lombok.RequiredArgsConstructor;
import org.kataew.newsapi.entities.ArticleTextBlock;
import org.kataew.newsapi.entities.User;
import org.kataew.newsapi.repositories.ArticleRepository;
import org.kataew.newsapi.repositories.ArticleTextBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleTextBlockService {

    private final ArticleTextBlockRepository repository;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    public ArticleTextBlock create(ArticleTextBlock block) {
        validateAuthor(block.getArticleId());
        return repository.save(block);
    }

    public Optional<ArticleTextBlock> update(Long id, ArticleTextBlock newBlock) {
        ArticleTextBlock existingBlock = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Текстовый блок не найден"));

        validateAuthor(existingBlock.getArticleId());

        existingBlock.setPosition(newBlock.getPosition());
        existingBlock.setContent(newBlock.getContent());
        return Optional.of(repository.save(existingBlock));
    }

    @Transactional
    public void delete(Long id) {
        ArticleTextBlock block = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Текстовый блок не найден"));

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