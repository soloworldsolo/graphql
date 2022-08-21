package com.soloworld.graphql.controller;

import com.soloworld.graphql.model.Gadget;
import com.soloworld.graphql.service.GadgetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GadgetController {
    private GadgetService gadgetService;

    public GadgetController(GadgetService gadgetService) {
        this.gadgetService = gadgetService;
    }

    @QueryMapping
    public List<Gadget> getGadgets() {
        return gadgetService.getGadgetList();
    }

    @QueryMapping
    public Optional<Gadget> gadgetbyId(@Argument  Integer id) {
        return gadgetService.gadgetOptional(id);
    }

    @MutationMapping
    public Gadget addGadget(@Argument Gadget gadget) {
        return gadgetService.saveGadget(gadget);
    }
}
