package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.Sightword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightwordRepository extends CrudRepository<Sightword, Integer> {
}
