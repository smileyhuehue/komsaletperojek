import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		GUI gui = new GUI();
		
		Sensor sensor = new Sensor(gui);
		sensor.addSensor(new Wind());
		sensor.addSensor(new Thermo());
		sensor.addSensor(new Clock());
		
		while(true)
		sensor.run();
		
		
		
	}

}
