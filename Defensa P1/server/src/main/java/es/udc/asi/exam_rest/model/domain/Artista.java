package es.udc.asi.exam_rest.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Artista {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artista_generator")
  @SequenceGenerator(name = "artista_generator", sequenceName = "artista_seq", initialValue = 549)
  private Long id;
  
  private String nombre;

  public Artista() {
  }

  public Artista(String nombre) {
    this.setNombre(nombre);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
