package project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import project.Bookstore.entity.Book;
import project.Bookstore.repository.BookRepository;
import project.Bookstore.entity.Category;
import project.Bookstore.repository.CategoryRepository;
import project.Bookstore.entity.User;
import project.Bookstore.repository.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository caterepository, UserRepository userepository) {
		return (args) -> {
			log.info("Save some books");
			
			caterepository.save(new Category("Arts & Music"));
			caterepository.save(new Category("Comics"));
			caterepository.save(new Category("Cooking"));
			caterepository.save(new Category("Horror"));
			caterepository.save(new Category("Novel"));

			
			repository.save(new Book(1L,"Ernest Hemingway","A farewell to Arms","1232323-21",1929, caterepository.findByName("Novel").get(0)));
			repository.save(new Book(2L,"George Orwell","Animal Farm","2212343-5",1945,caterepository.findByName("Novel").get(0)));
			
			User user = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userepository.save(user);
			userepository.save(admin);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
