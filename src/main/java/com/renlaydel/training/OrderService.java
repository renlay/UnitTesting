package com.renlaydel.training;

/**
 * Created by renlaydel on 23/01/2017.
 */
public interface OrderService {

    Order createOrder(Order order);

    boolean placeOrder( int id );

    boolean cancelOrder( int id );

    void displayOrder( int id);

    OrderDao getDao();

    void setDao( OrderDao orderDao );
}
