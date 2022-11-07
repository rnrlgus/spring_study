package UMC.API.controller;

import UMC.API.domain.User;
import UMC.API.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/new")
    public ResponseEntity<?> create(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        user.setUserId(userForm.getUserId());
        userService.join(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity readAll() {
        List<User> users = userService.findUsers();

        Map<String, Object> response = new HashMap<>();
        response.put("users", users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("users/delete")
    public ResponseEntity<?> delete(@RequestParam String userName) {
        userService.deleteUser(userName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
