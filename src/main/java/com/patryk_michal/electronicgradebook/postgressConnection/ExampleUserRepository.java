package com.patryk_michal.electronicgradebook.postgressConnection;

import com.patryk_michal.electronicgradebook.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface ExampleUserRepository extends CrudRepository<Student, Long> {
}
