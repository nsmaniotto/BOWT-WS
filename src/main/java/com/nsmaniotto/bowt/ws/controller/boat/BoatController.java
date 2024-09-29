package com.nsmaniotto.bowt.ws.controller.boat;

import com.nsmaniotto.bowt.ws.dto.boat.BoatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("boats")
public class BoatController {

    @GetMapping
    public ResponseEntity<List<BoatDto>> getBoats() {
        return ResponseEntity.ok(new ArrayList<>());
    }

}
