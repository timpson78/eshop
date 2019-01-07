package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {

        User save(User user);

        // false if not found
        boolean delete(int id);

        // null if not found
        User get(int id);

        // null if not found
        User getByEmail(String email);

        List<User> getAll();

    Optional<User> findByEmail(String email);

    Optional<User> findById(int id);
    boolean existsByEmail(String email);

 }

