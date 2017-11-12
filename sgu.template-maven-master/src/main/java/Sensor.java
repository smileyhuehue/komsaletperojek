import java.util.ArrayList;

public class Sensor {
	private BlindController blindController = new BlindController();
	private AirConditionController airConditionController = new AirConditionController();
	private ArrayList<InterfaceSensor> interfaceSensor = new ArrayList<InterfaceSensor>();
	private GUI gui;
	
	public Sensor(GUI gui) {
		this.gui=gui;
	}

	public void addSensor(InterfaceSensor sensor){
		interfaceSensor.add(sensor);
	}
	
	public void run(){
//		print("wind:"+String.valueOf(interfaceSensor.get(0).getTemp())); //wind
//		print("thermo:"+String.valueOf(interfaceSensor.get(1).getTemp())); //thermo
//		print("thermo:"+String.valueOf(interfaceSensor.get(1).getBlind()));//thermo
//		print("clock:"+String.valueOf(interfaceSensor.get(2).getTemp()));//clock
//		print("clock:"+String.valueOf(interfaceSensor.get(2).getBlind()));//clock
		
		blindController.setInterfaceSensor(interfaceSensor);
		airConditionController.setInterfaceSensor(interfaceSensor);
		
		blindController.update(gui);
		airConditionController.update(gui);
	}
	
	public void print(String text){
		//System.out.println(text);
	}
}
