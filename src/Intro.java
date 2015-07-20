/**
 * Intro.java
 * Created By: William Lin
 * This program is just practice for Java.
 */


/*
Imports the need java libraries for the program
 */
import javax.swing.*; //The swing library is used to design the GUI.
import java.awt.BorderLayout; //This library is used to position the JPanels inside the JFrame.
import java.awt.Dimension; //This library is used to store the Users screen size so we can use it to center the GUI.
import java.awt.Toolkit; //This library is used to get the Users screen size which will help center the GUI on the User's screen.
import java.awt.event.ActionListener; //This library is used to listen for actions made by the user, mainly used for the Buttons in the GUI.
import java.awt.event.ActionEvent; //This library will be used to store events for a given action. Mainly used to store the event of a button click.

public class Intro{

    /**
     * This is the main method and it display a greeting and prompts
     *the user if they want to play or not.
     */
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Welcome to Dice 2.0"); //This JOptionPane displays a popup message, with one option of OK
        int reply = JOptionPane.showConfirmDialog(null, "Want To Play?","Let's Play", JOptionPane.YES_NO_OPTION); //Prompts user if they want to play or not.
        if(reply == JOptionPane.NO_OPTION){ //If the user replies 'No' the below statement block will be executed if not it is skipped.
            JOptionPane.showMessageDialog(null, "Okay Goodbye Now"); //Tells the user Goodbye before the program terminates/ends..
            System.exit(0); //This statement terminated the program or ends it.
        }
        selectDice(); //calls the selectDice() method to prompt user to select their preference for Dices.
    }

    /**
     * This method is a template for a Yes No JOptionPane. The parameters get the message and title.
     * @param message The message of the Yes or No JOptionPane.
     * @param title The title of the Yes or No JOptionPane.
     * @return A boolean depending on whether Yes or No is clicked. Yes returns true, No returns false.
     */
    public static boolean yesNo(String message, String title){
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION); //creates a confirmDialog with Yes No Option and with the parameters, message and title. Set the user response to reply
        if(reply == JOptionPane.YES_OPTION){ //if the reply, which is the response of the Yes or No confirmDialog, is the Yes option, then execute the following statement.
            return true; //Returns a true boolean to represent Yes was the response
        }
        else{ //If the reply was anything but the Yes option, then execute the following statements.
            if(title == "WINNER!!!!") JOptionPane.showMessageDialog(null, "Goodbye", "Bye", JOptionPane.PLAIN_MESSAGE); //Checks if the user said no to play again, if so user is prompted a 'goodbye'.
            return false; //return false because the No option was selected.
        }
    }

    /**
     * This method is called by the main method and it displays a GUI for selecting
     * how many dices and how many sides the dices have for the game. Also has a play button which will
     * ultimately check what options are selected and create a game() based on those options.
     */
    private static void selectDice(){

        /*
        Initializes the JFrame and JPanels that will be used.
        Also initializes dim to get the dimensions of the Users screen size.
         */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //This gets the Users screen size, will be used to center all the GUIs
        JFrame frame = new JFrame(); //The JFrame for the selectDice GUI. This JFrame will contain all the JPanels declared in this method.
        JPanel dices = new JPanel(); //JPanel that will be added into the JFrame. This JPanel contains the contents for selecting how many dices to use.
        JPanel sides = new JPanel(); //JPanel that will be added into the JFrame. This JPanel contains the contents for selecting how many sides to a dice.
        JPanel buttons = new JPanel(); //JPanel that will be added into the JFrame. This JPanel contains the 'Play' button.

        /*
        Sets JFrame frame's attributes (size, location, etc.)
        Also adds the JPanels to frame.
         */
        frame.setSize(350, 150); //sets the frame's size.
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2); //Centers the frame to the center of the User's screen
        frame.setVisible(true); //sets the frame to be visible.
        frame.setResizable(false); //frame is set to be non-resizable.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//sets what happens what the frame is closed out. Set to close the frame and ends program.
        frame.add(dices, BorderLayout.NORTH); //Adds JPanel dices to the North end of the frame.
        frame.add(sides, BorderLayout.CENTER); //Adds JPanel sides to the Center of the frame.
        frame.add(buttons, BorderLayout.SOUTH); //Adds JPanel play to the South end of the frame.

        /*
        Everything that will be added into the JPanel dices, which will help the user
        select how many dices to use.
         */
        JLabel label = new JLabel("Select How Many Dices You Will Use"); //JLabel that will prompt the user to select how many dices to use.
        JRadioButton opt1 = new JRadioButton("2"); //Option #1 for how many dices to use (2 dices).
        opt1.setSelected(true); //By default this option is selected for the user.
        JRadioButton opt2 = new JRadioButton("4"); //Option #2 for how many dices to use (4 dices).
        JRadioButton opt3 = new JRadioButton("6"); //Option #3 for how many dices to use (6 dices).

        /*
        Everything that will be added into the JPanel sides, which will help the user
        select how many sides to each dice.
         */
        JLabel label2 = new JLabel("Select How Many Sides To A Dice"); //JLabel that will prompt the user to select how many sides to a dice.
        JRadioButton side4 = new JRadioButton("4"); //Option #1 for how many sides to a dice (4 sides).
        side4.setSelected(true); //By default this option is selected for the user.
        JRadioButton side6 = new JRadioButton("6"); //Option #2 for how many sides to a dice (6 sides).
        JRadioButton side12 = new JRadioButton("12"); //Option #3 for how many sides to a dice (12 sides).

        /*
        Everything that will be added into the JPanel play, which will allow
        the user to play with his set options.
         */
        JButton play = new JButton("Play"); //This JButton is created to allow the User to press 'Play'

        /*
        This adds an ActionListener to the JButton button a.k.a(The Play Button).
        The action checks what options are selected and uses that to make the game.
         */
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(opt1.isSelected()){ //If 2 dices is selected, then check how many sides is selected.
                    if(side4.isSelected()){ //If 4 sides are selected then this true clause will execute.
                        game(2, 4); //Calls the game function with 2 dices and 4 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else if(side6.isSelected()){ //If 6 sides are selected then this true clause will execute.
                        game(2, 6); //Calls the game function with 2 dices and 6 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else if(side12.isSelected()){ //If 12 sides are selected then this true clause will execute.
                        game(2, 12); //Calls the game function with 2 dices and 12 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else{ //If some how none of the side options are selected this statement will execute.
                        JOptionPane.showMessageDialog(null, "Please Select How Many Sides To Use"); //Tells the user to choose a side.
                    }
                }
                else if(opt2.isSelected()){ //If 2 dices is selected, then check how many sides is selected.
                    if(side4.isSelected()){ //If 4 sides are selected then this true clause will execute.
                        game(4, 4); //Calls the game function with 4 dices and 4 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else if(side6.isSelected()){ //If 6 sides are selected then this true clause will execute.
                        game(4, 6); //Calls the game function with 4 dices and 6 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else if(side12.isSelected()){ //If 12 sides are selected then this true clause will execute.
                        game(4, 12); //Calls the game function with 4 dices and 12 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else{ //If some how none of the side options are selected this statement will execute.
                        JOptionPane.showMessageDialog(null, "Please Select How Many Sides To Use"); //Tells the user to choose a side.
                    }
                }
                else if(opt3.isSelected()){ //If 6 dices is selected
                    if(side4.isSelected()){ //If 4 sides are selected then this true clause will execute.
                        game(6, 4); //Calls the game function with 6 dices and 4 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else if(side6.isSelected()){ //If 6 sides are selected then this true clause will execute.
                        game(6, 6); //Calls the game function with 6 dices and 6 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else if(side12.isSelected()){ //If 12 sides are selected then this true clause will execute.
                        game(6, 12); //Calls the game function with 6 dices and 12 sides.
                        frame.dispose(); //Closes and dispose the current JFrame frame.
                    }
                    else{ //If some how none of the side options are selected this statement will execute.
                        JOptionPane.showMessageDialog(null, "Please Select How Many Sides To Use"); //Tells the user to choose a side.
                    }
                }
                else{ //If some how no choice for how many dices to use is selected, this statement will execute.
                    JOptionPane.showMessageDialog(null, "Please Select How Many Dices To Use"); //Tells the user to select how many dices they want to use.
                }
            }
        });

        /*
        Adds the three RadioButtons, for selecting how many dices to use, to a ButtonGroup named dice.
         */
        ButtonGroup dice = new ButtonGroup(); //Creates the ButtonGroup object and names it dice.
        dice.add(opt1); //Adds the first RadioButton, for how many dices, to the ButtonGroup; Option #1 for 2 dices.
        dice.add(opt2); //Adds the second RadioButton, for how many dices, to the ButtonGroup; Option #2 for 4 dices.
        dice.add(opt3); //Adds the third RadioButton, for how many dices, to the ButtonGroup; Option #3 for 6 dices.

        /*
        Adds the three RadioButtons and the label to the JPanel dices. These components will
        help the user choose how many dices to use.
         */
        dices.add(label); //Adds the label that tells the user to select how many dices they want to use.
        dices.add(opt1); //Adds the first RadioButton, for how many dices, to the JPanel dices; Option #1 for 2 dices.
        dices.add(opt2); //Adds the second RadioButton, for how many dices, to the JPanel dices; Option #2 for 4 dices.
        dices.add(opt3); //Adds the third RadioButton, for how many dices, to the JPanel dices; Option #3 for 6 dices.

        /*
        Adds the three RadioButtons, for selecting how many sides are on a dice, to a ButtonGroup named side.
         */
        ButtonGroup side = new ButtonGroup(); //Creates the ButtonGroup object and names it side.
        side.add(side4); //Adds the first RadioButton, for how many sides, to a ButtonGroup; Option #1 for 4 sides.
        side.add(side6); //Adds the second RadioButton, for how many sides, to a ButtonGroup; Option #2 for 6 sides.
        side.add(side12); //Adds the third RadioButton, for how many sides, to a ButtonGroup; Option #3 for 12 sides.

        /*
        Adds the three RadioButtons and the label to the JPanel sides. These components will
        help the user choose how many sides to a dice.
         */
        sides.add(label2); //Adds the label that tells the user to select how many sides to each dice.
        sides.add(side4); //Adds the first RadioButton, for how many dices, to the JPanel sides; Option #1 for 4 sides.
        sides.add(side6); //Adds the second RadioButton, for how many dices, to the JPanel sides; Option #2 for 6 sides.
        sides.add(side12); //Adds the third RadioButton, for how many dices, to the JPanel sides; Option #3 for 12 sides.

        /*
        This is a single statement that add the play JButton to the JPanel buttons.
         */
        buttons.add(play); //Adds the play Button to the JPanel buttons.
    }

    /**
     * This is the main game() method. It will use the parameters it is given to set up the appropriate game.
     * The game() method creates the game GUI and creates it based on the given parameters.
     * @param dice This will determine how many JLabels are needed depending on how many dices there are in the game.
     *             Each dice will have it's own JLabel and the game method will determine how to populate the JPanel based
     *             on how many dices are chosen.
     * @param sides This will determine how many sides are used to create the each dice object. Depending on
     *              how many sides are chosen, the game will generate the appropriate results. This will not
     *              affect the GUI of the game rather, it will affect the results of each roll().
     */
    private static void game(int dice, int sides){

        /*
        Initializes the JFrame and JPanels that will be used.
        Also initializes dim to get the dimensions of the Users screen size.
         */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //Creates a Dimension object that will store the User's screen size by using the Toolkit.
        JFrame frame = new JFrame("Game Time"); //Creates a new JFrame named frame, with the title 'Game Time', this will be the main GUI for the game(). For JFrame setting see line: 266
        JPanel game = new JPanel(new BorderLayout()); //Creates the game JPanel and sets it to a BorderLayout which will hold other JPanels inside of it.
        JPanel dices = new JPanel(); //Creates a dices JPanel that will hold and display the JLabels for all the dices in the game.
        JPanel buttons = new JPanel(); //Creates a buttons JPanel that will hold and display the Buttons for the game.

        /*
        Creates the JButtons of the buttons JPanel and sets their Text.
         */
        JButton roll = new JButton("Roll"); //Creates a JButton named roll with text: 'Roll'.
        JButton back = new JButton("<<Back"); //Creates a JButton named back with text: '<<Back'.
        JButton skip = new JButton("Skip"); //Creates a JButton named skip with text: 'Skip'.

        /*
        Creates an actionListener for the JButton back. Will listen for mouse click and space press.
        This back button is set to return to the selectDice() GUI so the User can go back to select
        a different game option.
         */
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectDice(); //Calls the selectDice() function which will bring up the selectDice() GUI, basically returning to the selectDice menu.
                frame.dispose(); //Disposes or closes of the current game() GUI now that the selectDice() GUI has been called and created.
            }
        });

        /*
        Adds all the JButtons to the buttons JPanel so that the buttons will be displayed in the game() GUI.
         */
        buttons.add(back); //Adds the back JButton to the buttons JPanel.
        buttons.add(roll); //Adds the roll JButton to the buttons JPanel.
        buttons.add(skip); //Adds the skip JButton to the buttons JPanel.

        /*
        Adds the other two JPanels to the game JPanel. Adds the other two JPanels to the
        game JPanel using BorderLayouts.
         */
        game.add(dices, BorderLayout.NORTH); //Adds the dices JPanel to the North end of the game JPanel.
        game.add(buttons, BorderLayout.SOUTH); //Adds the buttons JPanel to the South end of the game JPanel.

        /*
        Sets the attributes and settings for the frame JFrame which will be the GUI to the game().
         */
        frame.setSize(350, 100); //Sets the frame JFrame to a certain size.
        frame.setResizable(false); //Sets the frame JFrame to be non-resizable.
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2); //Sets the location of the frame JFrame to be at the center of the User's screen.
        frame.setVisible(true); //Sets the frame JFrame to be visible.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Sets what happens to the frame JFrame if closed by the user. Set to Exit on Close
        frame.add(game); //Adds the game JPanel to the frame JFrame. The game JPanel will contain all the components need for the game() GUI.

        /*
        Creates an array of Dice object and JLabels that correspond to how many dices are needed.
         */
        Dice[] arrDice = new Dice[dice]; //Creates an array of Dice objects that will be sized to how many dices are needed.
        JLabel[] arrLabel = new JLabel[dice]; //Creates an array of JLabels that will be sized to how many dices are needed.

        /*
        This loop populates both the arrDice and arrLabel array based on how many dices the user asks for. Populates the Dice array with the correct ammount of Dice objects.
        Also each Dice object is created with the correct amount of sides that the user chose. And populates the JLabel array with labels that will match each dice
        and its dice number. Starting at dice 1 all the way to dice 6.
         */
        for(int i = 0; i < dice; i++){
            arrDice[i] = new Dice(sides);
            arrLabel[i] = new JLabel("Dice " + (i+1) + ": "); //Since the loop starts @ 0 and ends at 1 less than the value we want, we start counting at 1 so we add 1 to the i value.
        }

        for(int i = 0; i < dice; i++){
            dices.add(arrLabel[i]);
        }

        /*
        This switch statement allows the program to check how many dices are in use and update
        the GUI and game depending on how many dices are in use.
         */
        switch(dice){

            case 2:
                dices.add(arrLabel[0]);
                dices.add(arrLabel[1]);
                roll.addActionListener(new ActionListener() {
                    private int x = 0;
                    public void actionPerformed(ActionEvent e) {
                        int roll1 = arrDice[0].roll();
                        int roll2 = arrDice[1].roll();
                        arrLabel[0].setText("Dice 1: " + roll1);
                        arrLabel[1].setText("Dice 2: " + roll2);
                        x++;
                        if (roll1 == roll2) {
                            if(yesNo("Tries: " + x + "\nPlay Again?", "WINNER!!!!")){
                                x = 0;
                                arrLabel[0].setText("Dice 1: ");
                                arrLabel[1].setText("Dice 2: ");
                            }
                            else System.exit(0);
                        }
                    }

                });
                skip.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int x = 0;
                        while(true) {
                            int roll1 = arrDice[0].roll();
                            int roll2 = arrDice[1].roll();
                            arrLabel[0].setText("Dice 1: " + roll1);
                            arrLabel[1].setText("Dice 2: " + roll2);
                            x++;
                            if (roll1 == roll2) {
                                if(yesNo("Tries: " + x + "\nPlay Again?", "WINNER!!!!")){
                                    arrLabel[0].setText("Dice 1: ");
                                    arrLabel[1].setText("Dice 2: ");
                                }
                                else System.exit(0);
                                break;
                            }
                        }
                    }
                });
                break;

            case 4:
                dices.add(arrLabel[0]);
                dices.add(arrLabel[1]);
                dices.add(arrLabel[2]);
                dices.add(arrLabel[3]);
                roll.addActionListener(new ActionListener() {
                    private int x = 0;
                    public void actionPerformed(ActionEvent e) {
                        int roll1 = arrDice[0].roll();
                        int roll2 = arrDice[1].roll();
                        int roll3 = arrDice[2].roll();
                        int roll4 = arrDice[3].roll();
                        arrLabel[0].setText("Dice 1: " + roll1);
                        arrLabel[1].setText("Dice 2: " + roll2);
                        arrLabel[2].setText("Dice 3: " + roll3);
                        arrLabel[3].setText("Dice 4: " + roll4);
                        x++;
                        if (roll1 == roll2 && roll2 == roll3 && roll3 == roll4) {
                            if(yesNo("Tries: " + x + "\nPlay Again?", "WINNER!!!!")){
                                x = 0;
                                arrLabel[0].setText("Dice 1: ");
                                arrLabel[1].setText("Dice 2: ");
                                arrLabel[2].setText("Dice 3: ");
                                arrLabel[3].setText("Dice 4: ");
                            }
                            else System.exit(0);
                        }
                    }

                });
                skip.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int x = 0;
                        while(true) {
                            int roll1 = arrDice[0].roll();
                            int roll2 = arrDice[1].roll();
                            int roll3 = arrDice[2].roll();
                            int roll4 = arrDice[3].roll();
                            arrLabel[0].setText("Dice 1: " + roll1);
                            arrLabel[1].setText("Dice 2: " + roll2);
                            arrLabel[2].setText("Dice 3: " + roll3);
                            arrLabel[3].setText("Dice 4: " + roll4);
                            x++;
                            if (roll1 == roll2 && roll2 == roll3 && roll3 == roll4) {
                                if(yesNo("Tries: " + x + "\nPlay Again?", "WINNER!!!!")){
                                    arrLabel[0].setText("Dice 1: ");
                                    arrLabel[1].setText("Dice 2: ");
                                    arrLabel[2].setText("Dice 3: ");
                                    arrLabel[3].setText("Dice 4: ");
                                }
                                else System.exit(0);
                                break;
                            }
                        }
                    }
                });
                break;

            case 6:
                dices.add(arrLabel[0]);
                dices.add(arrLabel[1]);
                dices.add(arrLabel[2]);
                dices.add(arrLabel[3]);
                dices.add(arrLabel[4]);
                dices.add(arrLabel[5]);
                roll.addActionListener(new ActionListener() {
                    private int x = 0;
                    public void actionPerformed(ActionEvent e) {
                        int roll1 = arrDice[0].roll();
                        int roll2 = arrDice[1].roll();
                        int roll3 = arrDice[2].roll();
                        int roll4 = arrDice[3].roll();
                        int roll5 = arrDice[4].roll();
                        int roll6 = arrDice[5].roll();
                        arrLabel[0].setText("Dice 1: " + roll1);
                        arrLabel[1].setText("Dice 2: " + roll2);
                        arrLabel[2].setText("Dice 3: " + roll3);
                        arrLabel[3].setText("Dice 4: " + roll4);
                        arrLabel[4].setText("Dice 5: " + roll5);
                        arrLabel[5].setText("Dice 6: " + roll6);
                        x++;
                        if (roll1 == roll2 && roll2 == roll3 && roll3 == roll4 && roll4 == roll5 && roll5 == roll6) {
                            if(yesNo("Tries: " + x + "\nPlay Again?", "WINNER!!!!")){
                                x = 0;
                                arrLabel[0].setText("Dice 1: ");
                                arrLabel[1].setText("Dice 2: ");
                                arrLabel[2].setText("Dice 3: ");
                                arrLabel[3].setText("Dice 4: ");
                                arrLabel[4].setText("Dice 5: ");
                                arrLabel[5].setText("Dice 6: ");
                            }
                            else System.exit(0);
                        }
                    }

                });
                skip.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int x = 0;
                        while(true) {
                            int roll1 = arrDice[0].roll();
                            int roll2 = arrDice[1].roll();
                            int roll3 = arrDice[2].roll();
                            int roll4 = arrDice[3].roll();
                            int roll5 = arrDice[4].roll();
                            int roll6 = arrDice[5].roll();
                            arrLabel[0].setText("Dice 1: " + roll1);
                            arrLabel[1].setText("Dice 2: " + roll2);
                            arrLabel[2].setText("Dice 3: " + roll3);
                            arrLabel[3].setText("Dice 4: " + roll4);
                            arrLabel[4].setText("Dice 5: " + roll5);
                            arrLabel[5].setText("Dice 6: " + roll6);
                            x++;
                            if (roll1 == roll2 && roll2 == roll3 && roll3 == roll4 && roll4 == roll5 && roll5 == roll6) {
                                if(yesNo("Tries: " + x + "\nPlay Again?", "WINNER!!!!")){
                                    arrLabel[0].setText("Dice 1: ");
                                    arrLabel[1].setText("Dice 2: ");
                                    arrLabel[2].setText("Dice 3: ");
                                    arrLabel[3].setText("Dice 4: ");
                                    arrLabel[4].setText("Dice 5: ");
                                    arrLabel[5].setText("Dice 6: ");
                                }
                                else System.exit(0);
                                break;
                            }
                        }
                    }
                });
                break;

            default:
                System.err.println("NO DICE?!?!?!");
                break;
        }
    }
}