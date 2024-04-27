package com.academydevgus.hostingplataform.repository;

import com.academydevgus.hostingplataform.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
