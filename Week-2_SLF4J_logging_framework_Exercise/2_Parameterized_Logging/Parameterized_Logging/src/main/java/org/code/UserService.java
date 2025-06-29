package org.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void createUser(String username,String email){
        //Parameterized logging, avoids string concatenation.
        logger.info("Creating user with username:{} and email:{}",username,email);
        try{
            Thread.sleep(1000);
            logger.debug("Successfully processed user creation for {}",username);
        }catch (InterruptedException e){
            //Logs exception with message and parameters
            logger.error("Error while creating user with username:{}",username,e);
        }
    }

    public static void main(String[] args){
        UserService userService = new UserService();
        userService.createUser("sandipanrakshit34","sandipanrakshit6@gmail.com");
    }
}
