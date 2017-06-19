package org.firstpartysystems.ketab.repository;

import java.util.List;

import org.firstpartysystems.ketab.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Byte>{
	List<Theme> findByIsActive(Boolean isActive);
}
