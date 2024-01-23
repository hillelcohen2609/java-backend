package com.dev.controllers;

import com.dev.objects.User;
import com.dev.responses.AllUserResponse;
import com.dev.responses.BasicRespons;
import com.dev.utils.Persist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private Persist persist;

    @RequestMapping(value = "/get-all-users",method = RequestMethod.GET)
    public BasicRespons getAllUsersM(){
        List<User> users= persist.getAllUsers();
        AllUserResponse allUserResponse = new AllUserResponse(true,null,users);
        return allUserResponse;
    }
}
