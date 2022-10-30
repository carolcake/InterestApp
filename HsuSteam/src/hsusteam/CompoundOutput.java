/*
Caroline Hsu - 4/02/2021
This frame displays the compound interest answer and is a pop-up frame.
It does not have a menu bar but has buttons to return or exit the 
program.
 */
package hsusteam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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


public class CompoundOutput extends JFrame implements ActionListener
{
  // declare colors and fonts and photo 
  public static final Font FUTURA_FONT = new Font("Futura", Font.BOLD, 25);
  public static final Color LILAC_COLOR = new Color(183,149,246);
  public static final Color DARK_PINK_COLOR = new Color(255,122,131);
  public final URL FLOWER_PATH = getClass().getResource("Flower.png");
  private final ImageIcon FLOWER_IMAGE = new ImageIcon(new ImageIcon(
                                  FLOWER_PATH).getImage().getScaledInstance(
                                  400,400,Image.SCALE_DEFAULT));
  
  // delcare photos and label for photo, also the panel to hold them
  private JPanel centralPanel;
  private JLabel messageLabel;
  private JLabel flowerLabel;
  
  // buttons for return and exit, and the panel
  private JPanel buttonPanel;
  private JButton returnButton;
  private JButton exitButton;
  
  // constructor for the frame that receives the answer string for display
  public CompoundOutput(String compoundAnswerString)
  {
    // construct the frame
    this.setBounds(200,200,1000,600);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.getContentPane().setBackground(LILAC_COLOR);
    // anonymous object for layout
    this.setLayout(new BorderLayout());
    
    // construct the message label and image label and panel for them
    this.centralPanel = new JPanel(new GridLayout(1,2,2,2));
    centralPanel.setBackground(LILAC_COLOR);
    this.messageLabel = new JLabel(compoundAnswerString);
    this.messageLabel.setFont(FUTURA_FONT);
    this.flowerLabel = new JLabel(FLOWER_IMAGE);
    
    // add message label and image label to the panel
    centralPanel.add(messageLabel);
    centralPanel.add(flowerLabel);
    
    // construct the buttons and button panel
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(DARK_PINK_COLOR);
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
  
  public static void main (String[] args)
  {
    // main method with the string
    new CompoundOutput("<html> <center>Compound interest is calculated from"
               + " the principal amount, times compounded, years, and decimal "
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
