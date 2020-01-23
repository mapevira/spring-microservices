/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The user DAO service.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 8:53:59
 *
 */
@Component
public class UserDaoService {

    /** The user list property.*/
    private static List<User> users = new ArrayList<>();

    /** The users count property.*/
    private static int usersCount = 3;

    static {
        users.add(User.builder()
                .id(Integer.valueOf(1))
                .name("Adam")
                .birthDate(new Date())
                .build());

        users.add(User.builder()
                .id(Integer.valueOf(2))
                .name("Eve")
                .birthDate(new Date())
                .build());

        users.add(User.builder()
                .id(Integer.valueOf(3))
                .name("Jack")
                .birthDate(new Date())
                .build());
    }

    /** Create a new instance of the class.*/
    private UserDaoService() {
        super();
    }

    /**
     * Get all the users.
     *
     * @return the users list
     */
    public List<User> findAll() {
        return users;
    }

    /**
     * Add a user.
     *
     * @param user the user to add
     * @return the user added
     */
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    /**
     * Get an user by identifier.
     *
     * @param id the user identifier
     * @return the user 
     */
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId().intValue() == id) {
                return user;
            }
        }

        return null;
    }

    /**
     * Remove the user by id.
     *
     * @param id the identifier
     * @return the removed user
     */
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().intValue() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

}
