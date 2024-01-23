
package com.dev.utils;

import com.dev.objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Persist {

    private final SessionFactory sessionFactory;

    @Autowired
    public Persist (SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public User getUserByUserName(String username){
        User found = null;
        Session session = sessionFactory.openSession();
        found = (User)session.createQuery("FROM User WHERE username=:username")
                .setParameter("username",username).uniqueResult();
        session.close();
        return found;
    }

    public User getUserByUserNameAndToken(String username,String token){
        User found = null;
        Session session = sessionFactory.openSession();
        found = (User)session.createQuery("FROM User WHERE username=:username"+" AND token=:token")
                .setParameter("username",username)
                .setParameter("token",token)
                .uniqueResult();
        session.close();
        return found;
    }

    public void saveUser(User user){
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.openSession();
        List<User> allUsers =  session.createQuery("FROM User ").list();
        session.close();
        return allUsers;
    }

    public User getUserByToken(String token){
        Session session = sessionFactory.openSession();
        User user = (User)  session.createQuery("From User WHERE token = :token")
                .setParameter("token",token).uniqueResult();
        session.close();
        return user;

    }




}
