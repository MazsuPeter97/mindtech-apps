package org.example.controller.impl;

import org.example.controller.ExampleController;
import org.example.dto.CovidDTO;
import org.example.response.CovidResponse;
import org.example.service.covid.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@RestController
public class ExampleControllerImpl implements ExampleController {

    @Autowired
    private CovidService covidService;

    @Override
    public ResponseEntity<CovidResponse> filterByDate(String firstDate, String lastDate) {

        LocalDateTime startDate = LocalDateTime.parse(firstDate, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime enDate = LocalDateTime.parse(lastDate, DateTimeFormatter.ISO_DATE_TIME);

        List<CovidDTO> filteredDtoList = covidService.findByDate(startDate, enDate);

        CovidResponse covidResponse = new CovidResponse();

        if (CollectionUtils.isEmpty(filteredDtoList)) {
            covidResponse.setCovidDTO(Collections.emptyList());
        } else {
            covidResponse.setCovidDTO(filteredDtoList);
        }

        return new ResponseEntity<CovidResponse>(covidResponse, HttpStatus.OK);
    }
}
