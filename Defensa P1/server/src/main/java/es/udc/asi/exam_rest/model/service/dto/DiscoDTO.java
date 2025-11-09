package es.udc.asi.exam_rest.model.service.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import es.udc.asi.exam_rest.model.domain.Disco;

public class DiscoDTO {
  private Long id;
  private String titulo;
  private ArtistaDTO interprete;
  private Set<CancionDTO> canciones = new HashSet<>();

  public DiscoDTO() {
  }

  public DiscoDTO(Disco d) {
    this.id = d.getId();
    this.titulo = d.getTitulo();
    this.interprete = new ArtistaDTO(d.getInterprete());
    this.setCanciones(d.getCanciones().stream().map(c -> new CancionDTO(c)).collect(Collectors.toSet()));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public ArtistaDTO getInterprete() {
    return interprete;
  }

  public void setInterprete(ArtistaDTO interprete) {
    this.interprete = interprete;
  }

  public Set<CancionDTO> getCanciones() {
    return canciones;
  }

  public void setCanciones(Set<CancionDTO> canciones) {
    this.canciones = canciones;
  }
}
