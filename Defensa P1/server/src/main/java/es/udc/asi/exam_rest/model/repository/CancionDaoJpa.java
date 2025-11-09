package es.udc.asi.exam_rest.model.repository;

import org.springframework.stereotype.Repository;

import es.udc.asi.exam_rest.model.domain.Cancion;
import es.udc.asi.exam_rest.model.repository.util.GenericDaoJpa;

@Repository
public class CancionDaoJpa extends GenericDaoJpa implements CancionDao {

  @Override
  public void create(Cancion cancion) {
    entityManager.persist(cancion);
  }

}
