package com.jpa.DAO;

import com.jpa.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class JPADAO<E> {
    protected EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    public E create(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public E update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public Optional<E> find(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Optional<E> entity = Optional.ofNullable(entityManager.find(type, id));
        entityManager.close();
        return entity;
    }

    public boolean delete(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            Object references = entityManager.getReference(type, id);
            entityTransaction.begin();
            entityManager.remove(references);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }

}
