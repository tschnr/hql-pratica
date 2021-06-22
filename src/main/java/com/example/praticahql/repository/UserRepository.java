package com.example.praticahql.repository;
import com.example.praticahql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query("SELECT  u FROM User u WHERE u.name LIKE %?1%")
    List<User> findByUserNameContains(String name);

    @Query("SELECT  u FROM User u WHERE u.userId = ?1")
    List<User> findUserById(Long userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u where u.userId = :id ")
    void deleteUser(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE User u set u.password = :password WHERE u.userId = :id")
    void updateUserPassword(String password, Long id);

}
