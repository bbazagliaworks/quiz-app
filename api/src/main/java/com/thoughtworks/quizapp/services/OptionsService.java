package com.thoughtworks.quizapp.services;

import com.thoughtworks.quizapp.entities.Options;
import com.thoughtworks.quizapp.repositories.OptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OptionsService {

    @Autowired
    private OptionsRepository optionsRepository;

    public List<Options> createOptions(List<Options> optionsList) {
        return optionsRepository.saveAll(optionsList);
    }

    public Options getOptionsById(long id) {
        return optionsRepository.findById(id).orElse(null);
    }

    public List<Options> updateOptions(List<Options> optionsList) {
        for (Options options : optionsList) {
            Options existingOptions = optionsRepository.findById(options.getId()).orElse(null);
            if (existingOptions != null) {
                existingOptions.setContent(options.getContent());
                existingOptions.setCorrect(options.isCorrect());
                optionsRepository.save(existingOptions);
            }
        }
        return optionsList;
    }
}