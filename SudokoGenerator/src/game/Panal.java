package game;

import game.Sudoku;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Panal extends javax.swing.JPanel {

    Sudoku game;
    public Timer timer;
    private JButton btnNGame = new JButton("new game");
    public static JTextField[][] boxes;
    public JPasswordField password = new JPasswordField("1234");
    public JLabel label = new JLabel("     Timer :00 : 00 : 00");
    public JLabel passLabel = new JLabel("            Your Password :");
    public JPanel[][] paneles;
    public JPanel center, buttonPanel;
    public JButton btnNewGame, btnSolveGame, btnExit, btnHard, btnMid, BtnEasy, btnSolve, btnAbout, btnSave, btnDeleteAcc, btnMyprogress; // define all buttons in a single lne
    public int[][] temp = new int[9][9];
    public int[][] grid = new int[9][9];
    public int counter = 0;

    public JTextField newtextfield() {
        JTextField txtJ = new JTextField("");
        txtJ.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        txtJ.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        txtJ.setHorizontalAlignment(JTextField.CENTER);

        /*-------------------mouse lisner----------------*/
        txtJ.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (txtJ.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.decode("#f6ea80")));
                    ((JTextField) e.getSource()).setBackground(Color.decode("#d8d8d8"));
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (txtJ.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.lightGray));
                    ((JTextField) e.getSource()).setBackground(Color.white);
                }
            }
        });
        /*------------------------------------------------*/

        txtJ.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (txtJ.isEditable()) {
                    ((JTextField) e.getSource()).setForeground(Color.decode("#0c4"));
                } else {
                    ((JTextField) e.getSource()).setForeground(Color.black);
                }
            }
        });
        return txtJ;
    }

    public Panal() {
        initComponents();
        /*------------------------main panal  -------------------------------------*/

        center = new JPanel();  //main panel
        center.setLayout(new GridLayout(3, 3));     //grid for 3*3 
        center.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(center);  //add main panel to frame 

        boxes = new JTextField[9][9];
        paneles = new JPanel[3][3];
        passLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        passLabel.setForeground(Color.black);
        label.setForeground(Color.black);
        // label.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        // label.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paneles[i][j] = new JPanel();
                paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                paneles[i][j].setLayout(new GridLayout(3, 3));
                center.add(paneles[i][j]);
            }
        }
        /*------------------------text fildes in boxes-------------------------------------*/

        for (int n = 0; n < 9; n++) {
            for (int i = 0; i < 9; i++) {
                boxes[n][i] = newtextfield();
                int fm = (n + 1) / 3;
                if ((n + 1) % 3 > 0) {
                    fm++;
                }
                int cm = (i + 1) / 3;
                if ((i + 1) % 3 > 0) {
                    cm++;
                }
                paneles[fm - 1][cm - 1].add(boxes[n][i]);   //add box to panel 
            }
        }
        /*------------------------panal for buttons -------------------------------------*/

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#c19a6b"));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 6, true));
        // buttonPanel.setLayout(new GridLayout(4, 3, 0, 20));
        buttonPanel.setLayout(new GridLayout(5, 3, 0, 20));


        /*------------------------panal for new game button -------------------------------------*/
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                label.setText(TimeFormat(counter));
                counter++;

            }
        };

        /*------------------------Panal For New Game Button-------------------------------------*/
        btnNewGame = new JButton("New Game");
        btnNewGame.setSize(20, 50);
        timer = new Timer(1000, action);
        btnNewGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                counter = 0;
                Sudoku.setlevel(3);
                timer.start();
                restgame();
                Sudoku.newGame();
                System.out.println("New Game actionPerformed()");
            }

        });

        /*------------------------panal for Solve Game button -------------------------------------*/
        btnSolveGame = new JButton("Solve Game");

        btnSolveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!boxes[i][j].isEditable()) {
                            continue;
                        } else if (boxes[i][j].getText().equals(String.valueOf(grid[i][j]))) {
                            //  boxes[i][j].setBackground(Color.decode("#C0DCD9"));
                            boxes[i][j].setBackground(Color.WHITE);
                        } else if (boxes[i][j].getText().isEmpty()) {
                            boxes[i][j].setBackground(Color.WHITE);
                            continue;
                        } else {
                            boxes[i][j].setBackground(Color.decode("#a7efba"));
                        }
                    }
                }
                counter += 30;
            }
        });
        /*------------------------panal for new Exit button -------------------------------------*/
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to EXIT?", "Exit", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    System.exit(0);
                }
            }
        });

        /*------------------------panal for new Hard button -------------------------------------*/
        btnHard = new JButton("Hard 10%");
        btnHard.setBackground(Color.decode("#f4776e"));
        btnHard.setForeground(Color.BLACK);

        btnHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(4);
                Sudoku.newGame(); //Inheritance
            }
        });
        /*-----------------------------------------------------------------------------------------*/

 /*------------------------panal for new Mideum button -------------------------------------*/
        btnMid = new JButton("Mideum 25%");
        btnMid.setBackground(Color.decode("#acc613"));
        btnMid.setForeground(Color.BLACK);

        btnMid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(3);
                Sudoku.newGame();

            }
        });

        /*-----------------------------------------------------------------------------------------*/

 /*------------------------panal for new Easy button -------------------------------------*/
        BtnEasy = new JButton("Easy 50%");
        BtnEasy.setBackground(Color.decode("#0bc682"));
        BtnEasy.setForeground(Color.BLACK);

        BtnEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(2);
                Sudoku.newGame();
            }
        });

        /*------------------------------panal for Solve Require Password button -------------------------------*/
        btnSolve = new JButton("< Solve Require Password ");

        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password.getText().equals("1234")) {
                    timer.stop();
                    counter = 0;
                    label.setText(TimeFormat(counter));
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            boxes[i][j].setText(String.valueOf(grid[i][j]));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(center, "Wrong Password");
                }
            }
        });
        /*------------------------panal for About button -------------------------------------*/
        btnAbout = new JButton("About");

        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(center, "Sudoko Generator"+"\nDefault Password : 1234"+"\n\nFor Auto Solve The Game First Input Password and Fill Atleast Few Box.");
            }
        });

        /*------------------------panal for Save button -------------------------------------*/
        btnSave = new JButton("Save");

        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(center, "Game Saved !!");
            }
        });

        /*------------------------panal for Delete Account button -------------------------------------*/
        btnDeleteAcc = new JButton("Delete Account");

        btnDeleteAcc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(center, "Go To Player Dashboad For Delete Account.");
            }
        });

        /*------------------------panal for Myprogress  Account button -------------------------------------*/
        btnMyprogress = new JButton("My Progress");

        btnMyprogress.addActionListener(new ActionListener() {

            // Dipu, Need to chnage some code here
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Go To Dashboard For Check Your Progress.");
            }
        });
        //btnMyprogress

        /*------------------------panal for Password Field -------------------------------------*/
        password.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ((JPasswordField) e.getSource()).setText("");
            }
        });

        /*------------------------add button panal and butons to frame and panel -------------------------------------*/
        buttonPanel.add(btnHard);   //add new game button to 
        buttonPanel.add(btnMid);
        buttonPanel.add(BtnEasy);
        buttonPanel.add(btnNewGame);   //add new game button to 
        buttonPanel.add(btnSolveGame);
        buttonPanel.add(btnExit);
        buttonPanel.add(passLabel);
        buttonPanel.add(password);
        buttonPanel.add(btnSolve);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnAbout);
        buttonPanel.add(btnDeleteAcc);
        buttonPanel.add(btnMyprogress);
        buttonPanel.add(label);

        add(buttonPanel, "South");   //add button panel to frame 

    }

    public void setarray(int[][] grid, int[][] temp) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.temp[i][j] = temp[i][j];
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public void setTextLable() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.temp[i][j] != 0) {
                    boxes[i][j].setText(String.valueOf(this.temp[i][j]));
                    boxes[i][j].setEditable(false);
                    boxes[i][j].setBackground(Color.decode("#fffcfe"));
                    boxes[i][j].setForeground(Color.RED);
                } else {
                    boxes[i][j].setText("");
                }
            }
        }
    }

    public static void restgame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxes[i][j].setForeground(Color.BLACK);
                boxes[i][j].setEditable(true);
                boxes[i][j].setBackground(Color.WHITE);
            }
        }
    }

    public String TimeFormat(int count) {

        int hours = count / 3600;
        int minutes = (count - hours * 3600) / 60;
        int seconds = count - minutes * 60;

        return String.format("      Timer :" + "%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
