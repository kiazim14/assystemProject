package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controlleur de redirection vers le swagger
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}
