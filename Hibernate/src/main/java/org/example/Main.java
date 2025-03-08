package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            // Database operations
            try {
                // Set properties of the entity
                System.out.println("Success");

            }catch (Exception ex){
                // Rollback the transaction if an exception occurs
                transaction.rollback();
                System.out.println("Transaction rolled back due to exception: " + ex.getMessage());
            }

            // Commit the transaction if successful
            transaction.commit();
        }catch (Exception ex){
            // Handle exceptions related to opening or closing session
            System.out.println("An error occurred while opening or closing the session: " + ex.getMessage());
        }
    }
}