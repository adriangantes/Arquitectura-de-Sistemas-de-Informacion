package es.udc.asi.exam_rest.model.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.asi.exam_rest.model.domain.Artista;
import es.udc.asi.exam_rest.model.domain.Cancion;
import es.udc.asi.exam_rest.model.domain.Disco;
import es.udc.asi.exam_rest.model.exception.NotFoundException;
import es.udc.asi.exam_rest.model.repository.ArtistaDao;
import es.udc.asi.exam_rest.model.repository.CancionDao;
import es.udc.asi.exam_rest.model.repository.DiscoDao;
import es.udc.asi.exam_rest.model.service.dto.CancionDTOForm;
import es.udc.asi.exam_rest.model.service.dto.DiscoDTO;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DiscoService {

  @Autowired
  private DiscoDao discoDAO;

  @Autowired
  private ArtistaDao artistaDAO;

  @Autowired
  private CancionDao cancionDAO;

  public Set<DiscoDTO> findAll() {
    return discoDAO.findAll().stream().map(d -> new DiscoDTO(d)).collect(Collectors.toSet());
  }

  public DiscoDTO findById(Long id) throws NotFoundException {
    return new DiscoDTO(getDisco(id));
  }

  public Set<DiscoDTO> findByArtista(Long id) throws NotFoundException {
    if (artistaDAO.findById(id) == null) {
      throw new NotFoundException(id.toString(), Artista.class);
    }

    return discoDAO.findByArtista(id).stream().map(d -> new DiscoDTO(d)).collect(Collectors.toSet());
  }

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public DiscoDTO anadirCancion(Long id, CancionDTOForm cancion) throws NotFoundException {
    Disco disco = getDisco(id);
    Cancion bdCancion = new Cancion(disco.getCanciones().size() + 1, cancion.getCancion(), disco);
    cancionDAO.create(bdCancion);
    disco.getCanciones().add(bdCancion);
    return new DiscoDTO(disco);
  }

  private Disco getDisco(Long id) throws NotFoundException {
    Disco disco = discoDAO.findById(id);
    if (disco == null) {
      throw new NotFoundException(id.toString(), Disco.class);
    }
    return disco;
  }
}
