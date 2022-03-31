package org.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model to Covid entity.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CovidDTO implements Serializable {

    private static final long serialVersionUID = 3792250412274247695L;

    private Long id;

    private Integer infected;

    private Integer activeInfected;

    private Integer deceased;

    private Integer recovered;

    private Integer quarantined;

    private Integer tested;

    private String sourceUrl;

    private LocalDateTime lastUpdatedAtApify;

    private LocalDateTime lastUpdatedAtSource;

    private String readMe;

}
