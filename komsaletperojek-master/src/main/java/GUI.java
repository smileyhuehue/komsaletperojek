import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.DecimalFormat;
import java.util.Optional;

public class GUI extends Application
{
	private static boolean OnOff,toggleEnergySvg;
    private static double temp,windSpeed;
    private static int time;
    private static double temp2,energySvg;
    
	public void showGUI() 
	{
		Application.launch();
	}
	
	@Override
	public void start(Stage stage) 
	{
		// Create the Label for the Name
		Label nameLbl = new Label("16°C");
		// Set the position of the Label
		nameLbl.relocate(10, 10);
		// Create the Label for the Name
		Label ACLabel= new Label("Temperature");
		// Set the position of the Label
		ACLabel.relocate(200, 10);
		// Create the TextField for the Name
		Slider tempSlider = new Slider();
		tempSlider.setMin(16);
		tempSlider.setMax(37);
//		tempSlider.setValue(0);
		tempSlider.setShowTickLabels(true);
		tempSlider.setShowTickMarks(true);
		tempSlider.setMajorTickUnit(21);
		tempSlider.setMinorTickCount(1);
		tempSlider.setBlockIncrement(1);
		// Set the position of the TextField
		tempSlider.relocate(200, 30);
		// Create the Label for the Password
		ToggleButton toggleButton = new ToggleButton("On/Off \n Power Saving");
//		toggleButton.setTextAlignment(Pos.CWNTW);
		// Set the position of the Label
		toggleButton.relocate(10, 50);
		Label anmLabel = new Label("Anemometer");
		anmLabel.relocate(200, 80);
		// Create the TextField for the Password
		Slider anmSlider = new Slider();
		anmSlider.setMin(0);
		anmSlider.setMax(80);
//		tempSlider.setValue(0);
		anmSlider.setShowTickLabels(true);
		anmSlider.setShowTickMarks(true);
		anmSlider.setMajorTickUnit(80);
		anmSlider.setMinorTickCount(1);
		anmSlider.setBlockIncrement(1);
		// Set the position of the TextField
		anmSlider.relocate(200, 100);
		// Create the Login Button
		
		Label gordynLbl = new Label("Gordyn");
		gordynLbl.relocate(10, 120);
		
		Label gordynOnOff = new Label("Off");
		gordynOnOff.relocate(10, 135);
		
		Label energySavingLbl = new Label("Energy Saving : OFF");
		energySavingLbl.relocate(10, 170);
		
		TextField clockInput = new TextField();
		clockInput.relocate(200, 150);

		//listeners
		tempSlider.valueProperty().addListener(new ChangeListener() {
			
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				if(temp2!=-1){
					nameLbl.textProperty().setValue(
							String.valueOf((int) tempSlider.getValue()+"°C"));
				}else{
					nameLbl.textProperty().setValue("AC OFF");;
				}
				temp = tempSlider.getValue();
				if(OnOff){
					gordynOnOff.setText("ON");
				}else{
					gordynOnOff.setText("OFF");
				}
				energySavingLbl.setText(energySvg+"%");
				
			}
		});
		
		anmSlider.valueProperty().addListener(new ChangeListener() {
			
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				 if(temp2!=-1){
			    	  nameLbl.setText(temp2+"°C");
			      }
			      else{
			    	  nameLbl.setText("AC OFF");
			      }
			      windSpeed = anmSlider.getValue();
				
			}
		});
		
		clockInput.setOnKeyReleased(new EventHandler<KeyEvent>() {
	          public void handle(KeyEvent ke) {
	        	  try {
	                  long number = Long.parseLong(clockInput.getText());
	              } catch (Exception e) {
	            	  Alert alert = new Alert(Alert.AlertType.WARNING);
	                  alert.initStyle(StageStyle.UTILITY);
	                  alert.setTitle("Input only numbers pls");
	                  alert.setHeaderText("Error");
	                  alert.setContentText("Input only numbers pls");

	                  alert.showAndWait();
	                  clockInput.setText("");
	              }
	          }
		});
		clockInput.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				time = Integer.parseInt(clockInput.getText());
				char[] timeDot = (time+"-").toCharArray();
				timeDot[4] = timeDot[3];
				timeDot[3] = timeDot[2];
				timeDot[2] = ':';
				String finalTime = String.valueOf(timeDot);
				clockInput.setText(finalTime);
				if(OnOff){
					gordynOnOff.setText("ON");
				}else{
					gordynOnOff.setText("OFF");
				}
			}
		});
		toggleButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(toggleButton.isSelected()){
					 System.out.println("selected");
					 toggleEnergySvg=true;
					 nameLbl.setText(temp+"°C");
					 System.out.println(energySvg);
					 energySavingLbl.setText(energySvg+"%");
				 }else{
					 System.out.println("not selected");
					 toggleEnergySvg=false;
				 }
			   }
		});
		// Create the Pane
		Pane root = new Pane();
		
		// Set the background-color of the Pane
		root.setStyle("-fx-background-color: blue, lightgray;");
		// Set the background-insets of the Pane
		root.setStyle("-fx-background-insets: 0, 4;");
		// Set the background-radius of the Pane
		root.setStyle("-fx-background-radius: 4, 2;");		
		
		// Set the size of the Pane
		root.setPrefSize(500, 500);
		// Add the children to the Pane
		root.getChildren().addAll(nameLbl, ACLabel,tempSlider, toggleButton,anmLabel,anmSlider,gordynLbl,gordynOnOff
									,energySavingLbl,clockInput);
		
		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A Pane Example");
		// Display the Stage
		stage.show();
	}
   
    public boolean getOnOff(){
    	return OnOff;
    }
    
    public void setOnOff(boolean OnOff){
    	this.OnOff = OnOff;
//    	gordyn.setEnabled(OnOff);
    }
    
    public int getTime(){
    	return time;
    }
    
    public double getTemp(){
    	return temp;
    }
    
    public void setTemp(double temp2){
    	this.temp2 = temp2;
//    	System.out.println("GUI : "+temp2);
    }
    
    public double getWindSpeed(){
    	return windSpeed;
    }
    
    public void setEnergy(double energySvg){
    	DecimalFormat df = new DecimalFormat("#.00");
    	this.energySvg = Double.parseDouble(df.format(energySvg));
    }
    
    public boolean getEnergySavingMode(){
    	
		return toggleEnergySvg;
    }
 	    	
}
