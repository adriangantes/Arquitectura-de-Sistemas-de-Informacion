package es.udc.asi.exam_rest.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Cancion {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_generator")
  @SequenceGenerator(name = "cancion_generator", sequenceName = "cancion_seq", initialValue = 984517)
  private Long id;

  private Integer numeroDePista;

  private String titulo;

  @ManyToOne(fetch = FetchType.LAZY)
  private Disco disco;

  public Cancion() {
  }

  public Cancion(int numPista, String titulo, Disco album) {
    this.setTitulo(titulo);
    this.setNumeroDePista(numPista);
    this.setDisco(album);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getNumeroDePista() {
    return numeroDePista;
  }

  public void setNumeroDePista(Integer numeroDePista) {
    this.numeroDePista = numeroDePista;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Disco getDisco() {
    return disco;
  }

  public void setDisco(Disco disco) {
    this.disco = disco;
  }
}
