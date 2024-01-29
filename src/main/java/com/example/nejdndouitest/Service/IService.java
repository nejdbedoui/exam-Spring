package com.example.nejdndouitest.Service;

import com.example.nejdndouitest.Models.Type;
import com.example.nejdndouitest.Models.Vehicle;
import com.example.nejdndouitest.Models.Washing_Service;
import com.example.nejdndouitest.Models.Worker;

import java.util.List;
import java.util.Map;

public interface IService {
    Worker addWorker(Worker worker);
    void addWashingService(List<Washing_Service> washing_services);
    Vehicle addVehicleReservationAndAffectToWashingservice(Vehicle vehicle, List<Long> idService);
    Worker affectWorkertoReservation(String nic, List<Long> idReservation);
    Float calculateTotalncomePerWorker(String name, Type typeService);
    void getReservation();
    Map<String,Long> getListServiceAndNbreservation();
}
