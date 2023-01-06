package com.emexo.web;

import com.emexo.entity.Application;
import com.emexo.service.ApplicationService;
import com.emexo.service.ReleaseService;
import com.emexo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;

@Controller
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/applications")
    public String retrieveApplications(Model model){
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

    @GetMapping("/applicationnew")
    public String applicationNew(Model model) {
        Application application = new Application();
        model.addAttribute("application", application);
        return "applicationnew";
    }

    @PostMapping("/applicationsave")
    public RedirectView submitForm(@ModelAttribute("application") Application application) {
        try {
            applicationService.save(application);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/applications");
        return redirectView;
    }

    @GetMapping("/applicationdelete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        applicationService.delete(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/applications");
        return redirectView;
    }

    @GetMapping("/applicationedit/{id}")
    public String applicationEdit(@PathVariable("id") int id, Model model) {
        Application application = applicationService.getApplication(id);
        model.addAttribute("application", application);
        return "applicationedit";
    }

    @GetMapping("/tickets")
    public String retrieveTickets(Model model){
        model.addAttribute("tickets", ticketService.listTickets());
        return "tickets";
    }

    @GetMapping("/releases")
    public String retrieveReleases(Model model){
        model.addAttribute("releases", releaseService.listReleases());
        return "releases";
    }
}