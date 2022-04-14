package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.onetoone.Carnet;
import com.springsimplespasos.hibernate.entidades.onetoone.Socio;
import org.hibernate.Session;

import com.springsimplespasos.hibernate.util.HibernateUtil;

public class OneToOne {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSeccionSessionFactory().openSession();

    Socio socio = new Socio();
    
    socio.setNombre("Hernan");
    socio.setDocumento("1223453");
    
    Carnet carnet = new Carnet();
    carnet.setNumero("00001");
    carnet.setSocio(socio);
    
    
    socio.setCarnet(carnet);
    
    session.beginTransaction();
    session.save(socio);
    session.getTransaction().commit();
    session.close();
  }
}
