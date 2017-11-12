import java.util.ArrayList;

public class BlindController implements Actor {

	private ArrayList<InterfaceSensor> interfaceSensor;

	public BlindController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setInterfaceSensor(ArrayList<InterfaceSensor> interfaceSensor) {
		this.interfaceSensor = interfaceSensor;
	}

	@Override
	public void setTemperature(double temp) {
		// EMPTY
		// DO NOT WRITE ANYTHING HERE

	}

	@Override
	public void setBlind(boolean onOrOff) {
		System.out.println("Blind : "+ onOrOff);
	}

	@Override
	public void update() {
		boolean onOrOff = false;
		System.out.println("========");
		System.out.println("BLIND");
		System.out.println("thermo:"+String.valueOf(interfaceSensor.get(1).getTempGUI())); //thermo
		System.out.println("clock:"+String.valueOf(interfaceSensor.get(2).getTimeGUI()));//clock
		System.out.println("========");
		setBlind(onOrOff);

	}

}
