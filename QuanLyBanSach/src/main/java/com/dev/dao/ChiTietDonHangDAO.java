package com.dev.dao;

import com.dev.entity.ChiTietDonHang;
import com.dev.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ChiTietDonHangDAO {

    // Create a new ChiTietDonHang
    public void create(ChiTietDonHang chiTietDonHang) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(chiTietDonHang);
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

    // Find a ChiTietDonHang by ID
    public ChiTietDonHang findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(ChiTietDonHang.class, id);
        } finally {
            em.close();
        }
    }

    // Retrieve all ChiTietDonHang
    public List<ChiTietDonHang> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChiTietDonHang c", ChiTietDonHang.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Update an existing ChiTietDonHang
    public void update(ChiTietDonHang chiTietDonHang) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(chiTietDonHang);
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

    // Delete a ChiTietDonHang by ID
    public void delete(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            ChiTietDonHang chiTietDonHang = em.find(ChiTietDonHang.class, id);
            if (chiTietDonHang != null) {
                em.remove(chiTietDonHang);
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

    // Find ChiTietDonHang by DonHang ID
    public List<ChiTietDonHang> findByDonHangId(Integer donHangId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChiTietDonHang c WHERE c.donHang.id = :donHangId", ChiTietDonHang.class)
                     .setParameter("donHangId", donHangId)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    // Find ChiTietDonHang by Sach ID
    public List<ChiTietDonHang> findBySachId(Integer sachId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChiTietDonHang c WHERE c.sach.id = :sachId", ChiTietDonHang.class)
                     .setParameter("sachId", sachId)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
