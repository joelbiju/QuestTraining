package com.quest.case_study.service_centre_management;

import java.io.*;
import java.util.List;

public class ServiceDataSerialization {
    public static void serializeServiceData(CustomerBookingsMap customerBookingsMap){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ServiceData.ser"))){
            oos.writeObject(customerBookingsMap.getAllServiceBookings());
            System.out.println("Data serialised");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void deserializeServiceData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serviceData.ser"))) {
            List<ServiceBooking> serviceBookings = (List<ServiceBooking>) ois.readObject();
            serviceBookings.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
