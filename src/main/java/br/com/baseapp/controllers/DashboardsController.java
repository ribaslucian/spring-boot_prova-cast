package br.com.baseapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class DashboardsController {

  @GetMapping("/hello")
  public String hello(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/api/dashboards/guest")
  public String apiGuest() {
    return "dashboards/guest.html";
  }

  @GetMapping("/dashboards/guest")
  public ModelAndView guest() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("globalMessage", "Mensagem do controller.");
    return mv;
  }
}
