package com.example.instagram.dao;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;
// import org.springframework.stereotype.Repository;

import com.example.instagram.model.User;
// @Repository
public interface IRepository extends JpaRepository<User,Integer>{
    
}
