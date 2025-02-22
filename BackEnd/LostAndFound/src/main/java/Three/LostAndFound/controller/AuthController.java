package Three.LostAndFound.controller;

import Three.LostAndFound.model.User;
import Three.LostAndFound.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class AuthController{

        @Autowired
        private AuthService userService;

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            return ResponseEntity.ok(userService.createUser(user));
        }

        @GetMapping
        public ResponseEntity<List<User>> getAllUsers() {
            return ResponseEntity.ok(userService.getAllUsers());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Optional<User>> getUserById(@PathVariable String id) {
            return ResponseEntity.ok(userService.getUserById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
            return ResponseEntity.ok(userService.updateUser(id, user));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable String id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
}