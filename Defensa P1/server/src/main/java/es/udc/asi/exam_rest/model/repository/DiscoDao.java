package es.udc.asi.exam_rest.model.repository;

import java.util.List;

import es.udc.asi.exam_rest.model.domain.Disco;

public interface DiscoDao {
  List<Disco> findAll();

  void create(Disco disco);

  List<Disco> findByArtista(Long id);

  Disco findById(Long id);

  void update(Disco disco);

}
