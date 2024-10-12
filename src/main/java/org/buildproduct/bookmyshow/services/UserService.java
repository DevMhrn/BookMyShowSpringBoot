package org.buildproduct.bookmyshow.services;

import org.buildproduct.bookmyshow.dtos.ResponseStatus;
import org.buildproduct.bookmyshow.models.User;
import org.buildproduct.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public User signup(String name, String email, String password){
        // Logic to signup a user

        //First check if the user already exists with the given email id
        //we have to run the query to check if the user already exists with the given email id
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            //redicrect to the login page

        }
        //if the user already exists with the given email id then return null
        // if the user does not exist with the given email id then create a new user
        User user = new User();
        user.setName(name);
        // generally we should encrypt the password before saving it to the database
        //Use can use the BcryptPasswordEncoder library to encrypt the password
        user.setPassword(password);
        user.setEmail(email);

        return userRepository.save(user);
    }
    public ResponseStatus login(String email, String password){
        // Logic to login a user
        //First check if the user already exists with the given email id
        //we have to run the query to check if the user already exists with the given email id
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            //if the user exists with the given email id then check if the password is correct
            User user = userOptional.get();
            if(user.getPassword().equals(password)){
                //if the password is correct then return the success status
                return ResponseStatus.SUCCESS;
            }
        }
        //if the user does not exist with the given email id or the password is incorrect then return the failure status

        //and redirect to the sign up page

        return ResponseStatus.FAILURE;
    }
}
