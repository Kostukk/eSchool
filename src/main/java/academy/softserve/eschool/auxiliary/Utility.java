package academy.softserve.eschool.auxiliary;

import academy.softserve.eschool.dto.StudentDTO;
import academy.softserve.eschool.dto.TeacherDTO;
import academy.softserve.eschool.model.Clazz;
import academy.softserve.eschool.model.Student;
import academy.softserve.eschool.model.User;

/**
 * The utility class created to transform the DTO to model, and vice versa.
 */
public class Utility {

    /**
     * Transform {@link Student} to {@link StudentDTO}.
     * @param student object with data for transformation.
     * @return {@link StudentDTO} created from student.
     */
    public static StudentDTO transform(Student student){
        return StudentDTO.builder().firstname(student.getFirstName())
                .lastname(student.getLastName())
                .patronymic(student.getPatronymic())
                .login(student.getLogin())
                .dateOfBirth(student.getDateOfBirth())
                .classe(student.getClasses().stream().filter(Clazz::isActive).findFirst().orElseGet(Clazz::new).getName())
                .email(student.getEmail())
                .avatar(student.getAvatar())
                .phone(student.getPhone()).build();
    }

    /**
     * Transform {@link User} to {@link TeacherDTO}.
     * @param teacher object with data for transformation.
     * @return {@link StudentDTO} created from teacher.
     */
    public static TeacherDTO transform(User teacher){
        return TeacherDTO.builder().firstname(teacher.getFirstName())
                .lastname(teacher.getLastName())
                .patronymic(teacher.getPatronymic())
                .login(teacher.getLogin())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .dateOfBirth(teacher.getDateOfBirth())
                .avatar(teacher.getAvatar())
                .build();
    }
}