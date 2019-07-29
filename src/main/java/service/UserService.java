package service;

import model.User;
import utils.exceptions.NotFoundException;

import java.util.List;

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
