package services;

import com.studentmanagment.managers.StudentManager;
import com.studentmanagment.models.Students;

import java.util.List;
import static java.lang.Integer.parseInt;

public class StudentsService {

    StudentManager studentManager = new StudentManager();

    public Students getStudent(String id) {
        return studentManager.getStudent(parseInt(id));
    }

    public List getAllStudents() {
        return studentManager.listStudents();
    }

    public void updateAge(String id, int age) {
        studentManager.updateStudent(parseInt(id), age);
    }

    public void deleteStudent(int id) {
        studentManager.deleteStudent(id);
    }

    public void addStudent(String name, int age) {
        studentManager.addStudent(name, age);
    }
}
