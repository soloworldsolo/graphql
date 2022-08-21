package com.soloworld.graphql.service;

import com.soloworld.graphql.model.Gadget;
import com.soloworld.graphql.model.GadgetInput;
import com.soloworld.graphql.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadget> getGadgetList(){
        return gadgetRepository.findAll();
    }

    public Optional<Gadget> gadgetOptional(Integer id) {
        return gadgetRepository.findById(id);
    }

    public Gadget saveGadget(Gadget gadget) {
        return  gadgetRepository.save(gadget);
    }



}
