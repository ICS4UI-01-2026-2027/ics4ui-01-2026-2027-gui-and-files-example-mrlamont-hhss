import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.swing.*;

/**
* Creates the main screen that displays everything
* @author Mr. Lamont
*/
public class MainScreen extends JFrame{

    private JPanel mainPanel;
    private JButton up, down, left, right;
    private JTextField description;
    private PicturePanel picture;

    public MainScreen(){
        // makes a panel and sets it to be a border layout
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());

        // create all the buttons
        this.up = new JButton("UP");
        this.down = new JButton("DOWN");
        this.right = new JButton("RIGHT");
        this.left = new JButton("LEFT");

        // create the picture panel
        this.picture = new PicturePanel();

        // create the description
        this.description = new JTextField();


        // create a panel to add both down and the desciption
        JPanel bottom = new JPanel();
        // grid layout of 2 rows by 1 column
        bottom.setLayout(new GridLayout(2,1));
        // add the button and description to the bottom
        bottom.add(this.down);
        bottom.add(this.description);

        // put all the components on the panel
        this.mainPanel.add(this.up, BorderLayout.PAGE_START);
        this.mainPanel.add(this.right, BorderLayout.LINE_END);
        this.mainPanel.add(bottom, BorderLayout.PAGE_END);
        this.mainPanel.add(this.left, BorderLayout.LINE_START);
        this.mainPanel.add(this.picture, BorderLayout.CENTER);

        // set the preferred size of the panel
        this.mainPanel.setPreferredSize(new Dimension(800, 600));

        // put the panel on the frame
        this.add(this.mainPanel);
        // pack the frame to automatically size it
        this.pack();
        // make sure the window is visible
        this.setVisible(true);
        // make the red X do what you think it should do
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionListener(Controller c){
        // set the command on every button
        this.up.setActionCommand("up");
        this.down.setActionCommand("down");
        this.right.setActionCommand("right");
        this.left.setActionCommand("left");

        // add the link from the button to the controller
        this.up.addActionListener(c);
        this.down.addActionListener(c);
        this.right.addActionListener(c);
        this.left.addActionListener(c);
    }

    public void setDescription(String text){
        // textbox should show the new text
        this.description.setText(text);
    }

    public void setPicture(BufferedImage img){
        // put the image on the picture panel
        this.picture.setImage(img);
    }



}
