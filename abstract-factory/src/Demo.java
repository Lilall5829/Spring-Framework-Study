import app.Application;
import factories.BlackFactory;
import factories.RedFactory;
import factories.VehicleFactory;
import java.util.Scanner;

public class Demo {
    private static Application configureApplication(){
        Application app;
        VehicleFactory factory;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the color you want");
        String color = input.nextLine().toLowerCase();
        if(color == "red"){
            factory = new RedFactory();
        }else{
            factory = new BlackFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.order();
    }
}
