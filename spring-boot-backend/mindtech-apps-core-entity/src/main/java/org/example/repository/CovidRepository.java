package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Covid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Covid repository.
 */
@Repository
public interface CovidRepository extends BaseRepository<Covid, Long> {

    @Query("select c from Covid c where c.lastUpdatedAtApify between :firstDate and :lastDate")
    public List<Covid> findAllByDate(@Param("firstDate") LocalDateTime firstDate, @Param("lastDate") LocalDateTime lastDate);

}
