package com.nsmaniotto.bowt.persistence.repository.boat;

import com.nsmaniotto.bowt.persistence.entity.boat.Boat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatRepository extends CrudRepository<Boat, Long> {
    public List<Boat> findAllByOrderByIdAsc();
}