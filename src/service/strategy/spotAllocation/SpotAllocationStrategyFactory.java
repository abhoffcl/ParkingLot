package service.strategy.spotAllocation;

import model.SpotAllocationStrategyName;

public class SpotAllocationStrategyFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy(SpotAllocationStrategyName spotAllocationStrategyName){
        return switch(spotAllocationStrategyName){
            case RANDOM_SPOT_ALLOCATION_STRATEGY -> new RandomSpotAllocationStrategy();
            case FCFS_SPOT_ALLOCATION_STRATEGY ->  new FCFSSpotAllocationStrategy();

        };

    }
}
