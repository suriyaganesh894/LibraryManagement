package com.webapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.webapp.demo.dao.LibraryDao;
import com.webapp.demo.library.Library;
@RestController
public class LibraryController {
	
	@Autowired
	LibraryDao dao;
	@RequestMapping("/saveBook")
	@ResponseBody
	public void saveBook(@RequestParam String bookId,@RequestParam String quantity ,@RequestParam String bookName,@RequestParam String genre,Library obj) {
	
		
		obj.setBookId(bookId);
		obj.setBookName(bookName);
		obj.setGenre(genre);
		obj.setQuantity(quantity);
		System.out.println("book saved");
		dao.save(obj);
	}
	
	@RequestMapping("/getByType")
	@ResponseBody
	public List<Library> getByType(@RequestParam String genre,Library obj) {
		
		return dao.getByType(genre);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteById(@RequestParam String id) {
	
		 dao.delete(id);
		 System.out.println("deleted");
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public void updateById(@RequestParam String id,@RequestParam String bname) {
		
		 dao.update(id, bname);
		 System.out.println("updated");
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Library> getAll() {
		
		 return dao.findAll();
		 
	}
	
	
	
}
