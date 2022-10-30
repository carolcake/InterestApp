/*
Caroline Hsu - 3/11/2021

This is the welcome frame and displays the title of my application in the
super. I have my name and a description of what my program does in the 
explanation label. A menu bar is provided at the top for assistance and
a picture with a description for both formulas is there. The button
panel at the bottom allows the user to choose which input frame to 
go to or to exit the program.
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Welcome extends JFrame implements ActionListener
{
  // declare fonts and colors
  public static final Color BLUE_COLOR = new Color(135,156,222);
  public static final Color PURPLE_COLOR = new Color(160,81,177);
  public static final Font COURIER_FONT = new Font("Courier", Font.BOLD,
                                                    32);
  
  // declare picture
  public final URL FORMULAS_PATH = getClass().getResource("Formulas.png");
  private final ImageIcon FORMULAS_IMAGE = new ImageIcon(new ImageIcon(
                                  FORMULAS_PATH).getImage().getScaledInstance(
                                  620,300,Image.SCALE_DEFAULT));
  
  // delcare menu, menu bar, and menu items
  private JMenuBar mainBar;
  private JMenu navigationMenu;
  private JMenu inputMenu;
  private JMenuItem helpItem;
  private JMenuItem compoundInterestInputItem;
  private JMenuItem continuousInterestInputItem;
  
  // declare labels and panel for photos and text
  private JLabel programExplanationLabel;
  private JLabel formulasLabel;
  private JPanel centralPanel;
  
  // declare radio buttons, button for exit, button panel, and group
  private JPanel buttonPanel;
  private JRadioButton compoundInterestButton;
  private JRadioButton continuousInterestButton;
  private ButtonGroup interestGroup;
  private JButton exitButton;
  private JButton continueButton;
  
  // constructor for the frame
  public Welcome()
  {
    // initializing the frame
    super("Welcome! This program solves for compound or continuous interest.");
    this.setBounds(100,100,1000,700);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.getContentPane().setBackground(BLUE_COLOR);
    this.setLayout(new BorderLayout());
    
    // construct the menu bar, menu, and items
    this.mainBar = new JMenuBar();
    this.navigationMenu = new JMenu("Navigation");
    this.inputMenu = new JMenu("Interest Inputs");
    this.compoundInterestInputItem = new JMenuItem("Compound Interest");
    compoundInterestInputItem.addActionListener(this);
    this.continuousInterestInputItem = new JMenuItem("Continuous Interest");
    continuousInterestInputItem.addActionListener(this);
    this.helpItem = new JMenuItem("Help");
    helpItem.addActionListener(this);
    
    // add menu bar items to the menu and main bar
    mainBar.add(navigationMenu);
    navigationMenu.add(helpItem);
    navigationMenu.add(inputMenu);
    inputMenu.add(compoundInterestInputItem);
    inputMenu.add(continuousInterestInputItem);
    
    // construct the central panel and labels for program explanation
    // and picture, and add the explanation and image to panel
    centralPanel = new JPanel(new GridLayout(2,1,1,1));
    centralPanel.setBackground(BLUE_COLOR);
    programExplanationLabel = new JLabel("<html> <center>Hi! I am Caroline Hsu"
        + " and welcome to my program! My program solves for either"
        + " compound or continuous interest. You can choose either one"
        + " and a new frame will appear. A navigation menu is at the"
        + " top of this frame and for more help on how to use this"
        + " program or for more information about the maker of the"
        + " program, click the help frame.</center> </html>");
    programExplanationLabel.setFont(COURIER_FONT);
    formulasLabel = new JLabel(FORMULAS_IMAGE);
    
    // add the program explanation and formulas label to the central panel
    centralPanel.add(programExplanationLabel);
    centralPanel.add(formulasLabel);
    
    // construct the radio buttons, button group, button panel, and 
    // exit button and add the radio buttons to the button group
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(PURPLE_COLOR);
    this.compoundInterestButton = new JRadioButton("Compound Interest");
    compoundInterestButton.addActionListener(this);
    this.continuousInterestButton = new JRadioButton("Continuous Interest");
    continuousInterestButton.addActionListener(this);
    this.interestGroup = new ButtonGroup();
    interestGroup.add(compoundInterestButton);
    interestGroup.add(continuousInterestButton);
    this.exitButton = new JButton("Exit the program");
    exitButton.addActionListener(this);
    this.continueButton = new JButton("Continue to input");
    continueButton.addActionListener(this);
    
    // add buttons to the panel
    buttonPanel.add(compoundInterestButton);
    buttonPanel.add(continuousInterestButton);
    buttonPanel.add(continueButton);
    buttonPanel.add(exitButton);
    
    // add panels and menu bar to the frame and set all as visible
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.add(centralPanel, BorderLayout.CENTER);
    this.setJMenuBar(mainBar);
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    // main class to construct the object
    new Welcome();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // gets the source of the command for action performed with the button
    Object command = e.getSource();
    // if statement for if the continue button is chosen
    if (command == continueButton)
    {
      // another if statement for if the compound interest button is selected
      if (compoundInterestButton.isSelected())
      {
        // disposes the current frame and opens up the compound interest
        // input frame
        this.dispose();
        new CompoundInterestInput();
      }
      // else if statement for it the continuous interest button is selected
      else if (continuousInterestButton.isSelected())
      {
        // disposes the current frame and opens up the continuous interest
        // input frame
        this.dispose();
        new ContinuousInterestInput();
      }
    }
    // else if statement for if the exit button is chosen
    else if (command == exitButton)
    {
      // will exit the entire program
      System.exit(0);
    }
    // else if statement for if the compound interest input item (menu bar)
    // is chosen
    else if (command == compoundInterestInputItem)
    {
      // disposes the current frame and opens up the compound interest input
      // frame
      this.dispose();
      new CompoundInterestInput();
    }
    // else if statement for if the contninuous interest input item (menu bar)
    // is chosen
    else if (command == continuousInterestInputItem)
    {
      // disposes the current frame and opens up the continuous interest input
      // frame
      this.dispose();
      new ContinuousInterestInput();
    }
    // else if statement for if the help item is chosen
    else if (command == helpItem)
    {
      // will open up a pop up frame of the help frame with the help
      // message
      new Help("<html> <center>Welcome to my program. Compound interest is"
        + " calculated from the principal amount, times compounded,"
        + " years, and decimal  rate. Continuous interest is calculated"
        + " from the principal amount, years, and decimal rate.<br>"
        + "My name is Caroline Hsu and I am a sophomore at the Village High"
        + " School and I am an aspiring programmer! I've been taught by the"
        + " best teacher, Mr. Ansari! </center> </html>");
    }
    // validate and repaint the frame in case components don't show
    this.validate();
    this.repaint();
  }
  
}
