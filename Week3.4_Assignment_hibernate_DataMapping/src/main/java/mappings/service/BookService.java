package mappings.service;

import mappings.entity.AuthorEntity;
import mappings.entity.BookEntity;
import mappings.repository.AuthorRepository;
import mappings.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public BookEntity getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public BookEntity createNewBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public BookEntity getBookByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle).orElse(null);
    }

    public boolean deleteBookById(Long bookId) {
        boolean exist = bookRepository.existsById(bookId);
        if (!exist) throw new RuntimeException("Book not found");
        bookRepository.deleteById(bookId);
        return true;
    }

    public List<BookEntity> getBookByPublishedDate(LocalDate publicationDate) {
        return bookRepository.findByPublishedDateAfter(publicationDate);
    }

    public List<BookEntity> getAllBook() {
        return bookRepository.findAll();
    }

    public BookEntity updateBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public List<BookEntity> findBooksByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }


    public BookEntity assignBookToAuthor(Long bookId, String authorName) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        Optional<AuthorEntity> authorEntity = authorRepository.findByName(authorName);

        return bookEntity.flatMap(book ->
                authorEntity.map(author -> {
                    // Set the author of the book
                    book.setAuthor(author);

                    // Add the book to the author's list of books
                    author.getPublishedBooks().add(book);

                    // Save both the author and the book to persist the changes
                    authorRepository.save(author);
                    bookRepository.save(book);
                    return book;
                })
        ).orElse(null);
    }
}
