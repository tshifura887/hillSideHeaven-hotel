package com.dailycodework.hillsideheavenhotel.exception;

/**
 * @author Talifhani Tshifura
 */
public class InvalidBookingRequestException extends RuntimeException {
  public InvalidBookingRequestException(String message) {
    super(message);
  }
}
