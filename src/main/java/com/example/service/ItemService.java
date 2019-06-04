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
	
	//全商品一覧を表示
	public void itemFindAll(Model model){
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findAll();
		model.addAttribute("itemList", itemList);
	}
	
	//原産地リスト
	public void itemOriginList(Model model) {
		List<String> originList = new ArrayList<>();
		originList = itemRepository.itemOriginList();
		model.addAttribute("originList", originList);
	}
	//パック数リスト
	public void itemPieceList(Model model) {
		List<Integer> pieceList = new ArrayList<>();
		pieceList = itemRepository.itemPieceList();
		model.addAttribute("pieceList", pieceList);
	}
	
	//商品詳細ページを表示
	public void findOne(Model model, Integer id) {
		//商品の詳細
		Item item = new Item();
		item = itemRepository.findOne(id);
		
		//個数1~10を表示
		Integer quantityList[] = new Integer[10];
		for (int i = 0; i < quantityList.length ; i++) {
			quantityList[i] = i+1 ;
		}
		model.addAttribute("item", item).addAttribute("quantityList", quantityList);;
	}
	
	//商品名あいまい検索
	public void itemFindMatch( String code, String origin, String piece, Model model ){
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findMatchItem(code, origin, piece);
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
