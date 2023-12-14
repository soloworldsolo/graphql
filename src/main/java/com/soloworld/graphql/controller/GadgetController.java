package com.soloworld.graphql.controller;

import com.soloworld.graphql.model.Gadget;
import com.soloworld.graphql.model.Version;
import com.soloworld.graphql.repository.VersionRepository;
import com.soloworld.graphql.service.GadgetService;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.query.ScrollSubrange;
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
    public Window<Gadget> getGadgets(ScrollSubrange scrollSubrange) {
        ScrollPosition scrollPosition = scrollSubrange.position().orElse(ScrollPosition.offset());
        Limit limit = Limit.of(scrollSubrange.count().orElse(10));
        Sort sort = Sort.by("name");
        var res = gadgetService.getGadgetList(scrollPosition ,limit,sort);
        System.out.println(res.get().count());
        return res;
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
