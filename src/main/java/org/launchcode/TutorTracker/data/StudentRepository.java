package org.launchcode.TutorTracker.data;

import org.launchcode.TutorTracker.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
