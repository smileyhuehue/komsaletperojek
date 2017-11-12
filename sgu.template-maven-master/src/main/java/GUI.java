import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;

public class GUI extends Frame implements ActionListener {
   private Label lblCount;    // Declare a Label component 
   private TextField tfCount; // Declare a TextField component 
   private Button btnCount;   // Declare a Button component
   private int count = 0;     // Counter's value
 
   // Constructor to setup GUI components and event handlers
   public GUI () {
      setLayout(new FlowLayout());
       
      lblCount = new Label("Counter");  // construct the Label component
      add(lblCount);                    // "super" Frame container adds Label component
 
      tfCount = new TextField("0", 10); // construct the TextField component
      tfCount.setEditable(false);       // set to read-only
      add(tfCount);                     // "super" Frame container adds TextField component
 
      btnCount = new Button("Count");   // construct the Button component
      add(btnCount);                    // "super" Frame container adds Button component
 
      btnCount.addActionListener(this);
 
      setTitle("AWT Counter");  // "super" Frame sets its title
      setSize(250, 100);        // "super" Frame sets its initial window size
 
      setVisible(true);         // "super" Frame shows
   }
   
   public int getCount(){
	   return count;
   }
   
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
      ++count; // Increase the counter value
      // Display the counter value on the TextField tfCount
      tfCount.setText(count + ""); // Convert int to String
   }
}