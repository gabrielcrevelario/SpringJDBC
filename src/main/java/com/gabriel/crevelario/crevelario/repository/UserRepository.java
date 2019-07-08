package com.gabriel.crevelario.crevelario.repository;

import com.gabriel.crevelario.crevelario.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value="{select * from User where email= :email and password = :password}",
            nativeQuery = true)
    User login(String email,String password );

}
