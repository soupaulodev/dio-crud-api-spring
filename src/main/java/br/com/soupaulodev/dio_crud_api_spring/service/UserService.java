package br.com.soupaulodev.dio_crud_api_spring.service;

import br.com.soupaulodev.dio_crud_api_spring.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User user);
}
