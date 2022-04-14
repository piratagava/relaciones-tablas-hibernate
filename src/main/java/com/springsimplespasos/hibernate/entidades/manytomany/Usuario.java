package com.springsimplespasos.hibernate.entidades.manytomany;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author nano
 */
@Entity
@Table(name = "usuarios")
public class Usuario  implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Integer codigo;
  
  @Column(length = 20, unique = true, nullable = false)
  private String userName;
  
  @ManyToMany
  @JoinTable(name="usuario_publicacion",
          joinColumns = @JoinColumn(name = "id_usuario"),
          inverseJoinColumns = @JoinColumn(name= "id_publicacion"))
  private List<Publicacion> publicaciones;
  
  public Usuario(){
    
  }

  public Usuario(Integer codigo, String userName) {
    this.codigo = codigo;
    this.userName = userName;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<Publicacion> getPublicaciones() {
    return publicaciones;
  }

  public void setPublicaciones(List<Publicacion> publicaciones) {
    this.publicaciones = publicaciones;
  }
  
  
}
