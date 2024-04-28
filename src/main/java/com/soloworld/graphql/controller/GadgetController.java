package com.soloworld.graphql.controller;

import com.soloworld.graphql.model.Gadget;
import com.soloworld.graphql.model.Version;
import com.soloworld.graphql.repository.VersionRepository;
import com.soloworld.graphql.service.GadgetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class GadgetController {
    private final GadgetService gadgetService;
    private final VersionRepository versionRepository;

    public GadgetController(GadgetService gadgetService, VersionRepository versionRepository) {
        this.gadgetService = gadgetService;
        this.versionRepository = versionRepository;
    }

    @QueryMapping
    public List<Gadget> getGadgets() {
        return gadgetService.getGadgetList();
    }

    @QueryMapping
    public Optional<Gadget> gadgetbyId(@Argument Integer id) {
        return gadgetService.gadgetOptional(id);
    }

    @MutationMapping
    public Gadget addGadget(@Argument Gadget gadget) {
        return gadgetService.saveGadget(gadget);
    }

    @MutationMapping
    public Version addVersion(@Argument Version version) {
        return gadgetService.saveVersion(version);
    }

    @BatchMapping(typeName = "Gadget")
    public Map<Gadget, List<Version>> versions(List<Gadget> gadget) {
        Map<Gadget, List<Version>> gadgetListMap = new HashMap<>();
        for (Gadget gadget1 : gadget) {
            gadgetListMap.put(gadget1, versionRepository.findByGadgetId(gadget1.getId()));
        }
        return gadgetListMap;
    }
}
