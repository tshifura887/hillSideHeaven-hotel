package com.dailycodework.hillsideheavenhotel.repository;

import com.dailycodework.hillsideheavenhotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Talifhani Tshifura
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

  @Query("SELECT DISTINCT r.roomType FROM Room r")
  List<String> findDistinctRoomTypes();
}
