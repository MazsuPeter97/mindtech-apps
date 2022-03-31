package org.example.service.covid;

import org.example.dto.CovidDTO;
import org.example.entity.Covid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * CovidService interface.
 */
public interface CovidService {

    /**
     * Save covid entity list.
     *
     * @param covidList
     */
    public void saveCovidList(List<Covid> covidList);

    /**
     * Find CovidDTO by started date and ended date.
     *
     * @param firstDate
     * @param lastDate
     * @return
     */
    public List<CovidDTO> findByDate(LocalDateTime firstDate, LocalDateTime lastDate);
}
