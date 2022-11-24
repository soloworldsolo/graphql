package com.soloworld.graphql.repository;

import com.soloworld.graphql.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<Version,Integer> {

    public List<Version> findByGadgetId(Integer gadgetId);

}
