package org.example.laptopshop.repository;

import org.example.laptopshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    List<User> findOneByEmail(String email);

    List<User> findAll();

    User findById(long id);

//    void updateById(long id, User user);
}
