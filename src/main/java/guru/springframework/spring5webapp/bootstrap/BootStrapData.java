package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        Publisher mkEditora = new Publisher("MK Music", "Rua Gotemburgo", "rio", "RJ", "20850-300");
        publisherRepository.save(mkEditora);
        System.out.println("Publisher count: " + publisherRepository.count());

        Author mac = new Author("Marcelo", "Assis");
        Book macBook = new Book("Snake Ways", "7578662000");

        mac.getBooks().add(macBook);
        macBook.getAuthors().add(mac);

        authorRepository.save(mac);
        bookRepository.save(macBook);

        Author brooke = new Author("Bruna", "Melo");
        Book bBook = new Book("How to Croche", "8744662000");

        brooke.getBooks().add(bBook);
        bBook.getAuthors().add(brooke);

        authorRepository.save(brooke);
        bookRepository.save(bBook);

        System.out.println("Bootstrap");
        System.out.println("# Books:" + bookRepository.count());
    }
}
