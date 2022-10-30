/*
Caroline Hsu - 3/24/2021

This compound interest input frame gets the user input from the user
and goes into the compound interest class for calculation. It has a
menu bar for access and buttons to exit, return, clear the text fields,
or solve the programs. It has an image describing the formula and
has instructions for the user.
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
import javax.swing.JTextField;

public class CompoundInterestInput extends JFrame implements ActionListener
{
  // declare colors and fonts
  public static final Color PINK_COLOR = new Color(235, 109, 163);
  public static final Color LIGHT_BLUE_COLOR = new Color(115, 209, 247);
  public static final Color GREEN_COLOR = new Color(146, 203, 115);
  public static final Font TREBUCHET_FONT = new Font("Trebuchet MS", Font.PLAIN,
      16);
  public static final Font HELVETICA_FONT = new Font("Helvetica", Font.BOLD,
      20);

  // declare photo
  public final URL COMPOUND_PATH = getClass().getResource("Compound Interest.png");
  private final ImageIcon COMPOUND_IMAGE = new ImageIcon(new ImageIcon(
      COMPOUND_PATH).getImage().getScaledInstance(
      500, 420, Image.SCALE_DEFAULT));

  // declare labels for photos and text and panel for labels
  private JLabel compoundLabel;
  private JLabel textLabel;
  private JPanel centralPanel;

  // declare buttons and panels for solving, exiting, and clearing
  private JPanel buttonPanel;
  private JButton solveButton;
  private JButton exitButton;
  private JButton clearButton;
  private JButton returnButton;

  // declare menu, menu bar, and menu items
  private JMenuBar mainBar;
  private JMenu navigationMenu;
  private JMenuItem helpItem;
  private JMenuItem welcomeItem;
  private JMenuItem continuousInterestInputItem;

  // declare buttons, labels, panels, text fields for inputting information
  private JPanel inputPanel;
  private JTextField principalTextField;
  private JTextField rateTextField;
  private JTextField timesCompoundedTextField;
  private JTextField yearsTextField;
  private JLabel principalLabel;
  private JLabel rateLabel;
  private JLabel timesCompoundedLabel;
  private JLabel yearsLabel;

  // constructor for the frame
  public CompoundInterestInput()
  {
    // initializing the frame
    super("Compound Interest Input Frame");
    this.setBounds(100, 100, 1200, 800);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.getContentPane().setBackground(GREEN_COLOR);
    this.setLayout(new BorderLayout());

    // constructing the menu, menu bar, menu items
    this.mainBar = new JMenuBar();
    this.navigationMenu = new JMenu("Navigation");
    this.continuousInterestInputItem = new JMenuItem("Continuous Interest");
    continuousInterestInputItem.addActionListener(this);
    this.helpItem = new JMenuItem("Help");
    helpItem.addActionListener(this);
    this.welcomeItem = new JMenuItem("Welcome");
    welcomeItem.addActionListener(this);

    // add menu bar items to menu 
    mainBar.add(navigationMenu);
    navigationMenu.add(welcomeItem);
    navigationMenu.add(helpItem);
    navigationMenu.add(continuousInterestInputItem);

    // construct the central panel for photo and label
    this.centralPanel = new JPanel(new GridLayout(1, 2, 2, 2));
    centralPanel.setBackground(GREEN_COLOR);
    this.compoundLabel = new JLabel(COMPOUND_IMAGE);
    this.textLabel = new JLabel("<html> <center>Compound interest is calculated"
        + " with principal amount, times compounded, years, and decimal "
        + " rate. Please make sure your principal amount is in decimal form"
        + " (such as 500.30, if you have a flat number like 2, use 2.00),"
        + " make sure your rate is in decimals (5 percent would be 0.05), and"
        + " times compounded and years must be positive integers. For more"
        + " assistance, please view the help frame with the navigation menu"
        + " bar. </html> </center>");
    textLabel.setFont(HELVETICA_FONT);

    // add the labels to the central panel
    centralPanel.add(textLabel);
    centralPanel.add(compoundLabel);

    // construct the button panel and buttons for solving/exiting
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(LIGHT_BLUE_COLOR);
    this.exitButton = new JButton("Exit the program");
    exitButton.addActionListener(this);
    this.solveButton = new JButton("Solve the program");
    solveButton.addActionListener(this);
    this.clearButton = new JButton("Clear your entries");
    clearButton.addActionListener(this);
    this.returnButton = new JButton("Return to welcome");
    returnButton.addActionListener(this);

    // add buttons to button panel
    buttonPanel.add(returnButton);
    buttonPanel.add(exitButton);
    buttonPanel.add(solveButton);
    buttonPanel.add(clearButton);

    // construct input panel and labels and text fields for info from user
    this.inputPanel = new JPanel(new GridLayout(2, 4, 3, 3));
    inputPanel.setBackground(PINK_COLOR);
    this.principalTextField = new JTextField(5);
    this.rateTextField = new JTextField(5);
    this.timesCompoundedTextField = new JTextField(5);
    this.yearsTextField = new JTextField(5);
    this.principalLabel = new JLabel("Principal Amount: ");
    this.principalLabel.setFont(TREBUCHET_FONT);
    this.rateLabel = new JLabel("Rate: ");
    this.rateLabel.setFont(TREBUCHET_FONT);
    this.timesCompoundedLabel = new JLabel("Times Compounded: ");
    this.timesCompoundedLabel.setFont(TREBUCHET_FONT);
    this.yearsLabel = new JLabel("Time: ");
    this.yearsLabel.setFont(TREBUCHET_FONT);

    // add components to the panel in order because of grid layout
    inputPanel.add(principalLabel);
    inputPanel.add(principalTextField);
    inputPanel.add(rateLabel);
    inputPanel.add(rateTextField);
    inputPanel.add(timesCompoundedLabel);
    inputPanel.add(timesCompoundedTextField);
    inputPanel.add(yearsLabel);
    inputPanel.add(yearsTextField);

    // add to the frame and set all as visible
    this.setJMenuBar(mainBar);
    this.add(inputPanel, BorderLayout.NORTH);
    this.add(centralPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    // main class constructs frame/object
    new CompoundInterestInput();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // declare numbers for user input and string for parse and result for
    // after program is done with the calculation
    Object command = e.getSource();
    double principal;
    int years;
    int timesCompounded;
    double rate;
    String principalString;
    String yearsString;
    String timesCompoundedString;
    String rateString;
    String compoundAnswerString;
    double result;

    // if statement for if the solve button is chosen
    if (command == solveButton)
    {
      // will try solvng the program 
      try
      {
        // read text fields and parse into doubles, and assign them to
        // the double or integer values for the new calculation
        principalString = principalTextField.getText();
        principal = Double.parseDouble(principalString);
        yearsString = yearsTextField.getText();
        years = Integer.parseInt(yearsString);
        timesCompoundedString = timesCompoundedTextField.getText();
        timesCompounded = Integer.parseInt(timesCompoundedString);
        rateString = rateTextField.getText();
        rate = Double.parseDouble(rateString);
        // calculates with the computational class with given values
        CompoundInterest interestCalc = new CompoundInterest(principal, years,
            timesCompounded, rate);
        // gets the answer and puts it to the string for the output class
        result = interestCalc.getResult();
        // answer string so it can be passed to the compound output class
        compoundAnswerString = "<html> <center>The compound interest from principal"
            + " amount " + principal + " dollars, <br>" + years
            + " years, " + timesCompounded + " times compounded, "
            + " and a rate of " + rate + " equals " + result
            + " dollars.</html> </center>";
        new CompoundOutput(compoundAnswerString);
        System.out.println(result);
      }
      // catches the number format exception (if a non-number is entered or
      // if a string cannot be converted to a number)
      catch (NumberFormatException nfe)
      {
        // opens a warning frame with a message
        new Warning("<html> <center> Please enter a number and make sure"
            + "  it follows the rules with the help frame. This is"
            + " an error with the number format. </center> </html>");
      }
      // catches an arithmetic exception when there is an error with 
      // the operation
      catch (ArithmeticException ae)
      {
        // opens a warning frame with a message
        new Warning("<html> <center> Please ensure your numbers follow the"
            + " rules the help frame and ensure that you entered them correctly"
            + ". This is an error with the arithmetic operation.</center> </html>");
      }
      // catches general exceptions- not specific, error too broad
      catch (Exception exp)
      {
        // opens a warning frame with a message
        new Warning("<html> <center>You have entered something wrong!"
            + " Please try again and refer to the help frame if"
            + " needed.</center> </html>");
      }
    }
    // else if statement for if the return button is chosen
    else if (command == returnButton)
    {
      // disposes the current frame and opens the welcome frame
      this.dispose();
      new Welcome();
    }
    // else if statement for if the exit button is chosen
    else if (command == exitButton)
    {
      // exits the program
      System.exit(0);
    }
    // else if statement for if the clear button is chosen
    else if (command == clearButton)
    {
      // clears all the textfields
      principalTextField.setText("");
      yearsTextField.setText("");
      timesCompoundedTextField.setText("");
      rateTextField.setText("");
    }
    // else if statement for if the continuous interest input item is chosen
    else if (command == continuousInterestInputItem)
    {
      // disposes current frame and opens a continuous interest input frame
      this.dispose();
      new ContinuousInterestInput();
    }
    // else if statement for if the help item is chosen
    else if (command == helpItem)
    {
      // displays a help frame with a message
      new Help("<html> <center>Compound interest is solved with the principal"
          + " amount, rate, number of times compounded, and number of years."
          + " Make sure to enter your principal amount as a decimal number, your"
          + " rate as a decimal number (not as the percent, if your rate is 3"
          + " percent then you would write it as 0.03), your number of times"
          + " compounded as a positive integer, and your number of years as"
          + " a positive integer. If you are in need of navigation, the"
          + " menu bar is equipped with the welcome frame and other continuous"
          + " input frame. The button panel at the bottom: return button to"
          + " return to the welcome frame to start over, exit the program if"
          + " you would like to quit, solve the program to produce an output"
          + " frame with your answers, and clear your entries to clear the"
          + " textfields.</center> </html>");
    }
    // else if statement for if the welcome item is chosen
    else if (command == welcomeItem)
    {
      // disposes frame and opens a welcome frame
      this.dispose();
      new Welcome();
    }

    // validate and repaint the frame
    this.validate();
    this.repaint();
  }
}
