package com.renlaydel.training;

/**
 * Created by renlaydel on 23/01/2017.
 */
public class OrderServiceImpl implements OrderService {

    OrderDao dao;

    public void displayOrder(int id) {
        Order order = dao.read( id );
        System.out.println( String.format( "ID: %s, Status: %s", order.getId(), order.getStatus() ) );
    }

    public Order createOrder(Order order) {
        order.setStatus( "submitted" );
        dao.create( order );
        return order;
    }

    public boolean placeOrder( int id ) {
        Order order = dao.read( id );
        order.setStatus( "in progress" );
        return dao.update( order );
    }

    public boolean cancelOrder( int id ) {
        return dao.delete( id );
    }

    public OrderDao getDao() {
        return dao;
    }

    public void setDao(OrderDao dao) {
        this.dao = dao;
    }
}
