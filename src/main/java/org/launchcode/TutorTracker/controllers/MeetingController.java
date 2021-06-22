package org.launchcode.TutorTracker.controllers;

import org.launchcode.TutorTracker.data.MeetingRepository;
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
@RequestMapping("meetings")
public class MeetingController {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String displayAllMeetings(Model model) {
        model.addAttribute("title", "All Meetings");
        model.addAttribute("meetings", meetingRepository.findAll());
        // meeting/index is the file path in the project structure
        return "meeting/index";
    }

    // create is the URL path meeting/create
    @GetMapping("create")
    public String displayCreateMeetingForm(Model model) {
        model.addAttribute("title", "Create Meeting Profile");
        model.addAttribute(new Meeting());

        model.addAttribute("students", studentRepository.findAll());

        // meeting/create is the file path in the project structure
        return "meeting/create";
    }

    @PostMapping("create")
    public String processCreateMeetingForm(@ModelAttribute @Valid Meeting newMeeting,
                                           Errors errors, Model model, @RequestParam int studentId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Meeting Profile");
            model.addAttribute("students", studentRepository.findAll());
            //model.addAttribute(new Meeting());
            // meeting/create is the file path in the project structure
            return "meeting/create";
        }

        //add student selected from drop-down menu to the new meeting.  If there is no student in the student repository, create a new student.
        Student selectedStudent = studentRepository.findById(studentId).orElse(new Student());
        newMeeting.setStudent(selectedStudent);

        meetingRepository.save(newMeeting);
        // redirect: is the URL path from RequestMapping (The main mapping from the controller)
        return "redirect:/";
    }


    //update meeting profile
    @GetMapping("edit/{meetingId}")
    public String displayEditMeetingForm(@PathVariable int meetingId, Model model) {
        Optional<Meeting> result = meetingRepository.findById(meetingId);
        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Meeting ID: " + meetingId);
        } else {
            Meeting meeting = result.get();
            model.addAttribute("title", "Edit Meeting Date" + meeting.getMeetingDate());
            model.addAttribute("title", "Edit Meeting Note" + meeting.getMeetingNote());
            model.addAttribute("students", studentRepository.findAll());
            model.addAttribute("meeting", meeting);
        }
        return "meeting/edit";
    }

    @PostMapping("edit")
    public String processEditMeetingForm(int meetingId, String meetingDate, String meetingNote, @RequestParam int studentId, Model model) {
        Meeting meeting = meetingRepository.findById(meetingId).get();
        meeting.setMeetingDate(meetingDate);
        meeting.setMeetingNote(meetingNote);

        //add student selected from drop-down menu to the new meeting.  If there is no student in the student repository, create a new student.
        Student selectedStudent = studentRepository.findById(studentId).orElse(new Student());
        meeting.setStudent(selectedStudent);

        meetingRepository.save(meeting);
        return "redirect:/meeting";
    }



}
