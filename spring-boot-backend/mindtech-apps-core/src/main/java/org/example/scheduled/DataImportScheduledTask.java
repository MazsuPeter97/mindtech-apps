package org.example.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.dto.CovidDTO;
import org.example.dto.ScheduledTaskDTO;
import org.example.mapper.CovidMapper;
import org.example.service.covid.CovidService;
import org.example.service.scheduled.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Data import scheduled class for external API.
 */
@Profile("!integration-test")
@Component
public class DataImportScheduledTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataImportScheduledTask.class);

    @Value("${apify.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CovidService covidService;

    @Autowired
    private ScheduledService scheduledService;

    /**
     * Scheduled run every 10 minute.
     *
     * @throws JsonProcessingException
     */
    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "* */10 * * * *")
    public void importDataFromApi() throws JsonProcessingException {

        LOGGER.info("Scheduled starting....");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("format", "json")
                .queryParam("clean", "1");

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity(), String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<CovidDTO> covidDTOs = objectMapper.readValue(response.getBody(), objectMapper.getTypeFactory().constructCollectionType(List.class, CovidDTO.class));

        insertIfNeeded(covidDTOs);

        LOGGER.info("Scheduled ended!");
    }

    /**
     * Return http entity header.
     *
     * @return
     */
    private HttpEntity httpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        return new HttpEntity(headers);
    }

    /**
     * Insert data from list if needed.
     *
     * @param covidDTOList
     */
    private void insertIfNeeded(List<CovidDTO> covidDTOList) {

        LocalDateTime lastScheduledDateTime = scheduledService.getLastScheduledRun(ScheduledType.DATA_IMPORT);

        if (lastScheduledDateTime != null) {
            covidDTOList = covidDTOList.stream().filter(covidDTO -> lastScheduledDateTime.isBefore(covidDTO.getLastUpdatedAtApify())).collect(Collectors.toList());
        }

        if (!CollectionUtils.isEmpty(covidDTOList)) {
            covidService.saveCovidList(CovidMapper.INSTANCE.covidDtoListToCovidList(covidDTOList));

            ScheduledTaskDTO scheduledTaskDTO = new ScheduledTaskDTO();

            scheduledTaskDTO.setLastRun(LocalDateTime.now());
            scheduledTaskDTO.setType(ScheduledType.DATA_IMPORT);

            scheduledService.save(scheduledTaskDTO);

            LOGGER.info("Inserted data...");
        }
    }
}
