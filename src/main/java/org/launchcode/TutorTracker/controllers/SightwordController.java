package org.launchcode.TutorTracker.controllers;

import org.launchcode.TutorTracker.data.SightwordRepository;
import org.launchcode.TutorTracker.models.Sightword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("sightwords")
public class SightwordController {

    @Autowired
    private SightwordRepository sightwordRepository;

    @GetMapping
    public String displayAllWords(Model model) {
        model.addAttribute("title", "All Words");
        model.addAttribute("sightwords", sightwordRepository.findAll());
        return "sightword/index";
    }

    @GetMapping("create")
    public String displayCreateSightwordForm(Model model) {
        model.addAttribute("title", "Create Sight Word Profile");
        model.addAttribute(new Sightword());
        // sightword/create is the file path in the project structure
        return "sightword/create";
    }

    @PostMapping("create")
    public String processCreateSightwordForm(@Valid @ModelAttribute Sightword sightword,
                                             Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Sightword Profile");
            model.addAttribute(new Sightword());
            // sightword/create is the file path in the project structure
            return "sightword/create";
        }

        sightwordRepository.save(sightword);
        // redirect: is the URL path from RequestMapping (The main mapping from the controller)
        return "redirect:/sightwords";

    }

    //update sightword profile
    @GetMapping("edit/{sightwordId}")
    public String displayEditSightwordForm(@PathVariable int sightwordId, Model model) {
        Optional<Sightword> result = sightwordRepository.findById(sightwordId);
        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Sight Word ID: " + sightwordId);
        } else {
            Sightword sightword = result.get();
            model.addAttribute("title", "Edit Sight Word" + sightword.getWord());
            model.addAttribute("sightword", sightword);
        }
        return "sightword/edit";
    }

    @PostMapping("edit")
    public String processEditSightwordForm(int sightwordId, String word) {
        Sightword sightword = sightwordRepository.findById(sightwordId).get();
        sightword.setWord(word);

        sightwordRepository.save(sightword);
        return "redirect:/sightwords";
    }

}
