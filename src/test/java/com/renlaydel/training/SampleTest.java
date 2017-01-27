package com.renlaydel.training;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by renlaydel on 23/01/2017.
 */
public class SampleTest {

    ArrayList<Integer> list = new ArrayList<Integer>();

    @BeforeClass
    public static void beforeClass(){
        System.out.println( "@BeforeClass" );
    }

    @Before
    public void setup(){
        System.out.println( "Set up..." );
        list.add( 1 );
        list.add( 2 );
        list.add( 3 );
    }

    @Test
    public void removeSpecificIndexFromList(){
        System.out.println( "Executing removeSpecificIndex" );
        list.remove( 1 );
        assertEquals( 2, list.size()  );

    }

    @Test
    public void addItemsToList(){
        System.out.println( "Executing addItems" );
        list.add( 4 );
        assertEquals( 4, list.size() );
    }

    @Ignore
    @Test( expected = NullPointerException.class )
    public void listNullShouldThrowAnException(){

    }

    @After
    public void cleanup(){
        System.out.println( "Clean up..." );
        list = new ArrayList<Integer>();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println( "@AfterClass" );
    }
}
