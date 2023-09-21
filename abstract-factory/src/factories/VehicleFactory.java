package factories;

import cars.Car;
import trucks.Truck;

public interface VehicleFactory {
    Car createCar();
    Truck createTruck();
}
