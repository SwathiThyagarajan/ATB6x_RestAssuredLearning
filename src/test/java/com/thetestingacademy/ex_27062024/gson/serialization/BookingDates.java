package com.thetestingacademy.ex_27062024.gson.serialization;

public class BookingDates {

/*
     In IntelliJ IDEA, you can easily navigate to the definition of a class from a variable declaration.
      Here are the steps - to do so:
Place the Cursor: Place your cursor on the type name (BookingDates in your example).
Use Keyboard Shortcut:
Press Ctrl + B
Alternatively, you can use Ctrl + Click (Windows/Linux) on the type name to achieve the same result.
Simply hold down the Ctrl key (or Cmd on Mac) and click on BookingDates.
*/
    // In BookingDates class we have - checkin and checkout

    String checkin;
    String checkout;

    // Generate getter and setter

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
}
