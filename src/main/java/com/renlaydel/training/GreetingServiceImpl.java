package com.renlaydel.training;

/**
 * Created by renlaydel on 23/01/2017.
 */
public class GreetingServiceImpl implements GreetingService {

    private String defaultGreet;

    public GreetingServiceImpl() {
        this.defaultGreet = "Hello";
    }

    @Override
    public String greet( String name ) throws IllegalArgumentException{
        if( null == name || "".equals( name ) ){
            throw new IllegalArgumentException( "Name should not be null or empty" );
        }

        return String.format( "%s, %s!", this.defaultGreet, name );
    }
}
