package com.dev.controllers;

import com.dev.objects.User;
import com.dev.responses.BasicRespons;
import com.dev.responses.LoginResponse;
import com.dev.utils.Persist;
import com.dev.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dev.utils.Errors.*;

@RestController
public class LoginController {

    @Autowired
    private Utils utils;

    @Autowired
    private Persist persist;

    @RequestMapping(value = "/sign-up")
    public BasicRespons signUp (String username,String password){
        BasicRespons basicRespons = new BasicRespons();
        if (username != null){
            if (password!=null){
                if (utils.isStrongPassword(password)){
                    if (persist.getUserByUserName(username)==null){
                        User toDb =new User(username,utils.createHash(username, password));
                        persist.saveUser(toDb);
                        basicRespons.setSuccess(true);
                    }else{
                        basicRespons.setErrorCode(ERROR_USER_NAME_ALREADY_EXIST);

                    }

                }else {
                    basicRespons.setErrorCode(ERROR_WEAK_PASSWORD);
                }

            }else {
                basicRespons.setErrorCode(ERROR_MISSING_USER_PASSWORD);
            }

        }else {
            basicRespons.setErrorCode(ERROR_MISSING_USER_NAME);
        }

        return basicRespons;
    }

    @RequestMapping(value = "/login")
    public BasicRespons login (String username,String password){
        BasicRespons basicRespons = new BasicRespons();
        if (username != null){
            if (password!=null){
                String token = utils.createHash(username,password);
                User fromDb = persist.getUserByUserNameAndToken(username,token);
                if (fromDb!=null){
                    basicRespons = new LoginResponse(true,null,token);

                }else{
                    basicRespons.setErrorCode(ERROR_INCORRECT_LOGIN_CREDS);
                }
            }else {
                basicRespons.setErrorCode(ERROR_MISSING_USER_PASSWORD);
            }

        }else {
            basicRespons.setErrorCode(ERROR_MISSING_USER_NAME);
        }
        return basicRespons;
    }

}
