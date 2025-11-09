package es.udc.asi.exam_rest.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.udc.asi.exam_rest.model.exception.NotFoundException;
import es.udc.asi.exam_rest.model.service.DiscoService;
import es.udc.asi.exam_rest.model.service.dto.CancionDTOForm;
import es.udc.asi.exam_rest.model.service.dto.DiscoDTO;

@RestController
@RequestMapping("/api/discos")
public class DiscoResource {

  @Autowired
  private DiscoService discoService;

  @GetMapping
  public Set<DiscoDTO> getDiscos() {
    return discoService.findAll();
  }

  @GetMapping("/{id}")
  public DiscoDTO getDisco(@PathVariable Long id) throws NotFoundException {
    return discoService.findById(id);
  }

  @PutMapping("/{id}/canciones")
  public DiscoDTO anadirCancion(@PathVariable Long id, @RequestBody CancionDTOForm cancion) throws NotFoundException {
    return discoService.anadirCancion(id, cancion);
  }
}
