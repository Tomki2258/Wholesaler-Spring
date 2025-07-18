package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.User;
import com.tamus.Wholesaler.Repository.IUserRepository;
import com.tamus.Wholesaler.Repository.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController implements IUserRepository {
    private UsersService usersService = new UsersService();
    @GetMapping("/getAll")
    @Override
    public List<User> getAll() {
        return usersService.getAll();
    }

    @GetMapping("/getByIndex")
    @Override
    public Optional<User> getByIndex(@RequestParam int index) {
        return usersService.getByIndex(index);
    }

    @GetMapping("/findByLogin")
    @Override
    public Optional<User> findByLogin(@RequestParam String login) {
        return usersService.findByLogin(login);
    }

    @PostMapping("/addUser")
    @Override
    public void addUser(@RequestBody User user) {
        usersService.addUser(user);
    }
}
