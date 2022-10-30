/*
Caroline Hsu - 04/02/2021
This frame displays the continuous interest answer and is a pop-up frame.
It does not have a menu bar but has buttons to return or exit the 
program.
 */
package hsusteam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContinuousOutput extends JFrame implements ActionListener
{
  // declare color (reuse font for design) and picture
  public static final Color SKY_BLUE_COLOR = new Color(171,212,242);
  public final URL PURPLE_FLOWER_PATH = getClass().getResource("Purple "
      + "Flower.jpeg");
  private final ImageIcon PURPLE_FLOWER_IMAGE = new ImageIcon(new ImageIcon(
                                  PURPLE_FLOWER_PATH).getImage().getScaledInstance(
                                  400,360,Image.SCALE_DEFAULT));
  
  // delcare photos and label for photo, also the panel to hold them
  private JPanel centralPanel;
  private JLabel messageLabel;
  private JLabel purpleFlowerLabel;
  
  // buttons for return and exit, and the panel
  private JPanel buttonPanel;
  private JButton returnButton;
  private JButton exitButton;
  
  // constructs the frame and receives the answer string for display
  public ContinuousOutput(String continuousAnswerString)
  {
    // construct the frame
    this.setBounds(200,200,1000,600);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.getContentPane().setBackground(SKY_BLUE_COLOR);
    // anonymous object for layout
    this.setLayout(new BorderLayout());
    
    // construct the message label and image label and panel for them
    this.centralPanel = new JPanel(new GridLayout(1,2,2,2));
    centralPanel.setBackground(SKY_BLUE_COLOR);
    this.messageLabel = new JLabel(continuousAnswerString);
    this.messageLabel.setFont(CompoundOutput.FUTURA_FONT);
    this.purpleFlowerLabel = new JLabel(PURPLE_FLOWER_IMAGE);
    
    // add message label and image label to the panel
    centralPanel.add(messageLabel);
    centralPanel.add(purpleFlowerLabel);
    
    // construct the buttons and button panel
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(CompoundOutput.DARK_PINK_COLOR);
    this.returnButton = new JButton("Return to the input");
    returnButton.addActionListener(this);
    this.exitButton = new JButton("Exit the program");
    exitButton.addActionListener((this));
    
    // add buttons to the panel
    buttonPanel.add(returnButton);
    buttonPanel.add(exitButton);
    
    // add to frame and set visible as true
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.add(centralPanel, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  public static void main(String[] args)
  {
    // main method with the string
    new ContinuousOutput("<html> <center>Continuous interest is calculated "
               + "from the principal amount, years, and decimal "
               + " rate. </html> </center>");
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    // gets the source of the command (button)
    Object command = e.getSource();
    // if the button to return is pushed
    if (command == returnButton)
    {
      // then dispose this frame since it's a pop up
      this.dispose();
    }
    // else if the button to exit is pushed
    else if (command == exitButton)
    {
      // quit the program
      System.exit(0);
    }
    // validate and repaint the frame
    this.validate();
    this.repaint();
  }
  
}
