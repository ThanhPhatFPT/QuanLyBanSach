package com.dev.dao;

import com.dev.entity.ChiTietHoaDon;
import com.dev.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ChiTietHoaDonDAO {

    // Create a new ChiTietHoaDon
    public void create(ChiTietHoaDon chiTietHoaDon) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(chiTietHoaDon);
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

    // Find a ChiTietHoaDon by ID
    public ChiTietHoaDon findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(ChiTietHoaDon.class, id);
        } finally {
            em.close();
        }
    }

    // Retrieve all ChiTietHoaDon
    public List<ChiTietHoaDon> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChiTietHoaDon c", ChiTietHoaDon.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Update an existing ChiTietHoaDon
    public void update(ChiTietHoaDon chiTietHoaDon) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(chiTietHoaDon);
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

    // Delete a ChiTietHoaDon by ID
    public void delete(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            ChiTietHoaDon chiTietHoaDon = em.find(ChiTietHoaDon.class, id);
            if (chiTietHoaDon != null) {
                em.remove(chiTietHoaDon);
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

    // Find ChiTietHoaDon by HoaDon ID
    public List<ChiTietHoaDon> findByHoaDonId(Integer hoaDonId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon.id = :hoaDonId", ChiTietHoaDon.class)
                     .setParameter("hoaDonId", hoaDonId)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    // Find ChiTietHoaDon by Sach ID
    public List<ChiTietHoaDon> findBySachId(Integer sachId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChiTietHoaDon c WHERE c.sach.id = :sachId", ChiTietHoaDon.class)
                     .setParameter("sachId", sachId)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
