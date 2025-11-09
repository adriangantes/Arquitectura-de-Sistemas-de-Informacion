package es.udc.asi.exam_rest.model.repository.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class GenericDaoJpa {
  @PersistenceContext
  protected EntityManager entityManager;
}
