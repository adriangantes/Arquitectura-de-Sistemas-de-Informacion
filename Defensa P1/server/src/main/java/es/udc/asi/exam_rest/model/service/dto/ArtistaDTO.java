package es.udc.asi.exam_rest.model.service.dto;

import es.udc.asi.exam_rest.model.domain.Artista;

public class ArtistaDTO {
  private Long id;
  private String nombre;

  public ArtistaDTO() {
  }

  public ArtistaDTO(Artista interprete) {
    this.id = interprete.getId();
    this.nombre = interprete.getNombre();
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
