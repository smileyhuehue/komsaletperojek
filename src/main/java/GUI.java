/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



/*
 * GridBagLayoutDemo.java requires no other files.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI{
	private ArrayList<Observer> controllers = new ArrayList<Observer>();
	
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private static JTextField clockInput;
    private static JLabel textField;
    private static ChangeListener listener1,listener2,listener3;
    private static ActionListener listener4;
    private static JLabel gordyn,energy;
    private static boolean OnOff;
    private static double temp,windSpeed;
    private static int time;
    private static double temp2,energySvg;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
     // common listener for all sliders
	listener1 = new ChangeListener()
	{
	   public void stateChanged(ChangeEvent event)
	   {
	      // update text field when the slider value changes
	      JSlider source = (JSlider) event.getSource();
	     // textField.setText("" + source.getValue());
//	      System.out.println("inside : "+temp2);
	      if(temp2!=-1){
	    	  textField.setText(temp2+"");
	      }
	      else{
	    	  textField.setText("AC OFF");
	      }
	      temp = source.getValue();
	      if(OnOff){
				gordyn.setText("ON");
			}else{
				gordyn.setText("OFF");
			}
	      energy.setText(energySvg+"%");
	   }
	};

    JSlider slider;
	pane.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	if (shouldFill) {
	//natural height, maximum width
	c.fill = GridBagConstraints.HORIZONTAL;
	}
	  
	JLabel label = new JLabel("Temperature");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
	pane.add(label, c);
	
	
	// add a slider with numeric labels
	slider = new JSlider(16,37);
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	slider.setSnapToTicks(true);
	slider.setMajorTickSpacing(21);
	slider.setMinorTickSpacing(1);
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	addSlider(slider,"",pane,c,listener1);
	
	textField = new JLabel("0");
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth=1;
    c.gridheight=1;
    pane.add(textField,c);
    
 // add a slider with numeric labels
 	JSlider anemometer = new JSlider(0,80);
 	anemometer.setPaintTicks(true);
 	anemometer.setPaintLabels(true);
 	anemometer.setSnapToTicks(true);
 	anemometer.setMajorTickSpacing(80);
 	anemometer.setMinorTickSpacing(1);
 	c.weightx = 0.5;
 	c.gridx = 1;
 	c.gridy = 3;
 	listener2 = new ChangeListener()
	{
	   public void stateChanged(ChangeEvent event)
	   {
	      // update text field when the slider value changes
	      JSlider source = (JSlider) event.getSource();
	      if(temp2!=-1){
	    	  textField.setText(temp2+"");
	      }
	      else{
	    	  textField.setText("AC OFF");
	      }
	      windSpeed = source.getValue();
	   }
	};
 	addSlider(anemometer,"",pane,c,listener2);
 	
 	JLabel anemo = new JLabel("Anemometer");
     c.gridx = 1;
     c.gridy = 2;
     c.gridwidth=1;
     c.gridheight=1;
     pane.add(anemo,c);
     
     gordyn = new JLabel("OFF");
     c.gridx = 0;
     c.gridy = 2;
     c.gridwidth=1;
     c.gridheight=1;
     pane.add(gordyn,c);
     
//     listener3 = new ChangeListener()
//     {
//  	   public void stateChanged(ChangeEvent event)
//  	   {
//  		   JToggleButton tgl = (JToggleButton)event.getSource();
//  		 if(tgl.isSelected()){
//  			 System.out.println("selected");
//  			 OnOff=true;
//  		 }else{
//  			 System.out.println("not selected");
//  			 OnOff=false;
//  		 }
//  	   }
//  	};
//  	gordyn.addChangeListener(listener3);
  	
  	clockInput = new JTextField();
  	c.gridx = 1;
    c.gridy = 4;
    c.gridwidth=1;
    c.gridheight=1;
    pane.add(clockInput, c);
    
//    clockInput.addActionListener(new ActionListener() {
//      		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//      		time = Integer.parseInt(clockInput.getText());
//			char[] timeDot = (time+"-").toCharArray();
//			timeDot[4] = timeDot[3];
//			timeDot[3] = timeDot[2];
//			timeDot[2] = ':';
//			String finalTime = String.valueOf(timeDot);
//			clockInput.setText(finalTime);
//			if(OnOff){
//				gordyn.setText("ON");
//			}else{
//				gordyn.setText("OFF");
//			}
//		}
//    });
    clockInput.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	        	time = Integer.parseInt(clockInput.getText());
				char[] timeDot = (time+"-").toCharArray();
				timeDot[4] = timeDot[3];
				timeDot[3] = timeDot[2];
				timeDot[2] = ':';
				String finalTime = String.valueOf(timeDot);
				clockInput.setText(finalTime);
				if(OnOff){
					gordyn.setText("ON");
				}else{
					gordyn.setText("OFF");
				}
	        }
	    });
    
    energy = new JLabel("Energy Saving Off");
    c.gridx = 0;
    c.gridy = 3;
    c.gridwidth=1;
    c.gridheight=1;
    pane.add(energy, c);
    }
        
    public static void addSlider(JSlider s, String description,Container pane,GridBagConstraints c,ChangeListener listener)
    {
      s.addChangeListener(listener);
      pane.add(s,c);
    }
    
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void showGUI() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
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
 	    	
}