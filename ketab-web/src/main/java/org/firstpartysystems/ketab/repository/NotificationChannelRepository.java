package org.firstpartysystems.ketab.repository;

import java.util.List;

import org.firstpartysystems.ketab.domain.NotificationChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationChannelRepository extends JpaRepository<NotificationChannel, Byte>{
	List<NotificationChannel> findByIsActive(Boolean isActive);
}
