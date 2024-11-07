package mappings.service;

import mappings.entity.AuthorEntity;
import mappings.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorEntity getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

    public AuthorEntity createNewAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    public AuthorEntity getAuthorByName(String authorName) {
        return authorRepository.findByName(authorName).orElse(null);
    }

    public boolean deleteAuthorById(Long authorId) {
        boolean exist = authorRepository.existsById(authorId);
        if (!exist) throw new RuntimeException("Author not found");
        authorRepository.deleteById(authorId);
        return true;
    }


    public AuthorEntity updateAuthorById(AuthorEntity authorEntity) {
        return authorRepository.save( authorEntity);
    }

    public List<AuthorEntity> getAllAuthor() {
        return authorRepository.findAll();
    }
}
