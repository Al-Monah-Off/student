package exam.student.student.controllers;

import exam.student.student.domain.Student;
import exam.student.student.exceptions.StudentNotFound;
import exam.student.student.repo.StudentsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentsRepo studentsRepo;

    @Autowired
    public StudentController(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    //получить список всех студентов
    @GetMapping
    public List<Student> getAll(){
        return (List<Student>) studentsRepo.findAll();
    }

    //добавить студента
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentsRepo.save(student);
    }
    //получить студента по id
    @GetMapping("{id}")
    public Student getOne(@PathVariable(value = "id") Long id) throws StudentNotFound {
        return studentsRepo.findById(id)
                .orElseThrow(StudentNotFound::new);
    }
    //обновить студента по id
    @PutMapping("{id}")
    public Student update(@PathVariable("id") Long id,
                          @RequestBody Student student)throws StudentNotFound
    {
        Student byId = studentsRepo.findById(id).orElseThrow(StudentNotFound::new);
        BeanUtils.copyProperties(student,byId,"id");
        return studentsRepo.save(byId);
    }
    //удалить
    @DeleteMapping("id")
    public void delete(@PathVariable("id")Long id)throws StudentNotFound{
        Student student = studentsRepo.findById(id).orElseThrow(StudentNotFound::new);
        studentsRepo.delete(student);
    }
}
