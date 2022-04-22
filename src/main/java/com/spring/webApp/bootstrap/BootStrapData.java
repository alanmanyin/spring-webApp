package com.spring.webApp.bootstrap;

import com.spring.webApp.domain.Author;
import com.spring.webApp.domain.Book;
import com.spring.webApp.domain.Publisher;
import com.spring.webApp.repositories.AuthorRepository;
import com.spring.webApp.repositories.BookRepository;
import com.spring.webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "978-0321125217-0");
        bookRepository.save(ddd);
        Publisher aw = new Publisher("Addison-Wesley Professional", "80 Strand", "London", "United Kingdom", "WC2R 0RL");
        publisherRepository.save(aw);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(aw);
        aw.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(aw);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "978-0-764-57390-0");
        bookRepository.save(noEjb);
        Publisher wiley = new Publisher("Wiley", "111 River St", "Hoboken", "United States", "NJ 07030");
        publisherRepository.save(wiley);

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(wiley);
        wiley.getBooks().add(noEjb);

        authorRepository.save(rod);
        publisherRepository.save(wiley);
        bookRepository.save(noEjb);

        System.out.println(wiley);
        System.out.println(aw);
    }
}
