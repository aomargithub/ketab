package org.firstpartysystems.ketab.admin.repository;

import java.util.List;

import org.firstpartysystems.ketab.admin.domain.ConfidentialityDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfidentialityDegreeRepository extends JpaRepository<ConfidentialityDegree, Byte>{
	List<ConfidentialityDegree> findByIsActive(Boolean isActive);
}
