package guru.springframework.spring5webpage.bootstrap;

import guru.springframework.spring5webpage.model.Author;
import guru.springframework.spring5webpage.model.Book;
import guru.springframework.spring5webpage.model.Publisher;
import guru.springframework.spring5webpage.repository.AuthorRepository;
import guru.springframework.spring5webpage.repository.BookRepository;
import guru.springframework.spring5webpage.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // constructor auto injection that will be handled by Spring


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher p1 = new Publisher("12313", "asdasd");
        Publisher p2 = new Publisher("3453453452", "vsfdfsfs");
        publisherRepository.save(p1);
        publisherRepository.save(p2);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", p1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev without EJB", "12345", p2);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
