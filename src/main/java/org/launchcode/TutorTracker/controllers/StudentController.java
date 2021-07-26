package org.launchcode.TutorTracker.controllers;

import org.launchcode.TutorTracker.data.StudentRepository;
import org.launchcode.TutorTracker.models.Meeting;
import org.launchcode.TutorTracker.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String displayAllStudents(Model model) {
        model.addAttribute("title", "All Students");
        model.addAttribute("students", studentRepository.findAll());
        // student/index is the file path in the project structure
        return "student/index";
    }

    // create is the URL path students/create
    @GetMapping("create")
    public String displayCreateStudentForm(Model model) {
        model.addAttribute("title", "Create Student Profile");
        model.addAttribute(new Student());
        // student/create is the file path in the project structure
        return "student/create";
    }

    @PostMapping("create")
    public String processCreateStudentForm(@Valid @ModelAttribute Student student,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Student Profile");
            model.addAttribute(new Student());
            // student/create is the file path in the project structure
            return "student/create";
        }

        studentRepository.save(student);
        // redirect: is the URL path from RequestMapping (The main mapping from the controller)
        return "redirect:/students";
    }


    //update student profile
    @GetMapping("edit/{studentId}")
    public String displayEditStudentForm(@PathVariable int studentId, Model model) {
        Optional<Student> result = studentRepository.findById(studentId);
        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Student ID: " + studentId);
        } else {
            Student student = result.get();
            model.addAttribute("title", "Edit Student First Name" + student.getFirstName());
            model.addAttribute("title", "Edit Student Last Name" + student.getLastName());
            model.addAttribute("student", student);
        }
        return "student/edit";
    }

    @PostMapping("edit")
    public String processEditStudentForm(int studentId, String firstName, String lastName, String address1, String address2, String city, String state, String zip, String phone, String email, String birthdate, String note) {
        Student student = studentRepository.findById(studentId).get();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAddress1(address1);
        student.setAddress2(address2);
        student.setCity(city);
        student.setState(state);
        student.setZip(zip);
        student.setPhone(phone);
        student.setEmail(email);
        student.setBirthdate(birthdate);
        student.setNote(note);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("profile")
    public String displayStudentProfile (@RequestParam int studentId, Model model) {
        Optional<Student> result = studentRepository.findById(studentId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Student ID: " + studentId);
        } else {
           Student student = result.get();

            model.addAttribute("title", "Student Profile: " + student.getLastName());
            model.addAttribute("student", student);


        }
        return "student/profile";
    }

    @PostMapping("profile")
    public String processStudentProfile(@Valid @ModelAttribute Student student,
                                        Errors errors, Model model){
        return "redirect:/students";
    }
}
