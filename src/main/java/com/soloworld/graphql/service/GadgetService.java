package com.soloworld.graphql.service;

import com.soloworld.graphql.model.Gadget;
import com.soloworld.graphql.model.GadgetInput;
import com.soloworld.graphql.model.Version;
import com.soloworld.graphql.repository.GadgetRepository;
import com.soloworld.graphql.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    private GadgetRepository gadgetRepository;
    private VersionRepository versionRepository;

    public List<Gadget> getGadgetList(){
        return gadgetRepository.findAll();
    }

    public Optional<Gadget> gadgetOptional(Integer id) {
        return gadgetRepository.findById(id);
    }

    public Gadget saveGadget(Gadget gadget) {
        return  gadgetRepository.save(gadget);
    }


    public Version saveVersion(Version version) {
        return versionRepository.save(version);
    }


    public GadgetService(GadgetRepository gadgetRepository, VersionRepository versionRepository) {
        this.gadgetRepository = gadgetRepository;
        this.versionRepository = versionRepository;
    }
}
