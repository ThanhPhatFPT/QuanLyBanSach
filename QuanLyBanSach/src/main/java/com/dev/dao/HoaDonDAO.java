package com.dev.dao;

import com.dev.entity.HoaDon;
import com.dev.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class HoaDonDAO {

    // Create a new HoaDon
    public void create(HoaDon hoaDon) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(hoaDon);
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

    // Find a HoaDon by ID
    public HoaDon findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(HoaDon.class, id);
        } finally {
            em.close();
        }
    }

    // Retrieve all HoaDon entities
    public List<HoaDon> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT h FROM HoaDon h", HoaDon.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Update an existing HoaDon
    public void update(HoaDon hoaDon) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(hoaDon);
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

    // Delete a HoaDon by ID
    public void delete(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            HoaDon hoaDon = em.find(HoaDon.class, id);
            if (hoaDon != null) {
                em.remove(hoaDon);
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
