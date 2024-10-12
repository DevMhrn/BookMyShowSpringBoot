package org.buildproduct.bookmyshow.repositories;

import org.buildproduct.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //the repository is used to interact with the database the service should not directly interact with the database

    Optional<User> findByEmail(String email);
    User save(User user);//the user input doesn't have id in the user object so we have to use the save method to save the user object to the database, else we have update it

}
