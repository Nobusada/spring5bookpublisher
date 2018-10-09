package guru.springframework.spring5webpage.repository;

import guru.springframework.spring5webpage.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
