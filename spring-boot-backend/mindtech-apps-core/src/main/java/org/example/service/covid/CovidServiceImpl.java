package org.example.service.covid;

import org.example.dto.CovidDTO;
import org.example.entity.Covid;
import org.example.mapper.CovidMapper;
import org.example.repository.CovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CovidServiceImpl implements CovidService {

    @Autowired
    private CovidRepository covidRepository;

    @Override
    public void saveCovidList(List<Covid> covidList) {
        covidRepository.saveAll(covidList);
    }

    @Override
    public List<CovidDTO> findByDate(LocalDateTime firstDate, LocalDateTime lastDate) {
        return CovidMapper.INSTANCE.covidListToCovidDtoList(covidRepository.findAllByDate(firstDate, lastDate));
    }
}
