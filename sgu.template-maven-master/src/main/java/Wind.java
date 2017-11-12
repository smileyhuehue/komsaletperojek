
public class Wind implements InterfaceSensor {

	private double windSpeedGUI;
	
	@Override
	public double getWindGUI() {
		windSpeedGUI = 40;
		return windSpeedGUI;
	}
	@Override
	public double getTempGUI() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTimeGUI() {
		// TODO Auto-generated method stub
		return 0;
	}

}
