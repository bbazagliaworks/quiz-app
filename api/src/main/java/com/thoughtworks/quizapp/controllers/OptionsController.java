package com.thoughtworks.quizapp.controllers;

import com.thoughtworks.quizapp.entities.Options;
import com.thoughtworks.quizapp.services.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @PostMapping
    public void createOptions(@RequestBody List<Options> optionsList) {
        optionsService.createOptions(optionsList);
    }

    @PostMapping("/update")
    public void updateOptions(@RequestBody List<Options> optionsList) {
        optionsService.updateOptions(optionsList);
    }

    @GetMapping("/{id}")
    public Options getOptionsById(@PathVariable long id) {
        return optionsService.getOptionsById(id);
    }
}
