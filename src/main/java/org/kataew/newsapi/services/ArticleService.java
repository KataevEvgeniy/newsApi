package org.kataew.newsapi.services;

import lombok.RequiredArgsConstructor;
import org.kataew.newsapi.entities.Article;
import org.kataew.newsapi.entities.User;
import org.kataew.newsapi.repositories.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;
    private final UserService userService;

    public Article create(Article article) {
        User currentUser = userService.getCurrentUser();
        article.setAuthorId(currentUser.getId()); // Устанавливаем автора
        return repository.save(article);
    }


    public Article getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Статья не найдена"));
    }

    public Article getArticleWithBlocks(Long articleId) {
        return repository.findById(articleId).get();
    }


    @Transactional
    public Article update(Long id, Article updatedArticle) {
        Article existingArticle = getById(id);
        User currentUser = userService.getCurrentUser();

        if (!existingArticle.getAuthorId().equals(currentUser.getId())) {
            throw new RuntimeException("Нет прав для редактирования этой статьи");
        }

        existingArticle.setTitle(updatedArticle.getTitle());
        // Дополнительные поля, такие как блоки текста, изображения, цитаты, можно обновить аналогичным образом

        return repository.save(existingArticle);
    }


    public void delete(Long id) {
        Article article = getById(id);
        User currentUser = userService.getCurrentUser();

        if (!article.getAuthorId().equals(currentUser.getId())) {
            throw new RuntimeException("Нет прав для удаления этой статьи");
        }

        repository.delete(article);
    }
}
