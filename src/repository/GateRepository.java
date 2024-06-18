package repository;

import exceptions.GateNotFoundException;
import model.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private static int idCounter=0;
    private Map<Integer, Gate> gatemap;

    public GateRepository() {
        this.gatemap = new HashMap<>();
    }

    public Gate getGate(int gateId){
        Gate gate = gatemap.get(gateId);
        if(gate==null)
            throw new GateNotFoundException("Gate not found for id "+gateId);
        return gate;
    }
    public void putGate(Gate Gate){
        Gate.setId(++idCounter);
        gatemap.put(Gate.getId(),Gate);

    }
}
