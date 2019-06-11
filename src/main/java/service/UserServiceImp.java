package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import repository.UserRepositoryImp;
import utils.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserRepository repository;


    @Override
    public User findByEmail(String email) throws NotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new NotFoundException("user with " + email + " not found")
                );
    }

    @Override
    public User findById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("user with " + id + " not found")
                );
    }

    public UserServiceImp() {
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public void update(User user) {
       repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void enable(int id, boolean enable) {

    }
}




