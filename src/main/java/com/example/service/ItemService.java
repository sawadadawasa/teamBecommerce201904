package com.example.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.domain.Item;
import com.example.repository.ItemRepository;



@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;


	public void itemFindAll(Model model){
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findAll();
		model.addAttribute("itemList", itemList);
	}
	
	public void findOne(Model model, Integer id) {
		Item item = new Item();
		item = itemRepository.findOne(id);
		NumberFormat nfNum = NumberFormat.getNumberInstance(); 
		String viewPiece = nfNum.format(item.getPiece());
		model.addAttribute("item", item).addAttribute("viewPiece", viewPiece);
		
	}
	
	public void itemFindMatch(Model model, String code ){
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findMatchItem(code);
		model.addAttribute("itemList", itemList);
	}
	
	/*
	public void articlesSave(String articleName, String articleContent){
		Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
		ArticleBulletinBoard articleBulletinBoard = new ArticleBulletinBoard();
		articleBulletinBoard.setName(articleName);
		articleBulletinBoard.setContent(articleContent);
		articleRepository.save(articleBulletinBoard);
	}
	*/
	/*
	public void commentsSave(String commentsName, String commentsContent, int articleId){
		Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
		CommentsBulletinBoard commentsBulletinBoard = new CommentsBulletinBoard();
		commentsBulletinBoard.setName(commentsName);
		commentsBulletinBoard.setContent(commentsContent);
		commentsBulletinBoard.setArticleId(articleId);
		commentsRepository.save(commentsBulletinBoard);
	}
	*/
	
	/*
	public void acDeleteById(Integer id){
		CommentsBulletinBoard commentsBulletinBoard = new CommentsBulletinBoard();
		ArticleBulletinBoard articleBulletinBoard = new ArticleBulletinBoard();
		commentsBulletinBoard.setArticleId(id);
		articleBulletinBoard.setId(id);
		commentsRepository.deleteById(commentsBulletinBoard);
		articleRepository.deleteById(articleBulletinBoard);
	}
	*/

	
	
}
