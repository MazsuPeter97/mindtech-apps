package org.example.base.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Base entity class.
 */
@Data
public class BaseEntity {

    @Column(name = "CREATION_TIME")
    private LocalDateTime creationTime;

    @Column(name = "UPDATE_TIME")
    private LocalDateTime updateTime;

    @PrePersist
    public void prePersist() {
        creationTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateTime = LocalDateTime.now();
    }
}
