package controller;

import model.ParkingLot;
import service.strategy.InitializationService;

public class InitController {
    private InitializationService initializationService;

    public InitController(InitializationService initializationService) {
        this.initializationService = initializationService;
    }
    public ParkingLot initParkingLot(){
        return initializationService.init();
    }
}
