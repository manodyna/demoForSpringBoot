package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@Controller
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private Repository repository;
    @Autowired
    private Service service;


    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        service.addUser(name, email);
        return "saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Model> getAllUsers(){
        return repository.findAll();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody String deleteUser(@RequestParam int id){
        service.removeUser(id);
        return "deleted";
    }

}
