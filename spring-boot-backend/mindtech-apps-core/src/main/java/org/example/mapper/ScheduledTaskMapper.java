package org.example.mapper;

import org.example.dto.ScheduledTaskDTO;
import org.example.entity.ScheduledTask;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduledTaskMapper {

    ScheduledTaskMapper INSTANCE = Mappers.getMapper(ScheduledTaskMapper.class);

    ScheduledTask scheduledTaskDtoToScheduledTask(ScheduledTaskDTO scheduledTaskDTO);

}
