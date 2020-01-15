/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.Date;

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
    private String name;

    /** The user birthday property.*/
    private Date birthDate;
}
