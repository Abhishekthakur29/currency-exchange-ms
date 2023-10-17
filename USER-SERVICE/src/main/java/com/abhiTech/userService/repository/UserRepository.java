package com.abhiTech.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhiTech.userService.bean.UserBean;

@Repository
public interface UserRepository extends JpaRepository<UserBean, String>{

}
