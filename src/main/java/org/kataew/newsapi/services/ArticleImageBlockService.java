package org.kataew.newsapi.services;

import lombok.RequiredArgsConstructor;
import org.kataew.newsapi.entities.ArticleImageBlock;
import org.kataew.newsapi.entities.User;
import org.kataew.newsapi.repositories.ArticleImageBlockRepository;
import org.kataew.newsapi.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleImageBlockService {

    private final ArticleImageBlockRepository repository;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    public ArticleImageBlock create(ArticleImageBlock block) {
        validateAuthor(block.getArticleId());
        return repository.save(block);
    }

    public Optional<ArticleImageBlock> update(Long id, ArticleImageBlock newBlock) {
        ArticleImageBlock existingBlock = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Блок изображения не найден"));

        validateAuthor(existingBlock.getArticleId());

        existingBlock.setPosition(newBlock.getPosition());
        existingBlock.setImageUrl(newBlock.getImageUrl());
        existingBlock.setCaption(newBlock.getCaption());
        return Optional.of(repository.save(existingBlock));
    }

    public void delete(Long id) {
        ArticleImageBlock block = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Блок изображения не найден"));

        validateAuthor(block.getArticleId());
        repository.deleteById(block.getId());
        repository.flush();
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
