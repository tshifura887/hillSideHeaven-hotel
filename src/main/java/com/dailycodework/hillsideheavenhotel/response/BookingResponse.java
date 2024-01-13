package com.dailycodework.hillsideheavenhotel.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Talifhani Tshifura
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponse {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private int NumberOfAdults;
    private int NumberOfChildren;
    private int totalNumberOfGuests;
    private String bookingConfirmationCode;
    private RoomResponse room;

    public BookingResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

}
