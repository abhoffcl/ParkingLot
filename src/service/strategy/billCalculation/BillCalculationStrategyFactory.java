package service.strategy.billCalculation;

import model.BillCalculationStrategyName;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculatorStrategy(BillCalculationStrategyName billCalculationStrategyName){
        return switch (billCalculationStrategyName){
            case FLAT_RATE -> new FlatRateBillCalculationStrategy();
            case HOURLY_RATE -> new HourlyRateBillCalculationStrategy();
            case SURGE -> new SurgeBillCalculationStrategy();
        };
    }
}
