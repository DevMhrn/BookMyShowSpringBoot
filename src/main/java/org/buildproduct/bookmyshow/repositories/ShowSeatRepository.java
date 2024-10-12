package org.buildproduct.bookmyshow.repositories;

import org.buildproduct.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findAllById(List<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);


}
