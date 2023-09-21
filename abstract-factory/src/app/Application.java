package app;

import cars.Car;
import factories.VehicleFactory;
import trucks.Truck;

public class Application {
    private Car car;
    private Truck truck;
    public Application(VehicleFactory factory){
        car = factory.createCar();
        truck = factory.createTruck();
    }
    public void order(){
        car.order();
        truck.order();
    }
}
