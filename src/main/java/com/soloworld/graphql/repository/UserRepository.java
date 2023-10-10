package com.soloworld.graphql.repository;

import com.soloworld.graphql.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Integer> {

    List<UserDetail> getByEmail(String username);
}
