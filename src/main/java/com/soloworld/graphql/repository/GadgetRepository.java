package com.soloworld.graphql.repository;

import com.soloworld.graphql.model.Gadget;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;



@GraphQlRepository
public interface GadgetRepository extends JpaRepository<Gadget, Integer> {

    Window<Gadget> findAllBy(ScrollPosition scrollPosition, Limit limit, Sort sort);

}
