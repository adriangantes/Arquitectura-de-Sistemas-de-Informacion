package es.udc.asi.exam_rest.model.service.dto;

import es.udc.asi.exam_rest.model.domain.Cancion;

public class CancionDTO {
  private Long id;
  private Integer numeroDePista;
  private String titulo;

  public CancionDTO() {
  }

  public CancionDTO(Cancion c) {
    this.id = c.getId();
    this.numeroDePista = c.getNumeroDePista();
    this.titulo = c.getTitulo();
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

}
