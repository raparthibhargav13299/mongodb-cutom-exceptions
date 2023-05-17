package com.stackroute.springboot.repository;

import com.stackroute.springboot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {


    @Query("FROM User WHERE gender =:gender")
    public List<User> findUsersByfirstname(@Param("gender") String gender);




}
