/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The User not found exception.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 11:12:50
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

    /**
     * Create a new instance of the class.
     *
     * @param message the message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

}
