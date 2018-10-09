package guru.springframework.spring5webpage.repository;

import guru.springframework.spring5webpage.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
