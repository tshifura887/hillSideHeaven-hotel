package com.dailycodework.hillsideheavenhotel.service;

import com.dailycodework.hillsideheavenhotel.exception.InvalidBookingRequestException;
import com.dailycodework.hillsideheavenhotel.model.BookedRoom;
import com.dailycodework.hillsideheavenhotel.model.Room;
import com.dailycodework.hillsideheavenhotel.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Talifhani Tshifura
 */
@Service
public class BookingService implements IBookingService {
  private final BookingRepository bookingRepository;
  private final IRoomService roomService;

  public BookingService(BookingRepository bookingRepository, IRoomService roomService) {
    this.bookingRepository = bookingRepository;
    this.roomService = roomService;
  }

  public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
    return bookingRepository.findByRoomId(roomId);
  }

  @Override
  public void cancelBooking(Long bookingId) {
    bookingRepository.deleteById(bookingId);
  }

  @Override
  public String saveBooking(Long roomId, BookedRoom bookingRequest) {
    if (bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())){
      throw new InvalidBookingRequestException("Check-in date must come before checkout");
    }
    Room room = roomService.getRoomById(roomId).get();
    List<BookedRoom> existing_bookings = room.getBookings();
    boolean roomIsAvailable = roomIsAvailable(bookingRequest, existing_bookings);
    if(roomIsAvailable){
      room.addBooking(bookingRequest);
      bookingRepository.save(bookingRequest);
    }else {
      throw new InvalidBookingRequestException("Sorry this room has been booked for the selected date");
    }

    return bookingRequest.getBookingConfirmationCode();

  }

  private boolean roomIsAvailable(BookedRoom bookingRequest, List<BookedRoom> existingBookings) {
    return existingBookings.stream()
      .noneMatch(existingBooking ->
        bookingRequest.getCheckInDate().equals(existingBooking.getCheckInDate())
          || bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckOutDate())
          || (bookingRequest.getCheckInDate().isAfter(existingBooking.getCheckInDate())
          && bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckOutDate()))
          || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

          && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate()))
          || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

          && bookingRequest.getCheckOutDate().isAfter(existingBooking.getCheckOutDate()))

          || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
          && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckInDate()))

          || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
          && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate()))

        );
  }

  @Override
  public BookedRoom findByBookingConfirmationCode(String confirmationCode) {
    return bookingRepository.findByBookingConfirmationCode(confirmationCode);
  }

  @Override
  public List<BookedRoom> getAllBookings() {
    return bookingRepository.findAll();
  }
}
