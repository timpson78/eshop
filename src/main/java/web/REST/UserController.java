package web.REST;

import model.User;
import model.restpayloads.UpdatePassword;
import model.restpayloads.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import service.item.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(UserController.REST_URL)
public class UserController {
    static final String REST_URL = "/rest/users";

    @Autowired
    private UserService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get2(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String update(@Valid @RequestBody() UpdateUser updateUser) {
        User userInDb=service.findById(updateUser.getId());
        if (userInDb!=null) {
            User user = new User(userInDb.getId(), userInDb.getEmail(), userInDb.getPassword(),
                    updateUser.getName(), updateUser.getPhone(), updateUser.getSex(), userInDb.getRegistered(), userInDb.isEnabled(),
                     updateUser.getBirthday(),userInDb.getRoles());
            service.update(user);
        }
         return  "User successfully updated ";
    }

    @PostMapping(value = "/updatepassword", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> update(@Valid @RequestBody() UpdatePassword updatePassword) {
        User userInDb=service.findById(updatePassword.getId());
        if (!passwordEncoder.matches(updatePassword.getOldPassword(),userInDb.getPassword())) {
            return new ResponseEntity<>( "Incorrect password!",
                    HttpStatus.BAD_REQUEST);
        }
        if (!updatePassword.getNewPassword().equals(updatePassword.getConfirmNewPassword())){
            return new ResponseEntity( "Passwords does not match!",
                    HttpStatus.BAD_REQUEST);
        }

        if ("".equals(updatePassword.getNewPassword())){
            return new ResponseEntity( "Password can't be empty!",
                    HttpStatus.BAD_REQUEST);
        }
        if (userInDb!=null) {
            User user = new User(updatePassword.getId(), userInDb.getEmail(), passwordEncoder.encode(updatePassword.getNewPassword()),
                    userInDb.getName(), userInDb.getPhone(), userInDb.getSex(), userInDb.getRegistered(), userInDb.isEnabled(),
                    userInDb.getBirthday(),userInDb.getRoles());
            service.update(user);
        }
        return new ResponseEntity("Password successfully updated",
                HttpStatus.OK);
    }

}
