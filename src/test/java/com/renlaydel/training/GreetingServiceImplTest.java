package com.renlaydel.training;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingServiceImplTest {

    GreetingService greetingService = new GreetingServiceImpl();

    @Test
    public void greet_Should_Return_Valid_String(){
        String message = greetingService.greet( "World" );
        assertEquals( "Hello, World!", message );
    }

    @Test( expected = IllegalArgumentException.class )
    public void greet_Should_Throw_An_Exception(){
        String name = null;
        greetingService.greet( name );

        name = "";
        greetingService.greet( name );
    }
}
