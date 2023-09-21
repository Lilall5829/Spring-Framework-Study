package factories;

import cars.Car;
import cars.BlackCar;
import trucks.BlackTruck;
import trucks.Truck;

public class BlackFactory implements VehicleFactory{
    @Override
    public Car createCar() {
        return new BlackCar();
    }

    @Override
    public Truck createTruck() {
        return new BlackTruck();
    }
}
