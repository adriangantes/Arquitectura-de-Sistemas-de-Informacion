package es.udc.asi.exam_rest.model.repository;

import java.util.List;

import es.udc.asi.exam_rest.model.domain.Artista;

public interface ArtistaDao {

  void create(Artista artista);

  List<Artista> findAll();

  Artista findById(Long id);

}
