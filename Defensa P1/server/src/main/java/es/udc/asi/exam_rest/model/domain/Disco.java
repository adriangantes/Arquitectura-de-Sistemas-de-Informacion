package es.udc.asi.exam_rest.model.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Disco {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "album_generator")
  @SequenceGenerator(name = "album_generator", sequenceName = "album_seq", initialValue = 8471)
  private Long id;

  private String titulo;

  @ManyToOne(fetch = FetchType.EAGER)
  private Artista interprete;

  @OneToMany(mappedBy = "disco", fetch = FetchType.EAGER)
  private Set<Cancion> canciones = new HashSet<>();

  public Disco() {
  }

  public Disco(String titulo, Artista interprete, String... canciones) {
    this.setInterprete(interprete);
    this.setTitulo(titulo);
    for (int i = 0; i < canciones.length; i++) {
      this.getCanciones().add(new Cancion(i + 1, canciones[i], this));
    }
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

  public Artista getInterprete() {
    return interprete;
  }

  public void setInterprete(Artista interprete) {
    this.interprete = interprete;
  }

  public Set<Cancion> getCanciones() {
    return canciones;
  }

  public void setCanciones(Set<Cancion> canciones) {
    this.canciones = canciones;
  }
}
