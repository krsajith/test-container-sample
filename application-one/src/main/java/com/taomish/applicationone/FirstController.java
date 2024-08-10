package com.taomish.applicationone;

import com.taomish.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-one")
public class FirstController {

    private final CustomerService customerService;

    public FirstController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/hello")
    public String first() {
        return "Hello World 1";
    }
}
