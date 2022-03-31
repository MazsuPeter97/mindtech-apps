package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.ScheduledTask;
import org.example.scheduled.ScheduledType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Scheduled task repository.
 */
@Repository
public interface ScheduledTaskRepository extends BaseRepository<ScheduledTask, Long> {

    @Query(value = "select st1 from ScheduledTask st1 where st1.lastRun = (select max(st.lastRun) from ScheduledTask st where st.type = :type) and st1.type = :type")
    public ScheduledTask findFirstByTypeAndOrderByLastRunDesc(@Param("type") ScheduledType type);
}
