/*
Caroline Hsu - 04/06/2021
This warning class displays a warning for the user when an error occurs. 
It has a menu bar for access and has a return or exit button. Users are
able to dispose on close the frame.
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Warning extends JFrame implements ActionListener
{
  // declare colors and fonts and photo
  public final URL WARNING_PATH = getClass().getResource("Warning.jpeg");
  private final ImageIcon WARNING_IMAGE = new ImageIcon(new ImageIcon(
      WARNING_PATH).getImage().getScaledInstance(
      300, 300, Image.SCALE_DEFAULT));
  public static final Color RED_COLOR = new Color(235, 88, 80);
  public static final Color CREAM_COLOR = new Color(239, 210, 141);
  public static final Font TIMES_FONT = new Font("Times", Font.PLAIN, 24);

  // delcare photos and label for photo, also the panel to hold them
  private JPanel centralPanel;
  private JLabel messageLabel;
  private JLabel warningLabel;

  // buttons for return and exit, and the panel
  private JPanel buttonPanel;
  private JButton returnButton;
  private JButton exitButton;

  // delcare menu, menu bar, and menu items
  private JMenuBar mainBar;
  private JMenu navigationMenu;
  private JMenu inputMenu;
  private JMenuItem welcomeItem;
  private JMenuItem helpItem;
  private JMenuItem compoundInterestInputItem;
  private JMenuItem continuousInterestInputItem;

  public Warning(String warningMessage)
  {
    // initializing the frame
    super("Warning!");
    this.setBounds(400, 100, 800, 700);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.getContentPane().setBackground(RED_COLOR);
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
    this.welcomeItem = new JMenuItem("Welcome");
    welcomeItem.addActionListener(this);

    // add menu bar items to the menu and main bar
    mainBar.add(navigationMenu);
    navigationMenu.add(welcomeItem);
    navigationMenu.add(helpItem);
    navigationMenu.add(inputMenu);
    inputMenu.add(compoundInterestInputItem);
    inputMenu.add(continuousInterestInputItem);

    // construct the message label and image label and panel for them
    this.centralPanel = new JPanel(new GridLayout(1, 2, 2, 2));
    centralPanel.setBackground(RED_COLOR);
    this.messageLabel = new JLabel(warningMessage);
    this.messageLabel.setFont(TIMES_FONT);
    this.warningLabel = new JLabel(WARNING_IMAGE);

    // add labels to the panel 
    centralPanel.add(messageLabel);
    centralPanel.add(warningLabel);

    // construct the buttons and the button panel
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(CREAM_COLOR);
    this.returnButton = new JButton("Return to the program");
    returnButton.addActionListener(this);
    this.exitButton = new JButton("Exit the program");
    exitButton.addActionListener((this));

    // add buttons to the panel
    buttonPanel.add(returnButton);
    buttonPanel.add(exitButton);

    // add panels and menu bar to the frame and set all visible as true
    this.setJMenuBar(mainBar);
    this.add(centralPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    // main method with the string
    new Warning("<html> <center>We have found an error in your program. Please use"
        + " the help frame if you have more questions.</center> </html>");
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
    // else if statement for if the compound interest input item is chosen
    else if (command == compoundInterestInputItem)
    {
      // disposes warning frame and opens a compound interest input frame
      this.dispose();
      new CompoundInterestInput();
    }
    // else if statement for if the continuous interest input item is chosen
    else if (command == continuousInterestInputItem)
    {
      // disposes warning frame and opens a continuous interest input frame
      this.dispose();
      new ContinuousInterestInput();
    }
    // else if statement for if the help item is chosen
    else if (command == helpItem)
    {
      // displays a help frame with a message
      new Help("<html> <center>If you need help on specific inputs, please"
          + "refer to their frames and click help. Compound interest is"
          + " calculated from the principal amount, times compounded,"
          + " years, and decimal rate. Continuous interest is calculated"
          + " from the principal amount, years, and decimal rate.<br>"
          + "My name is Caroline Hsu and I am a sophomore at the Village High"
          + " School and I am an aspiring programmer! I've been taught by the"
          + " best teacher, Mr. Ansari! </center> </html>");
    }
    // else if statement for if the welcome item is chosen
    else if (command == welcomeItem)
    {
      // disposes the warning frame and opens a new welcome frame
      this.dispose();
      new Welcome();
    }
    // validate and repaint the frame
    this.validate();
    this.repaint();
  }

}
