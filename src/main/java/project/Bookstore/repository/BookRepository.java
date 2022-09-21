package project.Bookstore.repository;

import java.util.List;
import project.Bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
    
}