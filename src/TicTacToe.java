import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*; //package providing an interface to display the game
public class TicTacToe implements ActionListener
{
    Random random = new Random(); //creating an instance of random class to choose who will start
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel restart_panel = new JPanel();
    JPanel mid_panel = new JPanel();
    JPanel left_panel = new JPanel();
    JPanel right_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton restartButton = new JButton("New Game");
    boolean player1_turn; //will be true if player1 starts or false if player2 starts


    TicTacToe() //constructor
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(27,111,153));
        textfield.setForeground(new Color(6,83,6));
        textfield.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        left_panel.setLayout(new BorderLayout());
        left_panel.setBounds(0,100,100,600);
        left_panel.setBackground(new Color(27,111,153));

        right_panel.setLayout(new BorderLayout());
        right_panel.setBounds(700,100,100,600);
        right_panel.setBackground(new Color(27,111,153));

        mid_panel.setLayout(new BorderLayout());
        mid_panel.setBounds(100,100,600,600);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        restart_panel.setLayout(new BorderLayout());
        restart_panel.setBounds(0,700,800,100);
        restart_panel.setBackground(new Color(27,111,153));


        for(int i =0; i < 9; i++)//create the buttons to place X or O
        {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("DejaVu Sans Mono", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        mid_panel.add(button_panel);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(left_panel);
        frame.add(right_panel);
        frame.add(mid_panel);
        frame.add(restart_panel);



        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) //unimplemented methods
    {
        for(int i = 0; i < 9; i++)//checking each of our buttons
        {
            if(e.getSource()==buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setBackground(new Color(255,0,0));
                        buttons[i].setForeground((new Color(45,45,45)));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O Turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setBackground(new Color(0,0,255));
                        buttons[i].setForeground((new Color(45,45,45)));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() //method to choose who will start
    {
        try {
            Thread.sleep(5000); //Set a delay to show the title first before the updated messages
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        if(random.nextInt(2)==0)
        {
            player1_turn = true;
            textfield.setText("X turn");
        }
        else
        {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() //check win conditions both for X and O
    {
        //check if X wins
        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
          )
        {
            xWins(0,1,2);
            for(int i = 0; i<9;i++)
            {
                buttons[i].setEnabled(true);
                buttons[i].setText("");
            }

        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        )
        {
            xWins(3,4,5);

        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        )
        {
            xWins(6,7,8);

        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        )
        {
            xWins(0,3,6);

        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        )
        {
            xWins(1,4,7);

        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        )
        {
            xWins(2,5,8);

        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        )
        {
            xWins(0,4,8);

        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        )
        {
            xWins(2,4,6);

        }

        //check if O wins
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        )
        {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        )
        {
            oWins(3,4,5);

        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        )
        {
            oWins(6,7,8);

        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        )
        {
            oWins(0,3,6);

        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        )
        {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        )
        {
            oWins(2,5,8);

        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        )
        {
            oWins(0,4,8);

        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        )
        {
            oWins(2,4,6);

        }
    }

    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins !");
    }

    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins !");
    }


}
