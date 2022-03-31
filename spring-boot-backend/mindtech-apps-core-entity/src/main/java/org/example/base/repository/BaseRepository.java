package org.example.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Base entity repository.
 *
 * @param <T>
 * @param <D>
 */
@NoRepositoryBean
public interface BaseRepository<T, D extends Serializable> extends JpaRepository<T, D> {
}
