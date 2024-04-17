package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Redirect to a custom error page or return the error page view
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

