package com.kerimsenturk.linkbranch.repository;

import com.kerimsenturk.linkbranch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User getUserByUsername(String username);
    User getUserByUuid(int uuid);
    boolean existsUsersByUsername(String username);
    boolean existsUsersByMail(String mail);
}
