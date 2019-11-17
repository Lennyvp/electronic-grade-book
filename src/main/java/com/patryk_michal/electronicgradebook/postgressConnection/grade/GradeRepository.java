package com.patryk_michal.electronicgradebook.postgressConnection.grade;

import com.patryk_michal.electronicgradebook.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {


}
