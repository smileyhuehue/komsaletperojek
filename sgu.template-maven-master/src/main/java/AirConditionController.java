import java.util.ArrayList;

public class AirConditionController implements Actor {

	private ArrayList<InterfaceSensor> interfaceSensor;

	public AirConditionController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setInterfaceSensor(ArrayList<InterfaceSensor> interfaceSensor) {
		this.interfaceSensor = interfaceSensor;
	}

	@Override
	public void setTemperature(double temp) {
		System.out.println("Temperature : "+ temp);
	}

	@Override
	public void setBlind(boolean onOrOff) {
		// EMPTY
		// DO NOT WRITE ANYTHING HERE
	}

	@Override
	public void update(GUI gui) {
		double temp = 0;
		System.out.println("========");
		System.out.println("AirCondition");
		System.out.println("wind:"+String.valueOf(interfaceSensor.get(0).getWindGUI())); //wind
		System.out.println("thermo:"+String.valueOf(interfaceSensor.get(1).getTempGUI())); //thermo
		System.out.println("clock:"+String.valueOf(interfaceSensor.get(2).getTimeGUI()));//clock
		System.out.println("========");
		setTemperature(temp);
		System.out.println("counter :"+gui.getCount());

	}

}
