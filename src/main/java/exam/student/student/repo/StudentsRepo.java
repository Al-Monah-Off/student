package exam.student.student.repo;

import exam.student.student.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends CrudRepository<Student,Long> {
}
