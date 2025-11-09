package es.udc.asi.exam_rest.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.asi.exam_rest.model.domain.Disco;
import es.udc.asi.exam_rest.model.repository.util.GenericDaoJpa;

@Repository
public class DiscoDaoJpa extends GenericDaoJpa implements DiscoDao {

  @Override
  public List<Disco> findAll() {
    return entityManager.createQuery("from Disco", Disco.class).getResultList();
  }

  @Override
  public void create(Disco disco) {
    entityManager.persist(disco);
  }

  @Override
  public List<Disco> findByArtista(Long id) {
    return entityManager.createQuery("select d from Disco d where d.interprete.id = :id", Disco.class)
        .setParameter("id", id).getResultList();
  }

  @Override
  public Disco findById(Long id) {
    return entityManager.find(Disco.class, id);
  }

  @Override
  public void update(Disco disco) {
    entityManager.merge(disco);
  }

}
