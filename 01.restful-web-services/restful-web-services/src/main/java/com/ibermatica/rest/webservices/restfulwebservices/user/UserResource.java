/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public Resource<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        //"all-users", SERVER_PATH + "/users"
        //retrieveAllUsers
        Resource<User> resource = new Resource<>(user);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    /**
     * Create a new user.
     *
     * @param user the user
     * @return the response entity
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     * Remove an user.
     *
     * @param id the user identifier
     * @return the user
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

    }

}
