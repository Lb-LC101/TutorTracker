package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Integer> {
}
