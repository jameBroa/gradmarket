package com.example.demo.repository;

// This is what interfaces with the Database!!!!!

//      abstracts persistence operations: find (by id or other criteria),
//      save (create, update) and delete records.
//      It should do that and nothing more.

import com.example.demo.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<Users, Long> {

}
