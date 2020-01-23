/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The user entity.
 *
 * @author pvraul1
 * @since 1.8
 * @version 14 ene. 2020 17:01:55
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** The user identifier property.*/
    private Integer id;

    /** The user name property.*/
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    /** The user birthday property.*/
    @Past
    private Date birthDate;

}
