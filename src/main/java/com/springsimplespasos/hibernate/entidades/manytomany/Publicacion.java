package com.springsimplespasos.hibernate.entidades.manytomany;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author nano
 */
@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_publicacion")
  private Integer codigo;
  
  @Column(nullable = false)
  private String texto;

  @ManyToMany(mappedBy = "publicaciones", cascade = CascadeType.ALL )
  private List<Usuario> usuarios;
  
  public Publicacion() {
  }

  public Publicacion(Integer codigo, String texto) {
    this.codigo = codigo;
    this.texto = texto;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
  
  
}
