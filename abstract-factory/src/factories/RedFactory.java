package factories;

import cars.Car;
import cars.RedCar;
import trucks.RedTruck;
import trucks.Truck;

public class RedFactory implements VehicleFactory{
    @Override
    public Car createCar() {
        return new RedCar();
    }

    @Override
    public Truck createTruck() {
        return new RedTruck();
    }
}
