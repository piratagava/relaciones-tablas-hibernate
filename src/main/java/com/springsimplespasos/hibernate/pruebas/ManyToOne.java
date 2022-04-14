package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytoone.Persona;
import com.springsimplespasos.hibernate.entidades.manytoone.Telefono;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import java.util.Arrays;
import org.hibernate.Session;

/**
 *
 * @author nano
 */
public class ManyToOne {
  public static void main(String[] args) {
    Session sesion = HibernateUtil.getSeccionSessionFactory().openSession();
    
    Persona nano = new Persona(1,"Hernan");
    Persona nay = new Persona(2,"Nay");
    
    Telefono telH = new Telefono(null, "7224737272");
    Telefono celH = new Telefono(null, "7224732235");
    
    sesion.beginTransaction();
    
    sesion.save(nano);
    sesion.save(nay);
        
    
    telH.setPersona(nano);
    celH.setPersona(nano); 
    
    nano.setTelefonos(Arrays.asList(telH,celH));
    
    /*Hace lo mismo guadando los valores de nuestra relacion de la misma persona
    sesion.save(telH);
    sesion.save(celH);
    */
           
    //sesion.saveOrUpdate(nano);
    //sesion.saveOrUpdate(nay);
    
    Persona persona = sesion.get(Persona.class, 18);
    persona.getTelefonos().forEach(h-> System.out.println(h.getNumero()));
    
    sesion.getTransaction().commit();
    sesion.close();
  }
}
