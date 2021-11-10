package exam.student.student.domain;

import javax.persistence.*;

/*Необходимо разработать службу предоставляющую доступ к операциям над объектами из БД.
        Для БД с студентами нужно реализовать следующие операции:
        получение списка всех студентов
        получение информации о определенном студенте.
         (ФИО, группа,  средний балл, имеется ли стипендия)
        обновление данных студента.
        отчисление студента.
        назначение стипендии студенту(стипендия назначается на 1 семестр)
        Накидать в вашу БД около 10 студентов.*/

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //ФИО
    private String name;
    private String surname;
    private String patronymic;
    //средний балл
    private int averageScore;
    //степендия
    private boolean scholarship;
    //отчислен
    private boolean deducted;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public boolean isDeducted() {
        return deducted;
    }

    public void setDeducted(boolean deducted) {
        this.deducted = deducted;
    }
}
