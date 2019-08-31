//java -classpath . ConverterExample
//A challenge, how to validate input ?

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConverterExample
{
  

  public static void main(String[] args)
  {
    // schedule this for the event dispatch thread (edt)
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        new ConverterExample(); 
      }
    });
  }

    boolean direction=true;
    final String option2="From kilometers to miles";
    final String option1="From miles to kilometers";

    JRadioButton mtokButton = new JRadioButton(option1);
    JRadioButton ktomButton = new JRadioButton(option2);
    JFrame frame;
     double result;


  public ConverterExample()
  {
    

    frame = new JFrame("FALL 19 CSCI 268 Converter Example by Dr. S. Zhang");


    frame.getContentPane().setLayout(new GridLayout(4,2));

    JLabel milesprompt = new JLabel("Mileages below:");
    frame.add(milesprompt);
    JLabel kmprompt = new JLabel("Kilometers below:");
    frame.add(kmprompt);

    final JTextField miles = new JTextField("0.0");
    final JTextField km = new JTextField("0.0");
    frame.add(miles);
    frame.add(km);


    //Create the radio buttons.

    mtokButton.setMnemonic(KeyEvent.VK_M);
    mtokButton.setSelected(true);
    //You should generally initialize a group of radio buttons so that one is selected. 
    //However, the API doesn't enforce this rule ¡ª a group of radio buttons can have no initial selection. 
    //Once the user has made a selection, exactly one button is selected from then on.
    
    ktomButton.setMnemonic(KeyEvent.VK_K); //alt-k
    
    
    //Group the radio buttons.
    //For each group of radio buttons, you need to create a ButtonGroup instance and add each radio button to it. 
    //The ButtonGroup takes care of unselecting the previously selected button when the user selects another button in the group.

    ButtonGroup group = new ButtonGroup();
    group.add(mtokButton);
    group.add(ktomButton);

    MyActionListener rl=new MyActionListener();
	
    //Register a listener for the radio buttons.
    mtokButton.addActionListener(rl);
    ktomButton.addActionListener(rl);

    frame.add(mtokButton);
    frame.add(ktomButton);
    
    // create our jbutton
    JButton convert = new JButton("Convert");
    // put the button on the frame

    frame.add(convert);

    JButton help = new JButton("Help");
    // put the button on the frame

    frame.add(help);
    
    
    // set up the jframe, then display it
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(600, 200));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    
    // add the listener to the jbutton to handle the "pressed" event
    convert.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
	if (direction==true)
		{
		result=Double.parseDouble(miles.getText())*1.6;
        	km.setText(Double.toString(result));
	}
	else
	{       result=Double.valueOf(km.getText())/1.6;
		miles.setText(Double.toString(result));
	}
      }
    });


    // add the listener to the jbutton to handle the "pressed" event
    help.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
         JDialog d1 = new JDialog(frame, "Help Fall 2019 Converter"); 
  
            // create a label 
            JLabel l = new JLabel("This tool converts between mileages and Kilometers. Fullfill part 2 of hw1!"); 
  
            d1.add(l); 
  
            // setsize of dialog 
            d1.setSize(400, 100); 
  
            // set loaction of dialog 
            d1.setLocationRelativeTo(frame); 
  
            // set visibility of dialog 
            d1.setVisible(true); 
      }
    });



  }

class MyActionListener implements ActionListener {
 
        //close and dispose of the window.
        public void actionPerformed(ActionEvent e) {
            System.out.println("disposing the window.."+e.toString());
            JRadioButton button = (JRadioButton) e.getSource();
 
        if (button == mtokButton ){
 
            direction=true;
 
        } else if (button == ktomButton) {
 
            direction=false;
 
        } 		
        }
    }


}