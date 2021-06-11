package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer> {
}
