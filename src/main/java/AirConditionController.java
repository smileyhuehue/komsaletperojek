import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class AirConditionController implements Actor{//implements observer to observe changes in GUI

	private ArrayList<InterfaceSensor> interfaceSensor;
	GUI gui;//added supaya controller bisa konek ke GUI
	double temp=0;
	
	public AirConditionController(GUI gui) {
		// TODO Auto-generated constructor stub
		this.gui=gui;//added supaya controller bisa konek ke GUI
	}

	@Override
	public void setInterfaceSensor(ArrayList<InterfaceSensor> interfaceSensor) {
		this.interfaceSensor = interfaceSensor;
	}

	@Override
	public void setTemperature(double temp) {
	//	System.out.println("Temperature : "+ temp);
//		interfaceSensor.get(1);
		gui.setTemp(temp);
	}

	@Override
	public void setBlind(boolean onOrOff) {
		// EMPTY
		// DO NOT WRITE ANYTHING HERE
	}

	@Override
	public void update() {
			    
	    Object object = interfaceSensor.get(0).getValue();
	    double windGUI = ((Double)object).doubleValue();
	    //System.out.println("WIND:"+windGUI);
		
	    object = interfaceSensor.get(1).getValue();
	    double tempGUI = ((Double)object).doubleValue();
	   // System.out.println("TEMP"+tempGUI);
	    
	    object = interfaceSensor.get(2).getValue();
	    int timeGUI = ((Integer)object).intValue();
	    //System.out.println(timeGUI);
	    
	    if(timeGUI>=2100 && timeGUI<=600){
	    	temp= 27;
	    }
	    else{
	    	if(tempGUI>=34){
	    		temp = 27;
	    	}
	    	else{
	    		temp=-1;
	    	}
	    }
	    
	    if(tempGUI<=24){
	    	temp=-1;
	    }
	    else if(tempGUI==32 && windGUI>30){
	    	temp=27;
	    }
	    
	    double saving=0;
	    saving = 100 - (Math.abs((27-tempGUI)/(35-tempGUI)*100));
	    System.out.println("energy saving :"+saving);
	    gui.setEnergy(saving);
		setTemperature(temp);

	}

}
