/*
Caroline Hsu - 3/24/2021

This continuous interest input frame gets the user input from the user
and goes into the continuous interest class for calculation. It has a
menu bar for access and buttons to exit, return, clear the text fields,
or solve the programs. It has an image describing the formula and
has instructions for the user.
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContinuousInterestInput extends JFrame implements ActionListener
{
  // declare photo and color (no fonts because we use it from the other input
  // class for design continuity)
  public static final Color AQUA_COLOR = new Color(155, 209, 199);
  public final URL CONTINUOUS_PATH = getClass().getResource("Continuous "
                                     + "Interest.png");
  private final ImageIcon CONTINUOUS_IMAGE = new ImageIcon(new ImageIcon(
                            CONTINUOUS_PATH).getImage().getScaledInstance(
                            500, 420, Image.SCALE_DEFAULT));

  // declare panel and labels for text and photo
  private JPanel centralPanel;
  private JLabel textLabel;
  private JLabel continuousLabel;

  // declare menu, menu bar, and menu items
  private JMenuBar mainBar;
  private JMenu navigationMenu;
  private JMenuItem helpItem;
  private JMenuItem welcomeItem;
  private JMenuItem compoundInterestInputItem;

  // declare buttons and panels for solving and exiting the program
  private JPanel buttonPanel;
  private JButton exitButton;
  private JButton solveButton;
  private JButton clearButton;
  private JButton returnButton;

  // declare buttons, labels, panels, text fields for inputting information
  private JPanel inputPanel;
  private JTextField principalTextField;
  private JTextField rateTextField;
  private JTextField yearsTextField;
  private JLabel principalLabel;
  private JLabel rateLabel;
  private JLabel yearsLabel;
  private JLabel fakeLabel;
  private JLabel anotherFakeLabel;

  // constructor for the frame
  public ContinuousInterestInput()
  {
    // initializing the frame
    super("Continuous Interest Input Frame");
    this.setBounds(100, 100, 1000, 700);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.getContentPane().setBackground(AQUA_COLOR);
    this.setLayout(new BorderLayout());

    // construct the menu bar, menu, and menu items for user
    this.mainBar = new JMenuBar();
    this.navigationMenu = new JMenu("Navigation");
    this.compoundInterestInputItem = new JMenuItem("Compound Interest");
    compoundInterestInputItem.addActionListener(this);
    this.helpItem = new JMenuItem("Help");
    helpItem.addActionListener(this);
    this.welcomeItem = new JMenuItem("Welcome");
    welcomeItem.addActionListener(this);

    // add items to menu bar and menu
    mainBar.add(navigationMenu);
    navigationMenu.add(welcomeItem);
    navigationMenu.add(helpItem);
    navigationMenu.add(compoundInterestInputItem);

    // construct the central panel with the photo label and text label
    // construct the central panel for photo and label
    this.centralPanel = new JPanel(new GridLayout(1,2,2,2));
    centralPanel.setBackground(AQUA_COLOR);
    this.continuousLabel = new JLabel(CONTINUOUS_IMAGE);
    this.textLabel = new JLabel("<html> <center>Continuous interest is calculated"
        + " with principal amount, years, and decimal rate. Please make sure"
        + " your principal amount is in decimal form (such as 500.30,"
        + " (if you have a flat number like 2, use 2.00), make sure your"
        + " rate is in decimals (5 percent would be 0.05), and times"
        + " compounded and years must be positive integers. For more"
        + " assistance, please view the help frame with the navigation menu"
        + " bar. </html> </center>");
    textLabel.setFont(CompoundInterestInput.HELVETICA_FONT);

    // add the labels to the central panel
    centralPanel.add(textLabel);
    centralPanel.add(continuousLabel);

    // contruct the button panel and exit, solve, and clear buttons
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(CompoundInterestInput.LIGHT_BLUE_COLOR);
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
    inputPanel = new JPanel(new GridLayout(2, 4, 3, 3));
    inputPanel.setBackground(CompoundInterestInput.PINK_COLOR);
    principalTextField = new JTextField(5);
    rateTextField = new JTextField(5);
    yearsTextField = new JTextField(5);
    principalLabel = new JLabel("Principal Amount: ");
    this.principalLabel.setFont(CompoundInterestInput.TREBUCHET_FONT);
    rateLabel = new JLabel("Rate: ");
    this.rateLabel.setFont(CompoundInterestInput.TREBUCHET_FONT);
    yearsLabel = new JLabel("Time: ");
    this.yearsLabel.setFont(CompoundInterestInput.TREBUCHET_FONT);
    fakeLabel = new JLabel("");
    anotherFakeLabel = new JLabel("");

    // add the text fields and labels to the panel in order of grid layout
    inputPanel.add(principalLabel);
    inputPanel.add(principalTextField);
    inputPanel.add(rateLabel);
    inputPanel.add(rateTextField);
    inputPanel.add(yearsLabel);
    inputPanel.add(yearsTextField);
    inputPanel.add(fakeLabel);
    inputPanel.add(anotherFakeLabel);

    // add to frame and set all to visible if true
    this.setJMenuBar(mainBar);
    this.add(inputPanel, BorderLayout.NORTH);
    this.add(centralPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    // main method to make the frame
    new ContinuousInterestInput();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // declare numbers for user input and string for parse and result for
    // after program is done with the calculation
    // gets the source of the command
    Object command = e.getSource();
    double principal;
    int years;
    double rate;
    String principalString;
    String yearsString;
    String rateString;
    String continuousAnswerString;
    double result;

    // if statement for if the solve button is pushed
    if (command == solveButton)
    {
      // tries to solve the program with values entered
      try
      {
        // read text fields and parse into doubles or int if required
        // then set them equal to the actionPerformed variable
        principalString = principalTextField.getText();
        principal = Double.parseDouble(principalString);
        yearsString = yearsTextField.getText();
        years = Integer.parseInt(yearsString);
        rateString = rateTextField.getText();
        rate = Double.parseDouble(rateString);
        // calculates with the computational class with given values
        ContinuousInterest interestCalc = new ContinuousInterest(principal, rate,
            years);
        // gets the answer and puts it to the string for the output class
        result = interestCalc.getResult();
        // answer string so it can be passed to the continuous output class
        continuousAnswerString = "<html> <center>The continuous interest from principal"
            + " amount " + principal + " dollars, <br>" + years
            + " years, and a rate of " + rate + " equals "
            + result + " dollars.</html> </center>";
        // passes the answer string to the continuous output frame
        new ContinuousOutput(continuousAnswerString);
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
            + ". This is an error with the arithmetic operation, so"
            + " there is a chance these numbers are not compatible"
            + " with solving this program.</center> </html>");
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
      rateTextField.setText("");
    }
    // else if statement for if the compound interest input item is chosen
    else if (command == compoundInterestInputItem)
    {
      // disposes current frame and opens a compound interest input frame
      this.dispose();
      new CompoundInterestInput();
    }
    // else if statement for if the help item is chosen
    else if (command == helpItem)
    {
      // displays a help frame with a message
      new Help("<html> <center>Continuous interest is solved with the principal"
          + " amount, rate, and number of years. Make sure to enter your"
          + " principal amount as a decimal number, your rate as a decimal"
          + " number (not as the percent, if your rate is 3 percent then you"
          + " would write it as 0.03), and your number of years as"
          + " positive integer. If you are in need of navigation, the menu"
          + " bar is equipped with the welcome frame and the compound"
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
