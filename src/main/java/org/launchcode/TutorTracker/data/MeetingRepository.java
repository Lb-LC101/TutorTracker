package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Integer> {
}
