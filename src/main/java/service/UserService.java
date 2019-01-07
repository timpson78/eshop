package service;

import model.User;
import org.springframework.stereotype.Service;
import utils.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByEmail(String email) throws NotFoundException;
    User findById(int id);

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);


    List<User> getAll();

    void enable(int id, boolean enable);

}
