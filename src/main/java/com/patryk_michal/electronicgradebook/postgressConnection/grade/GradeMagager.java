package com.patryk_michal.electronicgradebook.postgressConnection.grade;

import com.patryk_michal.electronicgradebook.model.Grade;
import com.patryk_michal.electronicgradebook.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class GradeMagager {

    @Autowired
    private GradeRepository gradeRepository;

    public void saveGrade(Grade grade){
        gradeRepository.save(grade);
    }

}
