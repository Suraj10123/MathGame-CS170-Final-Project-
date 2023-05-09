//CS 170 Lab Project
//By Suraj Patel
//Professor Yong Gao
//Due Date May 17th, 10:00pm
//This lab features a randomized math quiz for children teaching them the basics of addition, subtraction, multiplication, and division along with Jbuttons for yes and No and music in the background as well
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton; 
import sun.audio.AudioPlayer;
public class StartFrame extends JPanel {
 private JRadioButton Start;
private JRadioButton Exit;
   public StartFrame() {
       Start = new JRadioButton("Start");
       Exit = new JRadioButton("Exit");
       JButton play = new JButton("Play");
       play.setBounds(285, 290, 85, 40);
       play.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new MainFrame();
           }
       });
       add(play);
   }
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
       int width = 700;
       int height = 400;
       g.setColor((new Color(230, 235, 240)));
       g.fillRect(0, 0, width, height);
       g.setColor(Color.BLUE);
       g.fillRect(width / 4, height / 5, width / 2, height / 3);
       g.setColor(Color.black);
       g.setColor(Color.white);
       Font font = new Font("Arial Narrow", Font.TRUETYPE_FONT, 55);
       g2.setFont(font);
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
       g.drawString("Math", 3 * width / 7, 4 * height / 12);
       g.drawString("Quiz", 3 * width / 7, 4 * height / 9);
   }
   public static void main(String[] args) {
       StartFrame panel = new StartFrame();
       JFrame frame = new JFrame("Math Quiz");
       JMenuBar mb = new JMenuBar();
       frame.setJMenuBar(mb);
       JMenu file = new JMenu("File");
       mb.add(file);
       JMenuItem exit = new JMenuItem("Exit");
       file.add(exit);
       exit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               System.exit(0);
           }
       });
       JMenu help = new JMenu("Help");
       mb.add(help);
       JMenuItem about = new JMenuItem("About");
       help.add(about);
       about.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               JOptionPane
                       .showMessageDialog(
                               null,
                               "Welcome to the Math Quiz!  This program will help young children(and adults!) learn the basic fundamentals of mathamatics. The equations along with answers will show up in a window with a y/n option and a score tracker at the top of window.");
           }
       });
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(panel);
       frame.setSize(700, 400);
       frame.setVisible(true);
   }
   //Adds music to jframe
   //public static void music() {
	 //  AudioPlayer MGP = AudioPlayer.player;
	   //AudioStream BGM;
	   //AudioData MD;
	   //ContinuousAudioDataStream loop = null;
	   //try {
		 //  BGM = new AudioStream(new FileInputStream("C:\\Users\\suraj_000\\Desktop\\Lab 2\\MathGameFinal"));
		   //MD = BGM.getData();
		   //loop = new ContinuousAudioDataStream(MD));
		   //catch(IOException error)
		   //{ System.out.print("file not found");
}
