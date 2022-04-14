package com.springsimplespasos.hibernate.entidades.manytoone;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nano
 */
@Entity
@Table(name="personas")
public class Persona implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo;
  
  @Column(nullable = false, length = 15)
  private String nombre;
  
  @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //relacion de una a muchos una persona puede tener muchos telefonos
  private List<Telefono> telefonos;
  
  
  public Persona(){
  
  }

  public Persona(Integer codigo, String nombre) {
    this.codigo = codigo;
    this.nombre = nombre;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Telefono> getTelefonos() {
    return telefonos;
  }

  public void setTelefonos(List<Telefono> telefonos) {
    this.telefonos = telefonos;
  }
  
  
    
}
