package com.tarka.tarka.repositories;

import com.tarka.tarka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
