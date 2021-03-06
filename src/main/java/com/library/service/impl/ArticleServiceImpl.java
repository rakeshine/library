package com.library.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Article;
import com.library.repository.ArticleRepository;
import com.library.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepo;

	/**
	 * To get all articles
	 */
	@Override
	public List<Article> getArticles() {
		return articleRepo.findAll();
	}

	/**
	 * Get article for given ID
	 */
	@Override
	public Article getArticle(int id) {
		Optional<Article> articleOptional = articleRepo.findById(id);
		if (articleOptional.isPresent()) {
			return articleOptional.get();
		}
		return null;
	}

	/**
	 * To add a new article
	 */
	@Override
	@Transactional
	public void addArticle(Article article) {
		articleRepo.save(article);
	}

	/**
	 * To delete an existing article
	 */
	@Override
	public boolean deleteArticle(int id) {
		Optional<Article> article = articleRepo.findById(id);
		if (article.isPresent()) {
			articleRepo.delete(article.get());
			return true;
		}

		return false;
	}

}
