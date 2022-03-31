package org.example.service.scheduled;

import org.example.dto.ScheduledTaskDTO;
import org.example.entity.ScheduledTask;
import org.example.mapper.ScheduledTaskMapper;
import org.example.repository.ScheduledTaskRepository;
import org.example.scheduled.ScheduledType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ScheduledServiceImpl implements ScheduledService {

    @Autowired
    private ScheduledTaskRepository scheduledTaskRepository;

    @Override
    public LocalDateTime getLastScheduledRun(ScheduledType type) {

        ScheduledTask scheduled = scheduledTaskRepository.findFirstByTypeAndOrderByLastRunDesc(type);

        if (scheduled != null) {
            return scheduledTaskRepository.findFirstByTypeAndOrderByLastRunDesc(type).getLastRun();
        }
        return null;
    }

    @Override
    public void save(ScheduledTaskDTO scheduledTaskDTO) {
        scheduledTaskRepository.save(ScheduledTaskMapper.INSTANCE.scheduledTaskDtoToScheduledTask(scheduledTaskDTO));
    }
}
