package Three.LostAndFound.service;

import Three.LostAndFound.model.User;
import Three.LostAndFound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ (ALL)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ (BY ID)
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // UPDATE
    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // DELETE
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}