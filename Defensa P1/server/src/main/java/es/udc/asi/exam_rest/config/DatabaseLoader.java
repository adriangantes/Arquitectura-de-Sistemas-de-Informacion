package es.udc.asi.exam_rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import es.udc.asi.exam_rest.model.domain.Artista;
import es.udc.asi.exam_rest.model.domain.Disco;
import es.udc.asi.exam_rest.model.exception.UserLoginExistsException;
import es.udc.asi.exam_rest.model.repository.ArtistaDao;
import es.udc.asi.exam_rest.model.repository.CancionDao;
import es.udc.asi.exam_rest.model.repository.DiscoDao;

@Configuration
public class DatabaseLoader {

  @Autowired
  private DiscoDao discoDao;

  @Autowired
  private ArtistaDao artistaDao;

  @Autowired
  private CancionDao cancionDao;

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void loadData() throws UserLoginExistsException, InterruptedException {
    Artista caamagno = new Artista("Familia Caamagno");
    artistaDao.create(caamagno);

    Disco habia = new Disco("Había que intentalo", caamagno, "Castromil", "Un día espectacular", "Proceso Soberanista",
        "Canción Moderna de Oriente", "O peor non son os cartos", "Guapos de primeira", "Tabernas e Rotondas",
        "Cocogualla", "Canción Moderna de Occidente");
    discoDao.create(habia);
    habia.getCanciones().forEach(cancion -> cancionDao.create(cancion));

    Disco hai = new Disco("Hai Que Andar Cos Tempos", caamagno, "Surfistas Nazis", "Rantanplan", "Mentireira",
        "C'mon Baby, Unga Unga!", "Fóra De Control", "Mala Herba");
    discoDao.create(hai);
    hai.getCanciones().forEach(cancion -> cancionDao.create(cancion));

    Artista ataque = new Artista("Ataque Escampe");
    artistaDao.create(ataque);

    Disco violentos = new Disco("Violentos anos dez", ataque, "Segunda división", "Once Upon a Time: a Terra Cha",
        "Misión de audaces", "A cabana do tío Tom", "O amor en Acapulco", "Curtis Mayfield", "Esparadrapo",
        "Festa malandrómica", "Pel de serpe", "Spiritual 2019");
    discoDao.create(violentos);
    violentos.getCanciones().forEach(cancion -> cancionDao.create(cancion));

    Artista som = new Artista("Som do Galpóm");
    artistaDao.create(som);

    Disco galinha = new Disco("Galinha de Troia", som, "Inconforme", "A Piques de Estoupar", "Morro por Dentro",
        "A Viaxe Comezou", "Botamolos de Menos", "Non Quero Non", "Imaxina", "Vida Minha", "O Informal");
    discoDao.create(galinha);

    Artista sugar = new Artista("Sugarless");
    artistaDao.create(sugar);
    galinha.getCanciones().forEach(cancion -> cancionDao.create(cancion));

    Disco masGas = new Disco("Más gas", sugar, "Miedo", "Más Gas", "QueBolá", "No", "El Patio", "Abre tu Sonrisa",
        "Imperio Del Sueño", "Un Día Perfecto", "Más de Mí", "Sugar Sexy Sound");
    discoDao.create(masGas);
    masGas.getCanciones().forEach(cancion -> cancionDao.create(cancion));
  }

}
