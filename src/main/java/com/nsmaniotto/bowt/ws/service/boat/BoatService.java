package com.nsmaniotto.bowt.ws.service.boat;

import com.nsmaniotto.bowt.persistence.entity.boat.Boat;
import com.nsmaniotto.bowt.persistence.repository.boat.BoatRepository;
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

}
