package com.rouchdane.car;

import com.rouchdane.person.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarBooking {

    private UUID bookingRef;

    private User user;

    private CarBuild carBuild;

    private LocalDateTime bookingTime;

    private boolean isCanceled;

    {
        this.isCanceled = false;
    }

    public CarBooking(UUID bookingRef, User user, CarBuild carBuild, LocalDateTime bookingTime) {
        this.bookingRef = bookingRef;
        this.user = user;
        this.carBuild = carBuild;
        this.bookingTime = bookingTime;

    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "bookingRef=" + bookingRef +
                ",user=" + user +
                ",carBuild=" + carBuild +
                ",bookingTime=" + bookingTime +
                ",isCanceled=" + isCanceled +
                '}';
    }
}
