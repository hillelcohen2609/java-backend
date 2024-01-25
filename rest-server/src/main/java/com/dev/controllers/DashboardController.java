package com.dev.controllers;

import com.dev.objects.Messages;
import com.dev.objects.User;
import com.dev.responses.BasicRespons;
import com.dev.responses.MessagesResponse;
import com.dev.responses.UserResponse;
import com.dev.utils.Persist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dev.utils.Errors.ERROR_NO_SUCH_TOKEN;

@RestController
public class DashboardController {

    @Autowired
    Persist persist;

    @RequestMapping(value = "/get-user-name")
    public BasicRespons getUserName(String token){
        BasicRespons basicRespons = null;
        User user = persist.getUserByToken(token);
        if (user!=null){
            basicRespons = new UserResponse(true,null,user.getUsername());
        }else {
            basicRespons = new BasicRespons(false,ERROR_NO_SUCH_TOKEN);
        }
         return basicRespons;
    }
    @RequestMapping(value = "/get-latest-massages",method = RequestMethod.GET)
    public BasicRespons getLatestMassages(String token){
        BasicRespons respons;
        List<Messages> userMessages = persist.getMessagesByToken(token);
        respons = new MessagesResponse(userMessages);
        return respons;
    }
}
