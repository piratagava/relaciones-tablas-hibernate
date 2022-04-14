package com.springsimplespasos.hibernate.entidades.onetoone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carnets")
public class Carnet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo;

  @Column(length = 20, unique = true)
  private String numero;

  @OneToOne
  @JoinColumn(name = "id_socio", foreignKey = @ForeignKey(name = "FK_ID_SOCIO"))
  private Socio socio;

  public Carnet() {

  }

  public Carnet(Integer codigo, String numero) {
    super();
    this.codigo = codigo;
    this.numero = numero;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Socio getSocio() {
    return socio;
  }

  public void setSocio(Socio socio) {
    this.socio = socio;
  }

}
