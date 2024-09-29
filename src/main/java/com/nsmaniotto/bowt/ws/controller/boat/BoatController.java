package com.nsmaniotto.bowt.ws.controller.boat;

import com.nsmaniotto.bowt.persistence.entity.boat.Boat;
import com.nsmaniotto.bowt.ws.dto.boat.BoatDto;
import com.nsmaniotto.bowt.ws.mapper.boat.BoatMapper;
import com.nsmaniotto.bowt.ws.service.boat.BoatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("boats")
public class BoatController {

    /* =============== SERVICES =============== */

    private final BoatService boatService;

    /* =============== MAPPERS =============== */

    private final BoatMapper boatMapper;

    /* =============== GET MAPPINGS =============== */

    @GetMapping
    public ResponseEntity<List<BoatDto>> getBoats() {
        List<Boat> boats = boatService.getAll();
        List<BoatDto> boatDtoList = boats.stream().map(boatMapper::toBoatListDto).collect(Collectors.toList());

        return ResponseEntity.ok(boatDtoList);
    }

    /* =============== POST MAPPINGS =============== */

    @PostMapping
    public ResponseEntity<BoatDto> create(@RequestBody BoatDto boatDto) throws URISyntaxException {
        BoatDto createdBoatDto = boatMapper.toIdDto(boatService.create(boatDto));

        URI endpointURI = new URI("/boats/" + createdBoatDto.getId());

        return ResponseEntity.created(endpointURI).body(createdBoatDto);
    }

}
