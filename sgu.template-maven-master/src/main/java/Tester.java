import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		
		Sensor sensor = new Sensor();
		sensor.addSensor(new Wind());
		sensor.addSensor(new Thermo());
		sensor.addSensor(new Clock());
		
		sensor.run();
		
	}

}
