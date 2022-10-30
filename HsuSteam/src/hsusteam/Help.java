/*
Caroline Hsu - 3/25/2021

Help frame explains how to use my application for the different input
frames and the welcome frame explains who I am. As a pop-up frame,
this does not have a menu bar but has buttons to exit or return.
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


public class Help extends JFrame implements ActionListener
{
  // declare colors and fonts
  public static final Color YELLOW_COLOR = new Color(255,194,62);
  public static final Color PINK_COLOR = new Color(245,211,204);
  public static final Font GEORGIA_FONT = new Font("Georgia", Font.PLAIN, 25);
  
  // declare photo
  public final URL CAROLINE_PATH = getClass().getResource("Caroline Hsu.JPG");
  private final ImageIcon CAROLINE_IMAGE = new ImageIcon(new ImageIcon(
                                  CAROLINE_PATH).getImage().getScaledInstance(
                                  400,520,Image.SCALE_DEFAULT));
  
  // declare labels for photos and text and panel to hold them in
  private JPanel centralPanel;
  private JLabel helpPhotoLabel;
  private JLabel explanationLabel;
  
  // declare buttons and panel for returning or exiting the program
  private JPanel buttonPanel;
  private JButton exitButton;
  private JButton returnButton;
  
  // constructor receives the help message from the different classes
  public Help(String helpString)
  {
    // initializing the frame
    super("Help Frame");
    this.setBounds(400,100,800,700);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.getContentPane().setBackground(YELLOW_COLOR);
    this.setLayout(new BorderLayout());
    
    // construct the labels for text and photo and panel to hold them in
    this.centralPanel = new JPanel(new GridLayout(1,2,3,3));
    centralPanel.setBackground(YELLOW_COLOR);
    this.helpPhotoLabel = new JLabel(CAROLINE_IMAGE);
    this.explanationLabel = new JLabel(helpString);
    
    // add to panel
    centralPanel.add(helpPhotoLabel);
    centralPanel.add(explanationLabel);
    
    // construct the panel and buttons
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(PINK_COLOR);
    this.exitButton = new JButton("Exit the program");
    exitButton.addActionListener(this);
    this.returnButton = new JButton("Return to last frame");
    returnButton.addActionListener(this);
    
    // add buttons to the panel
    buttonPanel.add(returnButton);
    buttonPanel.add(exitButton);
    
    // add labels and panel to the frame
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.add(centralPanel, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  public static void main (String[] args)
  {
    // main method to construct the frame with the string
    new Help("<html> <center>Welcome to my program. Compound interest is"
        + " calculated from the principal amount, times compounded,"
        + " years, and decimal rate. Continuous interest is calculated"
        + " from the principal amount, years, and decimal rate.<br>"
        + "My name is Caroline Hsu and I am a sophomore at the Village High"
        + " School and I am an aspiring programmer! I've been taught by the"
        + " best teacher, Mr. Ansari! </center> </html>");
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
