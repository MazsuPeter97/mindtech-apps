package org.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.scheduled.ScheduledType;

import java.time.LocalDateTime;

/**
 * Model to ScheduledTask entity.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScheduledTaskDTO {

    private Long id;

    private ScheduledType type;

    private LocalDateTime lastRun;
}
