package com.springbootwithmvc.controller;

import com.springbootwithmvc.model.ApplicationDTO;
import com.springbootwithmvc.model.ApplicationRequest;
import com.springbootwithmvc.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/list")
    public String findAllApplications(Model model){
        List<ApplicationDTO> applicationDTOList = applicationService.findAllApplication();
        model.addAttribute("applications", applicationDTOList);
        return "applications";
    }

    @GetMapping("/create")
    public String applicationNew(Model model) {
        ApplicationRequest application = new ApplicationRequest();
        model.addAttribute("application", application);
        return "applicationnew";
    }

    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("application") ApplicationRequest application) {
        applicationService.save(application);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/applications/list");
        return redirectView;
    }


}
