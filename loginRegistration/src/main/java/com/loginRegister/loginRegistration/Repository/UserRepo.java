package com.loginRegister.loginRegistration.Repository;

import com.loginRegister.loginRegistration.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer> {
     User findByEmail(String email);


   // Optional<User> findOneByEmailAndPassword(String email, String passWord);

    @Query(value = "SELECT * FROM my_app_user WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<User> findOneByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    //Optional<User> findOneByEmailAndPassword(String email,String passWord);

}
