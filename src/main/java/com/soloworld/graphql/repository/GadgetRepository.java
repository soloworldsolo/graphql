package com.soloworld.graphql.repository;

import com.soloworld.graphql.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GadgetRepository extends JpaRepository<Gadget, Integer> {


}
