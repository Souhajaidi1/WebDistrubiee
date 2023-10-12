package com.example.postcomment.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.postcomment.entities.Forbiden;

@Repository

public interface ForbidenRepository extends JpaRepository<Forbiden,Long> {




}
