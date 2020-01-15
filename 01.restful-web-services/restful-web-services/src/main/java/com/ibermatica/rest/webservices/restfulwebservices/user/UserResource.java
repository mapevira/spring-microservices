/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The user REST controller.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 9:40:16
 *
 */
@RestController
public class UserResource {

    /** The user DAO service property.*/
    @Autowired
    private UserDaoService service;

    /**
     * Retrieve all users.
     *
     * @return the user list
     */
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    /**
     * Retrieve an user.
     *
     * @param id the user identifier
     * @return the user
     */
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

}
