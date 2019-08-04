import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Eventing {
    Eventing(){
        JFrame f=new JFrame("sudoku solver, backtrack");
        JTextField[][] Tf=new JTextField[10][10];
        JTextField st=new JTextField("status");

        f.setLayout(new GridLayout(10,9));
        f.setSize(260,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        for(int i=1;i<=9;i++){
            for(int j=1; j<=9; j++){
                 Tf[i][j]= new JTextField();
                 f.add(Tf[i][j]);
            }
        }
        JButton b=new JButton("solve");
        JButton b1=new JButton("clr");
        
        f.add(b);
        f.add(b1);
        f.add(st);
       
        b.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                int sudb[][]=new int[10][10];
                int suda[][]=new int[10][10];
                for(int i=1;i<=9; i++){
                    for (int j=1; j<=9; j++){
                        try{if((Tf[i][j].getText())=="") sudb[i][j]=0;
                            else{sudb[i][j]=Integer.parseInt(Tf[i][j].getText()) ; } }
                        catch(Exception ee){
                                           }
                    }
                }        
                suda=sudokusolve.solvedsudoku(sudb);
                int a=sudokusolve.sudokustus;
                switch(a){
                    case 1: st.setText("one soln"); break;
                    case 2: st.setText("more solutions"); break;
                    case 3: st.setText("no solution"); break;
                    case 4: st.setText("invalid sud"); break;
                    default: st.setText("error:"+a);
                }
                for(int i=1;i<=9; i++){
                    for (int j=1; j<=9; j++){
                        if(suda[i][j]==0)  Tf[i][j].setText("");
                        else Tf[i][j].setText(""+suda[i][j]);
                    }
                }
            }
        });

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                for(int i=1;i<=9; i++)
                    for (int j=1; j<=9; j++) Tf[i][j].setText("");
                st.setText("");    
            }
        });

        
    }

    public static void main(String []ar){
        SwingUtilities.invokeLater(new Runnable(){
        public void run (){ new Eventing();}});
}}