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
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd =  new Book("Domain Driven Design", "12345324132");
        Publisher wiley = new Publisher("Wiley", "111 River St",  "Hoboken", "United States", "NJ 07030");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "12312455334");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }
}
