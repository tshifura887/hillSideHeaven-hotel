package com.dailycodework.hillsideheavenhotel.service;

import com.dailycodework.hillsideheavenhotel.model.BookedRoom;

import java.util.List;

/**
 * @author Talifhani Tshifura
 */
public interface IBookingService {

  void cancelBooking(Long bookingId);

  String saveBooking(Long roomId, BookedRoom bookingRequest);

  BookedRoom findByBookingConfirmationCode(String confirmationCode);

  List<BookedRoom> getAllBookings();
}
