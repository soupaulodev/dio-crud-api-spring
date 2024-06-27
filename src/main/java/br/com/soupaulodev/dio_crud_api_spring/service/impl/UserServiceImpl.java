package br.com.soupaulodev.dio_crud_api_spring.service.impl;

import org.springframework.stereotype.Service;

import br.com.soupaulodev.dio_crud_api_spring.domain.Repository.UserRepository;
import br.com.soupaulodev.dio_crud_api_spring.domain.model.User;
import br.com.soupaulodev.dio_crud_api_spring.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        boolean userAlreadyExists = userRepository.existsById(id);

        if (!userAlreadyExists) {
            throw new IllegalArgumentException("User not found.");
        }
        
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        boolean userAlreadyExists = userRepository.existsById(userToCreate.getId());
        boolean userAccountAlreadyExists = userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber());

        if (userAlreadyExists) {
            throw new IllegalArgumentException("User already exists.");
        }
        if (userAccountAlreadyExists) {
            throw new IllegalArgumentException("This account number already exists.");
        }

        return userRepository.save(userToCreate);
    }
}
