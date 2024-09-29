package com.nsmaniotto.bowt.ws.controller.boat;

import com.nsmaniotto.bowt.persistence.entity.boat.Boat;
import com.nsmaniotto.bowt.ws.dto.boat.BoatDto;
import com.nsmaniotto.bowt.ws.mapper.boat.BoatMapper;
import com.nsmaniotto.bowt.ws.service.boat.BoatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
