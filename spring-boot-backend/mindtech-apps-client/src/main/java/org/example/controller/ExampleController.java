package org.example.controller;


import org.example.response.CovidResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface for example controller.
 */
@RequestMapping(path = "/api/example")
public interface ExampleController {

    /**
     * Return filtered data by started date and ended date.
     *
     * @param firstDate
     * @param lastDate
     * @return
     */
    @GetMapping(path = "/filter/{firstDate}/{lastDate}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CovidResponse> filterByDate(@PathVariable String firstDate, @PathVariable String lastDate);

}
