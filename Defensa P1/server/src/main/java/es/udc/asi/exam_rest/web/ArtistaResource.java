package es.udc.asi.exam_rest.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.udc.asi.exam_rest.model.exception.NotFoundException;
import es.udc.asi.exam_rest.model.service.ArtistaService;
import es.udc.asi.exam_rest.model.service.DiscoService;
import es.udc.asi.exam_rest.model.service.dto.ArtistaDTO;
import es.udc.asi.exam_rest.model.service.dto.DiscoDTO;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaResource {

  @Autowired
  private DiscoService discoService;

  @Autowired
  private ArtistaService artistaService;

  @GetMapping
  public Set<ArtistaDTO> getArtistas() {
    return artistaService.findAll();
  }

  @GetMapping("/{id}")
  public ArtistaDTO getArtista(@PathVariable Long id) throws NotFoundException {
    return artistaService.findById(id);
  }

  @GetMapping("/{id}/discos")
  public Set<DiscoDTO> getDiscosDeArtista(@PathVariable Long id) throws NotFoundException {
    return discoService.findByArtista(id);
  }

}
