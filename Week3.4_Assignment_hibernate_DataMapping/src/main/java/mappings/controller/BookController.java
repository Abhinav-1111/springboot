package mappings.controller;

import mappings.entity.AuthorEntity;
import mappings.entity.BookEntity;
import mappings.service.BookService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/{bookId}")
    public BookEntity getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping
    public List<BookEntity> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping(path = "/authorName")
    public List<BookEntity> findBooksByAuthorName(@RequestParam String authorName){
        return bookService.findBooksByAuthorName(authorName);
    }


    @PostMapping
    public BookEntity createNewBook(@RequestBody BookEntity bookEntity){
        return bookService.createNewBook(bookEntity);
    }

    @GetMapping(path = "/title/{bookTitle}")
    public BookEntity getBookByTitle(@PathVariable String bookTitle){
        return bookService.getBookByTitle(bookTitle);
    }

    @PutMapping(path = "/update/{bookId}")
    public BookEntity updateBook(@RequestBody BookEntity bookEntity, @PathVariable Long bookId){
        bookEntity.setId(bookId);
        return bookService.updateBook( bookEntity);
    }

    @PutMapping(path = "/assign/{bookId}/to/{authorName}")
    public BookEntity assignBookToAuthor(@PathVariable Long bookId, @PathVariable String authorName){
        return bookService.assignBookToAuthor(bookId, authorName);
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<Boolean> deleteBookById(@PathVariable Long bookId){
        boolean gotDeleted =  bookService.deleteBookById(bookId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/date/{publicationDate}")
    public List<BookEntity> getBookByPublishedDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE )LocalDate publicationDate){
        return bookService.getBookByPublishedDate(publicationDate);
    }

}
