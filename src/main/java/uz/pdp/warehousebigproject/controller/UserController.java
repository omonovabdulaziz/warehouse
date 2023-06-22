package uz.pdp.warehousebigproject.controller;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.User;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    //CREATE
    @PostMapping
    public Result addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //READ
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    //UPDATE
    @PutMapping("/byId/{userId}")
    public Result updateUser(@PathVariable Integer userId , @RequestBody User user){
        return userService.updateUser(userId , user);
    }


    //DELETE



}
