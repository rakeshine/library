package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	/**
	 * To record transaction of a user while borrowing one or more articles
	 * 
	 * @param id
	 * @param articleTitles
	 * @return
	 */
	@PostMapping("borrowArticle/{userId}")
	public ResponseEntity<String> borrowArticle(@PathVariable(name = "userId", required = true) int id,
			@RequestBody(required = true) List<String> articleTitles) {
		return transactionService.borrowArticles(id, articleTitles);
	}

	/**
	 * To record transaction of a user while one or more articles is returned to the library
	 * 
	 * @param id
	 * @param articleTitles
	 * @return
	 */
	@PostMapping("returnArticle/{userId}")
	public ResponseEntity<String> returnArticle(@PathVariable(name = "userId", required = true) int id,
			@RequestBody(required = true) List<String> articleTitles) {
		return transactionService.returnArticles(id, articleTitles);
	}
}
