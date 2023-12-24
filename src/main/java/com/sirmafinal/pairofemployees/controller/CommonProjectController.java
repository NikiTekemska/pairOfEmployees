package com.sirmafinal.pairofemployees.controller;

import com.sirmafinal.pairofemployees.service.CommonProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CommonProjectController {
    @Autowired
    private CommonProjectService commonProjectService;
    @GetMapping("/displayResults")
    public String displayResults(Model model) {
        model.addAttribute("commonProjects", commonProjectService.winnerCommonProjects());
        model.addAttribute("winnerPair", commonProjectService.getWinnerPair());
        return "winnerPair";
    }
}
