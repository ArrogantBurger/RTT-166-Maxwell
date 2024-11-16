package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetails;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(OrderDetails orderDetails) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        try {
            session.merge(orderDetails);
            session.getTransaction().commit();
        } catch ( Exception e ) {
            session.getTransaction().rollback();
        }

        session.close();
    }

    public void create(OrderDetails orderDetails) {
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.persist(orderDetails);
        session.getTransaction().commit();

        session.close();
    }

    public void delete(OrderDetails orderDetails) {
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.delete(orderDetails);
        session.getTransaction().commit();

        session.close();
    }

    public OrderDetails findByOrderIdAndProductId(Integer orderId, Integer productId) {
        String hqlQuery = "SELECT od FROM OrderDetails od WHERE od.id = :orderdetailsId";

        Session session = factory.openSession();
        TypedQuery<OrderDetails> query = session.createQuery(hqlQuery, OrderDetails.class);
        query.setParameter("orderdetailsId", orderId);


        try {
            OrderDetails result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public OrderDetails findOrderDetailById(Integer id) {
        String hqlQuery = "SELECT od FROM OrderDetails od WHERE od.id = :orderdetailsId";

        Session session = factory.openSession();
        TypedQuery<OrderDetails> query = session.createQuery(hqlQuery, OrderDetails.class);
        query.setParameter("orderdetailsId", id);

        try {
            OrderDetails result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

}
