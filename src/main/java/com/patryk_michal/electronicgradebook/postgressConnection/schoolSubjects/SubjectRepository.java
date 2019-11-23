package com.patryk_michal.electronicgradebook.postgressConnection.schoolSubjects;

import com.patryk_michal.electronicgradebook.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
