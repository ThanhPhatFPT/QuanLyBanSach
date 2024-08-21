package com.dev.dao;

import com.dev.entity.KhachHang;
import com.dev.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class KhachHangDAO {

    // Create a new KhachHang
    public void create(KhachHang khachHang) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(khachHang);
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

    // Find a KhachHang by ID
    public KhachHang findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(KhachHang.class, id);
        } finally {
            em.close();
        }
    }

    // Retrieve all KhachHang entities
    public List<KhachHang> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT k FROM KhachHang k", KhachHang.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Update an existing KhachHang
    public void update(KhachHang khachHang) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(khachHang);
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

    // Delete a KhachHang by ID
    public void delete(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            KhachHang khachHang = em.find(KhachHang.class, id);
            if (khachHang != null) {
                em.remove(khachHang);
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
