package com.springsimplespasos.hibernate.entidades.onetoone;

import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "socios")
public class Socio implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer codigo;

  @Column(length = 40)
  private String nombre;

  @Column(unique = true, length = 40)
  private String documento;

  /*hacemos el mapeo a socio ya que Carnet es el dueño de la relacion que va tener a socio
	Siempre que veamos mappedBy significa que la otra entidad que la contiene es el dueño de la realacion, se usa cascade all porque de esa manera puede lograr persistir la llave foranea cuando creo mi objobjeto*/
  @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
  private Carnet carnet;

  public Socio() {

  }

  public Socio(Integer codigo, String nombre, String documento) {
    super();
    this.codigo = codigo;
    this.nombre = nombre;
    this.documento = documento;
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

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public Carnet getCarnet() {
    return carnet;
  }

  public void setCarnet(Carnet carnet) {
    this.carnet = carnet;
  }

  @Override
  public String toString() {
    return "Socio [codigo=" + codigo + ", nombre=" + nombre + ", documento=" + documento + "]";
  }

}
