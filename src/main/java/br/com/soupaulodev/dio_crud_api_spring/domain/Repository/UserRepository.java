package br.com.soupaulodev.dio_crud_api_spring.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soupaulodev.dio_crud_api_spring.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
