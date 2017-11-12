
public class Clock implements InterfaceSensor {

	private int timeGUI;

	@Override
	public int getTimeGUI() {
		timeGUI = 1700;
		return timeGUI;
	}
	@Override
	public double getWindGUI() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getTempGUI() {
		// TODO Auto-generated method stub
		return 0;
	}

}
