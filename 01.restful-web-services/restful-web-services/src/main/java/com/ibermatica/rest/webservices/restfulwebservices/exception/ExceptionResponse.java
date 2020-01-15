/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The exception response.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 11:41:39
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    /** The exception date and time.*/
    private Date timestamp;

    /** The exception message.*/
    private String message;

    /** The exception details.*/
    private String details;

}
