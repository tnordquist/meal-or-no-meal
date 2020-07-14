package edu.cnm.deepdive.mealornomeal.model.service;

import edu.cnm.deepdive.mealornomeal.model.entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;


  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public synchronized User readOrCreateOne(String oauthKey, String name) {
    return userRepository.findFirstByOauthKey(oauthKey)
        .orElseGet(() -> {
          User user = new User();
          user.setOauthKey(oauthKey);
          user.setName(name);
          return userRepository.save(user);
        });
  }

  public Optional<User> get(Long id) {
    return userRepository.findById(id);
  }

}
