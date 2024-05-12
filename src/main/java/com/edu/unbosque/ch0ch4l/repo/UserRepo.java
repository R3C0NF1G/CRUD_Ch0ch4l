package com.edu.unbosque.ch0ch4l.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.unbosque.ch0ch4l.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{


}
