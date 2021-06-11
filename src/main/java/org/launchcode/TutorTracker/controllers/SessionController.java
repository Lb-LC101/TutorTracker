package org.launchcode.TutorTracker.controllers;

import org.launchcode.TutorTracker.data.SessionRepository;
import org.launchcode.TutorTracker.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public String displayAllSessions(Model model) {
        model.addAttribute("title", "All Sessions");
        model.addAttribute("sessions", sessionRepository.findAll());
        // session/index is the file path in the project structure
        return "session/index";
    }

    // create is the URL path session/create
    @GetMapping("create")
    public String displayCreateSessionForm(Model model) {
        model.addAttribute("title", "Create Session Profile");
        model.addAttribute(new Session());
        // session/create is the file path in the project structure
        return "session/create";
    }

    @PostMapping("create")
    public String processCreateSessionForm(@Valid @ModelAttribute Session session,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Session Profile");
            model.addAttribute(new Session());
            // session/create is the file path in the project structure
            return "session/create";
        }

        sessionRepository.save(session);
        // redirect: is the URL path from RequestMapping (The main mapping from the controller)
        return "redirect:/session";
    }


    //update session profile
    @GetMapping("edit/{sessionId}")
    public String displayEditSessionForm(@PathVariable int sessionId, Model model) {
        Optional<Session> result = sessionRepository.findById(sessionId);
        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Session ID: " + sessionId);
        } else {
            Session session = result.get();
            model.addAttribute("title", "Edit Session Date" + session.getSessionDate());
            model.addAttribute("title", "Edit Session Note" + session.getSessionNote());
            model.addAttribute("session", session);
        }
        return "session/edit";
    }

    @PostMapping("edit")
    public String processEditSessionForm(int sessionId, Date sessionDate, String sessionNote) {
        Session session = sessionRepository.findById(sessionId).get();
        session.setSessionDate(sessionDate);
        session.setSessionNote(sessionNote);
        sessionRepository.save(session);
        return "redirect:/sessions";
    }



}
