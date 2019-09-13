package com.dempaul.irens.test.palindromes.controller;

import com.dempaul.irens.test.palindromes.entity.ParentNumber;
import com.dempaul.irens.test.palindromes.service.Computing;
import com.dempaul.irens.test.palindromes.service.ParentNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ParentNumberService parentNumberService;

    @Autowired
    private Computing computing;

    @GetMapping("/")
    public String index(final Model model) {
        IReactiveDataDriverContextVariable numbers =
                new ReactiveDataDriverContextVariable(parentNumberService.findAll(), 1);

        model.addAttribute("parentNumber", new ParentNumber())
                .addAttribute("numbers", numbers);

        return "index";
    }

    @PostMapping("/")
    public String findPalindromes(@Valid ParentNumber parentNumber,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            IReactiveDataDriverContextVariable numbers =
                    new ReactiveDataDriverContextVariable(parentNumberService.findAll(), 1);

            model.addAttribute("numbers", numbers)
                    .addAttribute("parentNumber", parentNumber);

            return "index";
        } else {
            parentNumberService.save(parentNumber);

            Thread computingThread = new Thread(() -> {
                List<String> palindromes = computing.findPalindromes(parentNumber);
                parentNumber.setPalindromes(palindromes);
                parentNumberService.save(parentNumber);
            });
            computingThread.start();

            return "redirect:/";
        }
    }
}
