package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
