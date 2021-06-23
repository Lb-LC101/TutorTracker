package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.SightWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightWordRepository extends CrudRepository<SightWord, Integer> {
}
