package br.com.drogaria.util;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory	sessionFactory	= buildSessionFactory();
	
	public static SessionFactory buildSessionFactory(){
		
		try {
			
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
			
		} catch (Exception e) {
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
			
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
