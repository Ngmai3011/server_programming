package project.Bookstore.repository;

import java.util.List;
import project.Bookstore.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
    
}
