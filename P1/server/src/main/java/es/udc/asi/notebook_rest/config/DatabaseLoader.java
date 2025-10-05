package es.udc.asi.notebook_rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import es.udc.asi.notebook_rest.model.domain.Category;
import es.udc.asi.notebook_rest.model.domain.Note;
import es.udc.asi.notebook_rest.model.domain.User;
import es.udc.asi.notebook_rest.model.exception.UserLoginExistsException;
import es.udc.asi.notebook_rest.model.repository.CategoryDao;
import es.udc.asi.notebook_rest.model.repository.NoteDao;
import es.udc.asi.notebook_rest.model.repository.UserDao;
import es.udc.asi.notebook_rest.model.service.UserService;

@Configuration
public class DatabaseLoader {

  @Autowired
  private UserDao userDAO;

  @Autowired
  private UserService userService;

  @Autowired
  private NoteDao noteDAO;

  @Autowired
  private CategoryDao categoryDAO;

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void loadData() throws UserLoginExistsException, InterruptedException {
    userService.registerUser("pepemin", "pepemin", true);
    userService.registerUser("adri", "adri", true);
    userService.registerUser("mariadmin", "mariadmin", true);
    userService.registerUser("laura", "laura");
    userService.registerUser("pedroff", "pedroff");
    User pedro = userDAO.findByLogin("pedroff");
    pedro.setActive(false);
    userDAO.update(pedro);
    userService.registerUser("ramón", "ramón");

    Category shopping = new Category("Shopping");
    Category task = new Category("Task");
    Category book = new Category("Book");
    Category game = new Category("Game");

    categoryDAO.create(shopping);
    categoryDAO.create(task);
    categoryDAO.create(book);
    categoryDAO.create(game);

    Note limones = new Note("Limones", null, userDAO.findByLogin("laura"));
    limones.getCategories().add(shopping);
    noteDAO.create(limones);
    Thread.sleep(1000);
    Note farmer = new Note("Farmer Against Potatoes Idle", null, userDAO.findByLogin("laura"));
    farmer.getCategories().add(task);
    farmer.getCategories().add(game);
    noteDAO.create(farmer);
    Thread.sleep(1000);
    Note manzanas = new Note("Manzanas", "De las que estén de oferta", userDAO.findByLogin("ramón"));
    manzanas.getCategories().add(shopping);
    noteDAO.create(manzanas);
    Note dni = new Note("Renovar DNI", null, userDAO.findByLogin("ramón"));
    noteDAO.create(dni);
  }

}
