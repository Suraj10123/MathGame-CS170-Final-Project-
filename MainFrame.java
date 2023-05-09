//CS 170 Lab Project
//By Suraj Patel
//Professor Yong Gao
//Due Date May 17th, 10:00pm
//This lab features a randomized math quiz for children teaching them the basics of addition, subtraction, multiplication, and division along with Jbuttons for yes and No and music in the 
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class MainFrame extends JFrame {
   private LeaderLabel leader;
   private GameField gameField;
   private Score score;
   private boolean check;
   private static int count;
   String name = null;
   public static String name1;
   public MainFrame() {
       super("Math Quiz");
       setSize(900, 900);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       leader = new LeaderLabel();
       gameField = new GameField();
       score = new Score();
       setLayout(null);
      JButton Yes = new JButton("Yes");
      //ImageIcon(getClass().getResource("C:\Users\suraj_000\Desktop\Lab 2\MathGameFinal"); 
      Yes.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
               check = GameModel.checkAnswer();
               if (check) {
                   score.incCorrect();
                   score.repaint();
                   gameField.repaint();
                   count++;
               } else {
                   score.incWrong();
                   score.repaint();
                   gameField.repaint();
                   count++;
               }
               //Shows a game over screen if more than 5 answers are incorrect
               if (Score.getWrong() > 5) { 
                   JOptionPane.showMessageDialog(null, "Game Over! Thank For Playing!");
                   score.reset();
                   score.repaint();
                   count = 0;
                   gameField.repaint();
               }
           }
       });
       JButton No = new JButton("No");
       //ImageIcon(getClass().getResource("C:\Users\suraj_000\Desktop\Lab 2\MathGameFinal");
       No.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               check = GameModel.checkAnswer();
               if (check) {
                   score.incWrong();
                   score.repaint();
                   gameField.repaint();
                   count++;
               } else {
                   score.incCorrect();
                   score.repaint();
                   gameField.repaint();
                   count++;
               }
               if (Score.getWrong() > 5) {
                   JOptionPane.showMessageDialog(null, "Game Over.");
                   score.reset();
                   count = 0;
                   gameField.repaint();
               }
           }
       });
       Yes.setBounds(140, 305, 80, 37);
       add(Yes);
       No.setBounds(240, 305, 80, 37);
       add(No);
       leader.setBounds(480, 0, 220, 340);
       add(leader);
       score.setBounds(0, 0, 482, 40);
       add(score);
       gameField.setBounds(0, 40, 480, 255);
       add(gameField);
       JMenuBar mb = new JMenuBar();
       setJMenuBar(mb);
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
       JMenuItem howToPlay = new JMenuItem("How To Play");
       help.add(howToPlay);
       final String howTo = 
    		    "For Example if we have: 5/7, the result will be 0, and any result less than 1 will result in a wrong answer"
               + "Another example: 10/3 = 3, 15/4 = 3, 20/3 = 6 etc.";
       howToPlay.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               JOptionPane.showMessageDialog(null, howTo);
           }
       });
       JMenuItem about = new JMenuItem("About");
       help.add(about);
       about.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               JOptionPane
                       .showMessageDialog(
                               null,
                               "Welcome to the Math Game! This game will teach you how to add, multiply. divide and subtract! The rules are simple, answer the question with one of the buttons and see how high you can score! Have fun!");
           }
       });
   }
   public static int getCount() {
       return count;
   }
   public static void main(String[] args) {
       new MainFrame();
   }
}
