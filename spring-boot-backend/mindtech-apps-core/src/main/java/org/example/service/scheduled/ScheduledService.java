package org.example.service.scheduled;

import org.example.dto.ScheduledTaskDTO;
import org.example.entity.ScheduledTask;
import org.example.scheduled.ScheduledType;

import java.time.LocalDateTime;

/**
 * ScheduledService interface.
 */
public interface ScheduledService {

    /**
     * Get last scheduled task time by type.
     *
     * @param type
     * @return
     */
    public LocalDateTime getLastScheduledRun(ScheduledType type);

    /**
     * Save scheduled task.
     *
     * @param scheduledTaskDTO
     */
    public void save(ScheduledTaskDTO scheduledTaskDTO);
}
