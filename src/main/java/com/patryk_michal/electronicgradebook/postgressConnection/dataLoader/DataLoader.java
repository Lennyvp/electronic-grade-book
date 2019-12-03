package com.patryk_michal.electronicgradebook.postgressConnection.dataLoader;

import com.patryk_michal.electronicgradebook.model.Grade;
import com.patryk_michal.electronicgradebook.model.Student;
import com.patryk_michal.electronicgradebook.model.Subject;
import com.patryk_michal.electronicgradebook.postgressConnection.grade.GradeRepository;
import com.patryk_michal.electronicgradebook.postgressConnection.schoolSubjects.SubjectRepository;
import com.patryk_michal.electronicgradebook.postgressConnection.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Student student1 = new Student("Slogin","SPassword","Sname","Ssurname","2c");
        Student student2 = new Student("S2login","S2Password","S2name","S2surname","3b");
        Student student3 = new Student("S3login","S3Password","S3name","S3surname","6a");

        LocalDateTime localDateTime1 = LocalDateTime.of(2018,9,15,8,35,20);
        LocalDateTime localDateTime2 = LocalDateTime.of(2017,10,5,20,32);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        Subject polish = new Subject("Polski");
        Subject english = new Subject("Angielski");
        Subject maths = new Subject("Matematyka");

        subjectRepository.save(polish);
        subjectRepository.save(english);
        subjectRepository.save(maths);

        Grade grade1 = new Grade(5,LocalDateTime.now(),student1, polish);
        Grade grade2 = new Grade(3,LocalDateTime.now(),student2,polish);
        Grade grade3 = new Grade(3,localDateTime1,student3,english);
        Grade grade4 = new Grade(4,localDateTime1,student2,maths);
        Grade grade5 = new Grade(6,localDateTime2,student1,english);
        Grade grade6 = new Grade(1,LocalDateTime.now(),student1, polish);
        Grade grade7 = new Grade(2,LocalDateTime.now(),student1, polish);
        Grade grade8 = new Grade(3,LocalDateTime.now(),student1, polish);
        Grade grade9 = new Grade(4,LocalDateTime.now(),student1, polish);
        Grade grade10 = new Grade(5,LocalDateTime.now(),student1, polish);

        gradeRepository.save(grade1);
        gradeRepository.save(grade2);
        gradeRepository.save(grade3);
        gradeRepository.save(grade4);
        gradeRepository.save(grade5);
        gradeRepository.save(grade6);
        gradeRepository.save(grade7);
        gradeRepository.save(grade8);
        gradeRepository.save(grade9);
        gradeRepository.save(grade10);

    }
}
