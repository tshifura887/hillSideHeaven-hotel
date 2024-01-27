package com.dailycodework.hillsideheavenhotel.repository;

import com.dailycodework.hillsideheavenhotel.model.BookedRoom;
import com.dailycodework.hillsideheavenhotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Talifhani Tshifura
 */
public interface BookingRepository extends JpaRepository<BookedRoom, Long> {
  BookedRoom findByBookingConfirmationCode(String confirmationCode);
  List<BookedRoom> findByRoomId(Long roomId);
}
