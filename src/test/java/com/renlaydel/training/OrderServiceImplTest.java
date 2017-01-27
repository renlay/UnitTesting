package com.renlaydel.training;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by renlaydel on 24/01/2017.
 */
public class OrderServiceImplTest {

    @Mock
    OrderDao dao;

    @Mock
    OrderService service;

    @Mock
    Order order;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks( this );
        service = spy( OrderServiceImpl.class);
            }

    @Test
    public void createOrder_Should_Return_Valid(){
        //Mock the OrderService.createOrder
        when( order.getId() ).thenReturn( 1 );
        when( order.getName() ).thenReturn( "Chicken Joy" );
        when( order.getStatus() ).thenReturn( "submitted" );
        when( order.getMemberId() ).thenReturn( "123" );
        when( service.createOrder( order ) ).thenReturn( order );

        order = service.createOrder( order );

        assertEquals( "submitted", order.getStatus() );
        assertEquals( "Chicken Joy", order.getName() );
        assertEquals( 1, order.getId() );
        assertEquals( "123", order.getMemberId() );

        //Verify if OrderService.createOrder has been called
        verify( service ).createOrder( order );
    }

    @Test( expected = InvalidOrderException.class )
    public void createOrder_Should_Throw_Exception_When_Name_Is_Null(){
        //Mock OrderService.createOrder
        when( order.getId() ).thenReturn( 1 );
        when( order.getName() ).thenReturn( null );
        when( order.getStatus() ).thenReturn( "submitted" );
        when( order.getMemberId() ).thenReturn( "123" );
        when( service.createOrder( order ) ).thenThrow( InvalidOrderException.class );

        service.createOrder( order );

        //Verify if OrderService.createOrder has been called
        verify( service ).createOrder( order );
    }

    @Test( expected = InvalidOrderException.class )
    public void createOrder_Should_Throw_Exception_When_Name_Is_Empty(){
        //Mock OrderService.createOrder
        when( order.getId() ).thenReturn( 1 );
        when( order.getName() ).thenReturn( "" );
        when( order.getStatus() ).thenReturn( "submitted" );
        when( order.getMemberId() ).thenReturn( "123" );
        when( service.createOrder( order ) ).thenThrow( InvalidOrderException.class );

        service.createOrder( order );

        //Verify if OrderService.createOrder has been called
        verify( service ).createOrder( order );
    }

    @Test( expected = InvalidOrderException.class )
    public void createOrder_Should_Throw_Exception_When_MemberId_Is_Null(){
        //Mock OrderService.createOrder
        when( order.getId() ).thenReturn( 1 );
        when( order.getName() ).thenReturn( "Chicken Joy" );
        when( order.getStatus() ).thenReturn( "submitted" );
        when( order.getMemberId() ).thenReturn( null );
        when( service.createOrder( order ) ).thenThrow( InvalidOrderException.class );

        service.createOrder( order );

        //Verify if OrderService.createOrder has been called
        verify( service ).createOrder( order );
    }

    @Test( expected = InvalidOrderException.class )
    public void createOrder_Should_Throw_Exception_When_MemberId_Is_Empty(){
        //Mock OrderService.createOrder
        when( order.getId() ).thenReturn( 1 );
        when( order.getName() ).thenReturn( "Chicken Joy" );
        when( order.getStatus() ).thenReturn( "submitted" );
        when( order.getMemberId() ).thenReturn( "" );
        when( service.createOrder( order ) ).thenThrow( InvalidOrderException.class );

        service.createOrder( order );

        //Verify if OrderService.createOrder has been called
        verify( service ).createOrder( order );
    }


    @Test
    public void placeOrder_Should_Return_True(){
        //Mock the OrderService.placeOrder
        when( service.placeOrder( anyInt() ) ).thenReturn( true );

        boolean result = service.placeOrder( 1 );
        assertTrue( result );

        //Verify if OrderService.placeOrder has been called
        verify( service ).placeOrder( 1 );
    }

    @Test
    public void placeOrder_Should_Return_False(){
        //Mock the OrderService.placeOrder
        when( service.placeOrder( anyInt()) ).thenReturn( false );
        when( service.placeOrder( anyInt() ) ).thenAnswer(Answer)
        boolean result = service.placeOrder( 1 );
        assertFalse( result );

        //Verify if OrderService.placeOrder has been called
        verify( service ).placeOrder( 1 );
    }

    @Test
    public void displayOrder(){
        //Mock the OrderService.displayOrder
        doNothing().when( service ).displayOrder( anyInt() );

        service.displayOrder( 1 );

        //Verify if OrderService.displayOrder has been called
        verify( service ).displayOrder( 1 );
    }

}
