package mappings.controller;

import mappings.entity.AuthorEntity;
import mappings.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/id/{authorId}")
    public AuthorEntity getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @PostMapping
    public AuthorEntity createNewAuthor(@RequestBody AuthorEntity authorEntity){
        return authorService.createNewAuthor(authorEntity);
    }

    @GetMapping(path = "/name/{authorName}")
    public AuthorEntity getAuthorByName(@PathVariable String authorName){
        return authorService.getAuthorByName(authorName);
    }

    @PutMapping(path = "/update/{authorId}")
    public AuthorEntity updateAuthorById(@RequestBody AuthorEntity authorEntity, @PathVariable Long authorId){
        authorEntity.setId(authorId);
        return authorService.updateAuthorById( authorEntity);
    }

    @DeleteMapping(path = "/{authorId}")
    public ResponseEntity<Boolean> deleteAuthorById(@PathVariable Long authorId){
        boolean gotDeleted =  authorService.deleteAuthorById(authorId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
