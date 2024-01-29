package com.example.nejdndouitest.Controller;

import com.example.nejdndouitest.Models.Type;
import com.example.nejdndouitest.Models.Vehicle;
import com.example.nejdndouitest.Models.Washing_Service;
import com.example.nejdndouitest.Models.Worker;
import com.example.nejdndouitest.Service.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/controllers")
public class ControllerApis {
    private final IService iService;

    @PostMapping("addWorker")
    public Worker addWorker(@RequestBody Worker worker){
        return iService.addWorker(worker);
    }

    @PostMapping("addWashingService")
    public void addWashingService(@RequestBody List<Washing_Service> washingservices){
         iService.addWashingService(washingservices);
    }

    @PostMapping("addVehicleReservationAndAffectToWashingservice")
    public Vehicle addVehicleReservationAndAffectToWashingservice(@RequestBody Vehicle vehicle,@RequestParam List<Long> idService){
        return iService.addVehicleReservationAndAffectToWashingservice(vehicle,idService);
    }

    @PostMapping("affectWorkertoReservation/{nic}")
    public Worker affectWorkertoReservation(@PathVariable String nic,@RequestBody List<Long> idReservation){
        return iService.affectWorkertoReservation(nic,idReservation);
    }

    @GetMapping("calculateTotalncomePerWorker/{name}/{type}")
    public Float calculateTotalncomePerWorker(@PathVariable String name, @PathVariable Type type){
        return iService.calculateTotalncomePerWorker(name,type);
    }

    @GetMapping("getListServiceAndNbreservation")
    public Map<String, Long> getListServiceAndNbreservation() {
        return iService.getListServiceAndNbreservation();
    }



    }
