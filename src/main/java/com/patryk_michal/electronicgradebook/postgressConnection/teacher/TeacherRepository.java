package com.patryk_michal.electronicgradebook.postgressConnection.teacher;

import com.patryk_michal.electronicgradebook.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
