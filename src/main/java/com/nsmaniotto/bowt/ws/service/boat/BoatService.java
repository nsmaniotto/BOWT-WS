package com.nsmaniotto.bowt.ws.service.boat;

import com.nsmaniotto.bowt.persistence.entity.boat.Boat;
import com.nsmaniotto.bowt.persistence.repository.boat.BoatRepository;
import com.nsmaniotto.bowt.ws.dto.boat.BoatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoatService {

    private final BoatRepository boatRepository;

    public List<Boat> getAll() {
        return boatRepository.findAllByOrderByIdAsc();
    }

    public Boat create(BoatDto boatDto) {
        Boat boat = new Boat();

        boat.setName(boatDto.getName());
        boat.setDescription(boatDto.getDescription());

        return boatRepository.save(boat);
    }

}
