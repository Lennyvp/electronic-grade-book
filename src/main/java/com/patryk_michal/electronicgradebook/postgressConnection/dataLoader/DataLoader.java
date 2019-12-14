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

        Student student1 = new Student("Slogin","SPassword","Anrzej","Wojciechowski","MALE","6a");
        Student student2 = new Student("S2login","S2Password","Anna","Nowak","FEMALE","3b");
        Student student3 = new Student("S3login","S3Password","Jan","Kowalski","MALE","6a");
        Student student4 = new Student("S4login","S4Password","Andrzej","Wójcik","MALE","6a");
        Student student5 = new Student("S5login","S5Password","Katarzyna","Wiśniewska","FEMALE","6a");
        Student student6 = new Student("S6login","S6Password","Anna","Wysocka","FEMALE","6a");
        Student student7 = new Student("S7login","S7Password","Michał","Jankowski","MALE","6a");

        LocalDateTime localDateTime1 = LocalDateTime.of(2018,9,15,8,35,20);
        LocalDateTime localDateTime2 = LocalDateTime.of(2017,10,5,20,32);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);

        Subject polish = new Subject("Polski");
        Subject english = new Subject("Angielski");
        Subject maths = new Subject("Matematyka");
        Subject physics = new Subject("Fizyka");
        Subject biology = new Subject("Biologia");
        Subject chemistry = new Subject("Chemia");

        subjectRepository.save(polish);
        subjectRepository.save(english);
        subjectRepository.save(maths);
        subjectRepository.save(physics);
        subjectRepository.save(biology);
        subjectRepository.save(chemistry);

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
        Grade grade11 = new Grade(5,LocalDateTime.now(),student1, physics);
        Grade grade12 = new Grade(5,LocalDateTime.now(),student1, physics);
        Grade grade13 = new Grade(4,LocalDateTime.now(),student1, physics);
        Grade grade14 = new Grade(6,LocalDateTime.now(),student1, biology);
        Grade grade15 = new Grade(5,LocalDateTime.now(),student1, biology);
        Grade grade16 = new Grade(3,LocalDateTime.now(),student1, chemistry);
        Grade grade17 = new Grade(4,LocalDateTime.now(),student1, chemistry);
        Grade grade18 = new Grade(2,LocalDateTime.now(),student1, maths);


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
        gradeRepository.save(grade11);
        gradeRepository.save(grade12);
        gradeRepository.save(grade13);
        gradeRepository.save(grade14);
        gradeRepository.save(grade15);
        gradeRepository.save(grade16);
        gradeRepository.save(grade17);
        gradeRepository.save(grade18);

    }
}
