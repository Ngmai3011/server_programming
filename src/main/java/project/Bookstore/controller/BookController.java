package project.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import project.Bookstore.entity.Book;
import project.Bookstore.repository.BookRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	
	@GetMapping("/booklist")
	public String bookList(Model model) {
			model.addAttribute("books", repository.findAll());
			return "booklist";

	}
	
	@GetMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @PostMapping(value = "/save")
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);
        return "redirect:../booklist";
    }     
	}



