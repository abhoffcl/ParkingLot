import controller.BillController;
import controller.InitController;
import controller.TicketController;
import exceptions.InvalidInputException;
import model.*;
import model.status.BillStatus;
import model.status.PaymentStatus;
import repository.*;
import service.strategy.BillService;
import service.strategy.InitializationService;
import service.strategy.TicketService;
import service.strategy.billCalculation.BillCalculationStrategy;
import service.strategy.billCalculation.BillCalculationStrategyFactory;
import service.strategy.spotAllocation.SpotAllocationStrategy;
import service.strategy.spotAllocation.SpotAllocationStrategyFactory;

import java.util.Scanner;

public class ParkingLotMain {
   public static void main(String[] args) {
      ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
      ParkingFloorRepository parkingFloorRepository =new ParkingFloorRepository();
      ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
      GateRepository gateRepository = new GateRepository();
      TicketRepository ticketRepository = new TicketRepository();
      BillRepository billRepository = new BillRepository();
      InitializationService initializationService = new InitializationService
              (parkingLotRepository,parkingFloorRepository,parkingSpotRepository,gateRepository);
      InitController initController = new InitController(initializationService);
      SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory.getSpotAllocationStrategy(SpotAllocationStrategyName.RANDOM_SPOT_ALLOCATION_STRATEGY);
      BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculatorStrategy(BillCalculationStrategyName.FLAT_RATE);
      TicketService ticketService = new TicketService(ticketRepository,billRepository,parkingLotRepository,gateRepository,spotAllocationStrategy);
      BillService billService = new BillService(ticketRepository,billRepository,billCalculationStrategy,gateRepository);
      TicketController ticketController= new TicketController(ticketService);
      BillController billController =new BillController(billService);


      ParkingLot parkingLot = initController.initParkingLot();
      System.out.println("Welcome to "+parkingLot.getName());
      Scanner sc = new Scanner(System.in);

      while(true){
         System.out.println("Press 1 to enter ,press 2 to exit parking lot ,press 3 to quit");
         int ch=sc.nextInt();
         if(ch==1){
            System.out.println("Enter the parking lot id");
            int parkinLotId=sc.nextInt();
            System.out.println("Enter the gate id");
            int entryGateId = sc.nextInt();
            if(gateRepository.getGate(entryGateId).getGateType()!=GateType.ENTRY)
               throw new InvalidInputException("You cannot enter from an Exit gate.Enter valid Entry gate id");

            System.out.println("Now enter your vehicle details");
            System.out.println("Enter vehicle type.Press 1:4_wheeler,2:2_wheeler");
            int vehicleTypeCh = sc.nextInt();
            VehicleType vehicleType;
            if(vehicleTypeCh==1)
               vehicleType=VehicleType.FOUR_WHEELER;
            else if(vehicleTypeCh==2)
               vehicleType=VehicleType.TWO_WHEELER;
            else
               throw new InvalidInputException("Enter vehicle type correctly");

            System.out.println("Enter the vehicle number");
            String vehicleNumber=sc.next();
            System.out.println("Enter vehicle color");
            String color= sc.next();
            Vehicle vehice = new Vehicle();
            vehice.setColor(color);
            vehice.setVehicleType(vehicleType);
            vehice.setVehicleNumber(vehicleNumber);
            // generate ticket
            Ticket ticket = ticketController.createTicket(vehice,parkinLotId,entryGateId);
            System.out.println("Ticket details: "+ ticket);

         }
         else if(ch==2){
            //generate billc
            System.out.println("Enter the ticket id for bill ");
            int ticketId=sc.nextInt();
            System.out.println("Enter the exit gate id");
            int exitGateId=sc.nextInt();
            if(gateRepository.getGate(exitGateId).getGateType()!=GateType.EXIT)
               throw new InvalidInputException("You cannot exit from an Entry gate.Enter valid Exit gate id");
            System.out.println("Select the payment mode,press 1:cash,2:card, 3:UPI");
            int paymentModeCh=sc.nextInt();
            PaymentMode paymentMode;
            if(paymentModeCh==1)
               paymentMode=PaymentMode.CASH;
            else if(paymentModeCh==2)
               paymentMode=PaymentMode.CARD;
            else if(paymentModeCh==3)
               paymentMode=PaymentMode.UPI;
            else
               throw new InvalidInputException("Enter payment mode correctly");
            Bill bill = billController.createBill(ticketId,exitGateId);
            bill.setBillStatus(BillStatus.PAID);
            System.out.println("Bill details "+bill);

         }
         else if(ch==3) {
            System.out.println("Bye!");
            break;
         }
         else
            throw new InvalidInputException("Enter correct input :1/2/3");

      }



   }
}