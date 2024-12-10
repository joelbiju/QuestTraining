package com.quest.case_study.service_centre_management;

import java.util.Set;

public class ServiceCentre<T extends Vehicle> {

    private Set<T> servicedVehicles;

    public void addServicedVehicle(T vehicle){
        servicedVehicles.add(vehicle);
    }

    public Set<T> getServicedVehicles(){
        return servicedVehicles;
    }
}
