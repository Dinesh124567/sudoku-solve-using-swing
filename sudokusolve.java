import java.util.*;


public class sudokusolve{

    public static int sudokustus=1;  //1 one solution, 2 more than sln, 3 no solution, 4 invalid sudoku
    public static void main (String arg[]){
        int a[]={1,0,0,9,0,0,0,0,8,0};
        System.out.println("checking last"+last(a));
        System.out.println("checking fst"+first(a));
        System.out.println("ch next"+next(a, 9));

        }

//----------------------------------------------------------------------------------------------------

    public static int[][] solvedsudoku(int [][]sud){
        int a=0,k, moresln=0; 
        int x[][][]=new int[10][10][10];
     
        sudokustus=1;   
        if(sudcheck.blocks(sud)&& sudcheck.column(sud) && sudcheck.row(sud) && sudcheck.numbers(sud))
        {
            System.out.println("valid sud");
            x= allpossisudsolu(sud);

            while(sudcontelzero(sud)){a=0; 
            //for one solution
                x=allpossisudsolu(sud);
                for(int i=1; i<=9; i++){
                    for(int j=1; j<=9; j++){
                        if((k=xkcontonly1nz(x[i][j]))!=0){
                            sud[i][j]=k; a=1; x=allpossisudsolu(sud);  
                        } 
                    }
                } sudokustus=1;

                if(a!=1){System.out.println("more than one soln or no solution");
                    moresln=1; break;
                }       
            }

            if(moresln==1){ sudokustus=2;
                int suda[][]=new int [10][10]; 
                for(int ii=1; ii<=9; ii++)
                    for(int j=1; j<=9; j++)
                        suda[ii][j]= sud[ii][j];

                for(int i=1; i<=9; i++){if(sudokustus==3)break;
                    for(int j=1; j<=9; j++){if(sudokustus==3)break;
                        if(suda[i][j]==0)  {
                            x=allpossisudsolu(sud);
                            if(containsallzero(x[i][j])){
                                try{sud=formoresolns(suda,sud,i,j);}
                                catch(Exception e){System.out.println("nosln");sudokustus=3;} 
                            }
                            else{
                                sud[i][j]=first(x[i][j]);
                            }
                        }  
                    }
                }
            }                   
     
        }
        //1 one solution, 2 more than sln, 3 no solution, 4 invalid sudoku
        else { System.out.println("invalid sudoku"); sudokustus=4; System.out.println("sudoku status: "+ sudokustus);  return sud; }    
        System.out.println("sudoku status: "+ sudokustus); 

        return sud;
    }

//------------------------------------------------------------------------------------------------------

    public static int[][] formoresolns(int suda[][],int[][] sud,int a, int b){

        int aa=a,bb=b; 
        bb--; if(bb<1){aa--; bb=9;}

        while(sud[aa][bb]==last(check(sud, aa, bb))||suda[aa][bb]!=0){
            if(suda[aa][bb]==0)sud[aa][bb]=0;
                bb--; if(bb<1){bb=9; aa--;}
        }
        sud[aa][bb]=next(check(sud, aa, bb), sud[aa][bb]);
        int ca=((a-1)*9)+b;
        int caa=((aa-1)*9)+bb;
   
        while(caa<ca){
            bb++; if(bb>9){bb=1; aa++;} caa++;
            if(suda[aa][bb]==0){while(containsallzero(check(sud, aa, bb))) formoresolns(suda, sud, aa, bb);
            sud[aa][bb]=first(check(sud, aa, bb));}  
        }
        return sud;
    }

//-----------------------------------------------------------------------------------------------------

    static int next(int ar[], int s){
        if(s==0)return first(ar);
        for (int i=1; i<=9; i++){if(ar[i]==s){ar[i]=0; return first(ar);} ar[i]=0;} 
        return 0;
    }

    static int last(int ar[]){
        for(int i=9; i>=1; i--)if(ar[i]!=0)return ar[i];
        return 0;
    }

    static int first(int ar[]){
        for(int i=1; i<=9; i++) if(ar[i]!=0)return ar[i];
        return 0;
    }
//----------------------------------------------------------------------------------------------------

    static int []check(int [][] sud, int a, int b){
        int s=sud[a][b]; sud[a][b]=0;
        int x[][][]=new int[10][10][10];
        x=allpossisudsolu(sud);
        sud[a][b]=s;
        return x[a][b];
    }

//----------------------------------------------------------------------------------------------------

    public static boolean containsallzero(int x[]){
        for(int i=1; i<=9; i++){
            if(x[i]==0) continue;
            else return false;
        }
        return true;
    }

//----------------------------------------------------------------------------------------------------

    public static int[][] blocks(int sud[][]){
        int b,a=0,X=0; 
        int ar[][][]=new int [10][4][4];
        int ar1[][]=new int[10][10];
 
        for (int A=1;A<=3;A++){b=0;
            for(int B=1;B<=3;B++){X=X+1;
                for(int i=1;i<=3; i++){
                    for (int j=1; j<=3; j++){
                        ar[X][i][j]=sud[a+i][b+j];
                    }
                }b=b+3;
            }a=a+3;
        }
      //now blocks are stored in 3d array ar[][][]
        for(int x=1; x<=9;x++){b=0;
            for (int i=1;i<=3;i++){
                for(int j=1;j<=3;j++){
                ar1[x][b+j]= ar[x][i][j];
                } b=b+3;
            }
        }
 
        return ar1;
    }

//---------------------------------------------------------------------------------------------------  

    public static int[][][] allpossisudsolu(int sud [][]){
        int rtemp[]=new int[10]; int ctemp[]=new int[10]; int btemp[]=new int[10];
        int rtemp1[]=new int[10]; int ctemp1[]=new int[10]; int btemp1[]=new int[10];
        int x[][][]=new int[10][10][10];
        x[0][0][0]=0; rtemp[0]=0; ctemp[0]=0; btemp[0]=0;rtemp1[0]=0; ctemp1[0]=0; btemp1[0]=0;
        for(int ii=1; ii<=9; ii++){
            for(int jj=1; jj<=9; jj++){
                for(int ka=1; ka<=9; ka++){x[ii][jj][ka]=0;}}}

        for(int i=1; i<=9; i++){
            for(int j=1;j<=9; j++){
                if(sud[i][j]!=0) continue;
                else {
                    for(int r=1; r<=9; r++)  rtemp[r]=sud[i][r]; 
                    for(int c=1; c<=9; c++) ctemp[c]=sud[c][j];
                    for(int b=1;b<=9; b++) btemp[b]=blocks(sud)[whichbl(i,j)][b];

                    for(int te=1;te<=9;te++){
                        if(isconsist(rtemp,te)) rtemp1[te]=0;
                        else rtemp1[te]=te;
                        if(isconsist(ctemp,te)) ctemp1[te]=0;
                        else ctemp1[te]=te;
                        if(isconsist(btemp,te)) btemp1[te]=0;
                        else btemp1[te]=te;
                    }

                    for(int a=1; a<=9; a++){     
                        if(rtemp1[a]==ctemp1[a] && ctemp1[a]==btemp1[a]){
                            if(rtemp1[a]!=0) x[i][j][a]=rtemp1[a];
                        }
                    } 
                }
            }
        }
        return x;
    }

//-------------------------------------------------------------------------------------------

    public static int whichbl(int i,int j){
        int b=1;
        for(int a=1; a<=3; a++){
            if(i==b || i==b+1 || i==b+2){
                if(j==1||j==2||j==3) return b;
                else if(j==4||j==5||j==6) return b+1;
                else if(j==7||j==8||j==9) return b+2; 
            }
            b=b+3;
        }
        return 0;
    }

//------------------------------------------------------------------------------------------------

    public static  boolean isconsist(int ar[],int a ){
        for(int i=1; i<=9; i++){
            if(ar[i]==a) return true;
        }
        return false;
    }

//--------------------------------------------------------------------------------------------------

    public static boolean sudcontelzero(int sud[][]){
        for(int i=1;i<=9; i++){
            for(int j=1;j<=9; j++){
                if( sud[i][j]==0) return true;
            }
        }
        return false;
    }

//--------------------------------------------------------------------------------------------------

    public static boolean sudcontelzero(int sud[]){
        for(int i=1;i<=9; i++){
            if( sud[i]==0) return true;
        }
        return false;
    }

//--------------------------------------------------------------------------------------------------

    public static int xkcontonly1nz(int x[]){
        int a=0,I=0;
        for(int i=0; i<=9; i++){
            if(x[i]!=0){a=a+1; I=i;}
            else continue;
        }
        if(a==1) return x[I];
        else return 0;
    }

}