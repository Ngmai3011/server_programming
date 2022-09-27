package project.Bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import project.Bookstore.entity.Book;
import project.Bookstore.repository.BookRepository;
//import project.Bookstore.entity.Category;
import project.Bookstore.repository.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; 
	
	@Autowired
	private CategoryRepository caterepository; 
	
	@GetMapping(value="/books")
	public @ResponseBody List<Book> bookListRest() {
			return (List<Book>) repository.findAll();
	}
			
	@GetMapping(value={"/", "/booklist"})
	public String bookList(Model model) {
			model.addAttribute("books", repository.findAll());
			return "booklist";

	}
	
	@GetMapping(value="/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
			return repository.findById(bookId);
	}
	
	@GetMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("category", caterepository.findAll());
        return "addbook";
    }     
    
    @PostMapping(value = "/save")
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);
        return "redirect:../booklist";
    }    

    @GetMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("book", repository.findById(id));
    	model.addAttribute("category", caterepository.findAll());
    	return "editbook";
    }   
}



