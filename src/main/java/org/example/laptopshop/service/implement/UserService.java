package org.example.laptopshop.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.laptopshop.entity.User;
import org.example.laptopshop.repository.UserRepository;
import org.example.laptopshop.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User handleSaveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

//    @Override
//    public void updateById(long id, User user) {
//        userRepository.updateById(id, user);
//    }
}
