package com.kerimsenturk.linkbranch.repository;

import com.kerimsenturk.linkbranch.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
    List<Link> findAllByUser_Username(String username);
    List<Link> findAllByUser_Uuid(int uuid);
}
