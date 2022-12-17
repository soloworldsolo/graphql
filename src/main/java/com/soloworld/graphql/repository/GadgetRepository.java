package com.soloworld.graphql.repository;

import com.soloworld.graphql.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface  GadgetRepository extends JpaRepository<Gadget, Integer> {


}
