package project.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import project.Bookstore.domain.Book;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String book(Model model) {
//				model.addAttribute("books", book);

	}
	}



