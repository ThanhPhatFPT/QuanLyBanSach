package com.dev.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	static EntityManagerFactory factory;
	public static EntityManager getEntityManager() {
		if(factory == null || factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("QuanLyBanSach");
		}
		EntityManager eManager = factory.createEntityManager();
		return eManager;
	}
	static public void shutdown() {
		if(factory != null || factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
