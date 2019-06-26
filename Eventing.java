import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Eventing {
    Eventing(){
        JFrame f=new JFrame("hi there , working!");
        JTextField[][] Tf=new JTextField[10][10];
        


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
        JButton b=new JButton("click to solve");
        f.add(b);
        b.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                int sudb[][]=new int[10][10];
                int suda[][]=new int[10][10];
                for(int i=1;i<=9; i++){
                    for (int j=1; j<=9; j++){
                        try{if((Tf[i][j].getText())=="") sudb[i][j]=0;
                            else{sudb[i][j]=Integer.parseInt(Tf[i][j].getText()) ; } }
                        catch(Exception ee){//System.out.println("error"+ee);
                                           }
                    }
                }        
                 suda=sudokusolve.solvedsudoku(sudb);

                 for(int i=1;i<=9; i++){
                    for (int j=1; j<=9; j++){
                        Tf[i][j].setText(""+suda[i][j]);
                    }}
            }
        });

      
    }

    public static void main(String []ar){
        SwingUtilities.invokeLater(new Runnable(){
        public void run (){ new Eventing();}});
}}