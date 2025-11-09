package es.udc.asi.exam_rest.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.asi.exam_rest.model.domain.Artista;
import es.udc.asi.exam_rest.model.repository.util.GenericDaoJpa;

@Repository
public class ArtistaDaoJpa extends GenericDaoJpa implements ArtistaDao {

  @Override
  public void create(Artista artista) {
    entityManager.persist(artista);
  }

  @Override
  public List<Artista> findAll() {
    return entityManager.createQuery("from Artista", Artista.class).getResultList();
  }

  @Override
  public Artista findById(Long id) {
    return entityManager.find(Artista.class, id);
  }

}
