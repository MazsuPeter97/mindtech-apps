package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.entity.BaseEntity;
import org.example.scheduled.ScheduledType;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * ScheduledTask entity class.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "SCHEDULED_TASK")
public class ScheduledTask extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ScheduledType type;

    @Column(name = "LAST_RUN", nullable = false)
    private LocalDateTime lastRun;

}
