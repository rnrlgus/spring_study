package UMC.API.repository;

import UMC.API.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    Optional<User> findByName(String userName);

    String delete(String userName);


}
