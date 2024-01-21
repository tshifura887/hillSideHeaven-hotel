package com.dailycodework.hillsideheavenhotel.service;

import com.dailycodework.hillsideheavenhotel.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * @author Talifhani Tshifura
 */
public interface IRoomService {
  Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws SQLException, IOException;
}
