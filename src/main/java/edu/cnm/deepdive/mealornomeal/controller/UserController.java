package edu.cnm.deepdive.mealornomeal.controller;

//TODO push to paul
import edu.cnm.deepdive.mealornomeal.model.entity.User;
import edu.cnm.deepdive.mealornomeal.model.service.UserRepository;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The User Controller  is for the User to setup their user page.
 */

@RestController
@RequestMapping("/users")
@ExposesResourceFor(User.class)
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * The Get mapping gets the user name of the user.
   * @return
   */

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<User> getAll() {
    return userRepository.getAllByOrdOrderByNameAsc();
  }

  /**
   * The get mapping here gets the id the user given from the user Repository.
   * @param id
   * @return
   * @throws NoSuchFieldException
   */

  @GetMapping(value ="/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public User get(@PathVariable long id ) throws NoSuchFieldException {
    return userRepository.findById(id).orElseThrow(NoSuchFieldException::new);
  }


}

