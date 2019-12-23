/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices;

/**
 * The Hello World Bean.
 *
 * @author pvraul1
 * @since 1.8
 * @version 23 dic. 2019 12:51:58
 *
 */
public class HelloWorldBean {

    /** The message property.*/
    private String message;

    public HelloWorldBean(String message) {
        super();
        this.message = message;
    }

    /**
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public final void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }

}
