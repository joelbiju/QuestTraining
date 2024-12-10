package com.quest.case_study.service_centre_management;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ServiceOperations {

    Predicate<ServiceBooking> isWithinSevenDays = s-> {
        return s.getServiceDate().isBefore(LocalDateTime.now().plusDays(7));
    };

    Consumer<Customer> getInvoice = c -> {
        CustomerBookingsMap bookingsMap = new CustomerBookingsMap();
        System.out.println(bookingsMap.getBookings(c).toString());
    };

    Function<Customer, Double> applyDiscount = c ->{
      CustomerBookingsMap bookingsMap = new CustomerBookingsMap();
      double totalCost = bookingsMap.getBookings(c).stream().mapToDouble(ServiceBooking::getCost).sum();
      return bookingsMap.getBookings(c).size() > 3 ? totalCost*0.85 : totalCost;
    };
}
