package com.biziukov.task_2.service;

import com.biziukov.task_2.domain.User;
import com.biziukov.task_2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> select() {
        return userRepository.select();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public void update(User user) {
        userRepository.update(user);
    }
}