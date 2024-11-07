package mappings.repository;

import mappings.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional <BookEntity> findByTitle(String bookTitle);

    List <BookEntity> findByPublishedDateAfter(LocalDate publicationDate);
    List <BookEntity> findByAuthorName(String authorName);
}
