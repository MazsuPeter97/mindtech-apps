package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Covid entity class.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "COVID")
public class Covid extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "INFECTED")
    private Integer infected;

    @Column(name = "ACTIVE_INFECTED")
    private Integer activeInfected;

    @Column(name = "DECEASED")
    private Integer deceased;

    @Column(name = "RECOVERED")
    private Integer recovered;

    @Column(name = "QUARANTINED")
    private Integer quarantined;

    @Column(name = "TESTED")
    private Integer tested;

    @Column(name = "SOURCE_URL")
    private String sourceUrl;

    @Column(name = "LAST_UPDATED_AT_APIFY")
    private LocalDateTime lastUpdatedAtApify;

    @Column(name = "LAST_UPDATED_AT_SOURCE")
    private LocalDateTime lastUpdatedAtSource;

    @Column(name = "READ_ME")
    private String readMe;
}
