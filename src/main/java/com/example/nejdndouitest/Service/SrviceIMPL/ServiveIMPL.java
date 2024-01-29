package com.example.nejdndouitest.Service.SrviceIMPL;

import com.example.nejdndouitest.Models.*;
import com.example.nejdndouitest.Repo.ReservationRepository;
import com.example.nejdndouitest.Repo.VehicleRepository;
import com.example.nejdndouitest.Repo.Washing_ServiceRepository;
import com.example.nejdndouitest.Repo.WorkerRepository;
import com.example.nejdndouitest.Service.IService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.*;


@Slf4j
@RequiredArgsConstructor
@Service
public class ServiveIMPL implements IService {
    private final ReservationRepository reservationRepository;
    private final VehicleRepository vehicleRepository;
    private final Washing_ServiceRepository washingServiceRepository;
    private final WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public void addWashingService(List<Washing_Service> washing_services) {
        washingServiceRepository.saveAll(washing_services);
    }

    @Override
    public Vehicle addVehicleReservationAndAffectToWashingservice(Vehicle vehicle, List<Long> idService) {
        Reservation reservation = new Reservation();
        reservation.setStatus(Status.PENDING);
        reservation.setTimereservation(LocalDateTime.now().plusHours(2));
        reservation.setWashing_Services(new HashSet<>());
        reservation.getWashing_Services().addAll(washingServiceRepository.findAllById( idService));
        reservation=reservationRepository.save(reservation);
        vehicle.setReservations(new HashSet<>());
        vehicle.getReservations().add(reservation);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation) {
        Worker worker=workerRepository.findByNic(nic);
        if(worker.getReservations()==null){
            worker.setReservations(new HashSet<>());
        }
        for(Long i:idReservation){
            Reservation r=reservationRepository.findById(i).orElse(null);
            if(worker.getReservations().size()<5){
                r.setWorker(worker);
                r.setStatus(Status.CONFIRMED);
                reservationRepository.save(r);
            }
        }
        return workerRepository.save(worker);
    }

    @Override
    public Float calculateTotalncomePerWorker(String name, Type typeService) {
        List<Washing_Service> washing_services=washingServiceRepository.findByTypeAndReservations_StatusAndReservations_Worker_Name(typeService,Status.CONFIRMED,name);
        float result=0;
        for(Washing_Service w:washing_services){
            result+=w.getPrice();
        }
        return result;
    }

    @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void getReservation() {
        log.info(reservationRepository.findByStatusOrderByTimereservationDesc(Status.PENDING).toString());
    }

    @Override
    public Map<String, Long> getListServiceAndNbreservation() {
        Map<String,Long> r=new HashMap<>();
        r.put(Type.POLISHING.toString(), (long) washingServiceRepository.findByType(Type.POLISHING).size());
        r.put(Type.EXTERNAL_WASHING.toString(), (long) washingServiceRepository.findByType(Type.EXTERNAL_WASHING).size());
        r.put(Type.INTERNAL_WASHING.toString(), (long) washingServiceRepository.findByType(Type.INTERNAL_WASHING).size());
        return r;
    }
}
