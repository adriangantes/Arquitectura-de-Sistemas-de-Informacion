package es.udc.asi.exam_rest.model.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.asi.exam_rest.model.domain.Artista;
import es.udc.asi.exam_rest.model.exception.NotFoundException;
import es.udc.asi.exam_rest.model.repository.ArtistaDao;
import es.udc.asi.exam_rest.model.service.dto.ArtistaDTO;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ArtistaService {

  @Autowired
  private ArtistaDao artistaDAO;

  public Set<ArtistaDTO> findAll() {
    return artistaDAO.findAll().stream().map(a -> new ArtistaDTO(a)).collect(Collectors.toSet());
  }

  public ArtistaDTO findById(Long id) throws NotFoundException {
    Artista artista = artistaDAO.findById(id);
    if (artista == null) {
      throw new NotFoundException(id.toString(), Artista.class);
    }
    return new ArtistaDTO(artista);
  }

}
