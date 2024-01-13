package com.dailycodework.hillsideheavenhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Lazy;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_In")
    private LocalDate checkInDate;

    @Column(name = "check_Out")
    private LocalDate checkOutDate;

    @Column(name = "guest_FullName")
    private String guestFullName;

    @Column(name = "guest_Email")
    private String guestEmail;

    @Column(name = "adults")
    private int NumberOfAdults;

    @Column(name = "children")
    private int NumberOfChildren;

    @Column(name = "total_Guests")
    private int totalNumberOfGuests;

    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode;


    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "room_Id")
    private Room room;







    public void calculateTotalNumberOfGuests(){
        this.totalNumberOfGuests = this.NumberOfAdults + this.NumberOfChildren;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        NumberOfAdults = numberOfAdults;
        calculateTotalNumberOfGuests();
    }

    public void setNumberOfChildren(int numberOfChildren) {
        NumberOfChildren = numberOfChildren;
        calculateTotalNumberOfGuests();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}