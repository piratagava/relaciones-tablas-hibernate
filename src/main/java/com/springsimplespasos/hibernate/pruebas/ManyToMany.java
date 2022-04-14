package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytomany.Publicacion;
import com.springsimplespasos.hibernate.entidades.manytomany.Usuario;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import java.util.Arrays;
import org.hibernate.Session;

/**
 *
 * @author nano
 */
public class ManyToMany {
  public static void main(String[] args) {
    
    Session sesion = HibernateUtil.getSeccionSessionFactory().openSession();
    
    Usuario admin = new Usuario(3, "Hernan");
    Usuario user = new Usuario(4, "Nay");
    
    Publicacion public1 = new Publicacion(5, "REPASANDO UN POCO HIBERNATE 1");
    Publicacion public2 = new Publicacion(6, "REPASANDO UN POCO HIBERNATE 2");
    Publicacion public3 = new Publicacion(7, "REPASANDO UN POCO HIBERNATE 3");
    Publicacion public4 = new Publicacion(8, "REPASANDO UN POCO HIBERNATE 4");
    
    
    admin.setPublicaciones(Arrays.asList(public1,public2));
    user.setPublicaciones(Arrays.asList(public3, public4, public2));
    
    sesion.beginTransaction();
    
//    sesion.saveOrUpdate(admin);
//    sesion.saveOrUpdate(user);
//    sesion.saveOrUpdate(public1);
//    sesion.saveOrUpdate(public2);
//    sesion.saveOrUpdate(public3);
//    sesion.saveOrUpdate(public4);
    
    
    Usuario recorreUser = sesion.get(Usuario.class,3);
    recorreUser.getPublicaciones().forEach(t-> System.out.println(t.getTexto()));
    
    sesion.getTransaction().commit();
    
    
    sesion.close();
            
  }
}
