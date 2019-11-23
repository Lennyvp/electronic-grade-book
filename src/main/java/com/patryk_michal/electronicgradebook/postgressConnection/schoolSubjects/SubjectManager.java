package com.patryk_michal.electronicgradebook.postgressConnection.schoolSubjects;


import com.patryk_michal.electronicgradebook.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectManager {

    @Autowired
    private SubjectRepository subjectRepository;


    public void saveSubject(Subject subject){
        subjectRepository.save(subject);
    }



}
