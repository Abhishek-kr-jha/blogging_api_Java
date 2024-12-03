package com.bloggingApp.com.bloggApp_api.repositories;

import com.bloggingApp.com.bloggApp_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
