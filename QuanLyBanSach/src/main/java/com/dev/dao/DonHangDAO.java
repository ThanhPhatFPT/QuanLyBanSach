package com.dev.dao;

import com.dev.entity.DonHang;
import com.dev.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class DonHangDAO {

    // Create a new DonHang
    public void create(DonHang donHang) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(donHang);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Find a DonHang by ID
    public DonHang findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(DonHang.class, id);
        } finally {
            em.close();
        }
    }

    // Retrieve all DonHang entities
    public List<DonHang> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM DonHang d", DonHang.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Update an existing DonHang
    public void update(DonHang donHang) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(donHang);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Delete a DonHang by ID
    public void delete(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            DonHang donHang = em.find(DonHang.class, id);
            if (donHang != null) {
                em.remove(donHang);
            }
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
