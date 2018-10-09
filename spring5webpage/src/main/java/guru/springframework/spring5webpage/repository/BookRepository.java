package guru.springframework.spring5webpage.repository;

import guru.springframework.spring5webpage.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
