package com.alibou.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello from my first controller";
//    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request accepted and the message is " + message;
    }

    @PostMapping("/order")
    public String post(
            @RequestBody Order order
    ) {
        return "Request accepted and order is " + order.toString();
    }
    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Request accepted and order is " + order.toString();
    }

    //http://localhost:8080/hello/alibu
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ) {
        return "my value = " + userName;
    }

    //http://localhost:8080/hello?param_name=value&param_name_2=value_2
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("last-name") String lastName
    ) {
        return "my value = " + userName + "   " + lastName;
    }
}
