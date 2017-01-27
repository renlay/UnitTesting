package com.renlaydel.training;

/**
 * Created by renlaydel on 23/01/2017.
 */
public interface OrderDao {

    Order create(Order order);

    Order read(int id);

    boolean update(Order order);

    boolean delete(int id);
}
