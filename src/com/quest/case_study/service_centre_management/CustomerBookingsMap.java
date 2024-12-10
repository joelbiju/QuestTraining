package com.quest.case_study.service_centre_management;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerBookingsMap {

    private Map<Customer, List<ServiceBooking>> bookingMap = new HashMap<>();

    public void addBooking(Customer customer, ServiceBooking serviceBooking) throws InvalidBookingDateException{
        if (!bookingMap.containsKey(customer)) {
            if (serviceBooking.getServiceDate().isBefore(LocalDateTime.now())){
                throw new InvalidBookingDateException("Service date cannot be in past");
            }

            bookingMap.computeIfAbsent(customer, k -> new ArrayList<>()).add(serviceBooking);
            List<ServiceBooking> bookings = bookingMap.get(customer);

            if (bookings.contains(serviceBooking)) {
                throw new InvalidBookingDateException("Booking already exists");
            }
            bookings.add(serviceBooking);
        }
    }

    public List<ServiceBooking> getBookings(Customer customer) {
        return bookingMap.get(customer);
    }

    public Set<Customer> getAllCustomers(){
        return bookingMap.keySet();
    }

    public List<ServiceBooking> getAllServiceBookings(){
        return bookingMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }


}
