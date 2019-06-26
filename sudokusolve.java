import java.util.*;


public class sudokusolve{
public static void main (String arg[]){
int sud[][]=new int [10][10];

int k=0,a=0, sl=0, ab=0; 
int x[][][]=new int[10][10][10];
int temp []={0,0,0,0,0,0,0,0,0,0};

System.out.println( "which blck is 1,4"+ whichbl(1, 4));


Scanner s= new Scanner(System.in);
System.out.println("enter the sudoku");
for(int i=1; i<=9; i++){
    for(int j=1; j<=9; j++){
        sud[i][j]=s.nextInt();
    }
}


System.out.println("column :"+sudcheck.column(sud));

x=allpossisudsolu(sud);


System.out.println("value of x");
for(int i=1; i<=9; i++){
    for(int j=1; j<=9; j++){
        for(int ka=1; ka<=9; ka++){
            System.out.print(x[i][j][ka]);
        } System.out.print("   ");
} System.out.println();
 }
 int suda[][]=new int [10][10]; suda=sud;
sud[1]=set9nos(1, sud, suda);
/*sud=solvedsudoku(sud);*/

for(int i=1; i<=9; i++){
for(int j=1; j<=9; j++)
System.out.print(sud[i][j] +" ");  System.out.println(""); 
}  
        }

      

//----------------------------------------------------------------------------------------------------
public static int[][] solvedsudoku(int [][]sud){
    int ab=0,a=0,k,sl, ft=0, nosol=0, moresln=0; 
    int x[][][]=new int[10][10][10];
     
   
   

    
    if(sudcheck.blocks(sud)&& sudcheck.column(sud) && sudcheck.row(sud))
{
   System.out.println("valid sud");
     x= allpossisudsolu(sud);



     System.out.println("value of x");
     for(int i=1; i<=9; i++){
          for(int j=1; j<=9; j++){
              for(int ka=1; ka<=9; ka++){
                  System.out.print(x[i][j][ka]);
               } 
               System.out.print("   ");
          } System.out.println();
    }



    while(sudcontelzero(sud)){a=0; sl=0; 


        //for one solution

        x=allpossisudsolu(sud);
       for(int i=1; i<=9; i++){
           for(int j=1; j<=9; j++){
               if((k=xkcontonly1nz(x[i][j]))!=0){
                   sud[i][j]=k; a=1; x=allpossisudsolu(sud);  
               }
             
           }
       }


       //for more than one or no solution 


       if(a!=1){System.out.println("more than one soln or no solution");

       ft++;
       
      
           for(int i=1; i<=9; i++){
               for(int j=1; j<=9; j++){ // for no soln only      

                   if(containsallzero( x[i][j]) && sud[i][j]==0){ System.out.println("no solutn"); nosol=1; break;}
               
               }
               if(nosol==1) {break;} 
               
           }   
                    
           
            
          if(nosol==1) break;
            else{ moresln=1; break;/*for more solutions  
            sud = formoresolns(sud);*/}
        }       
           }     
           if(moresln==1){
                sud= formoresolns(sud);
                             }                
                  
       
        
     
}
   else { System.out.println("invalid sudoku"); return sud; }    

  
   
   


    return sud;
}

//------------------------------------------------------------------------------------------------------



public static int[][] formoresolns(int[][] sud){
    int i=1; int count=0; int suda[][]=new int [10][10];
    
    for(int ii=1; ii<=9; ii++)
    for(int j=1; j<=9; j++)
        suda[ii][j]= sud[ii][j];


    while (sudcontelzero(sud)){

        while (sudcontelzero(sud[i])){
            sud[i]=set9nos(i, sud, suda); 
            count++; if(count>10){count=0; break; } 
        }

        if(sudcontelzero(sud[i])){
            sud[i]=makesudi0(i, sud, suda);
            i=i-1;
            sud[i]=makesudi0(i, sud, suda);
            i=i-1;
        }
        i++;
        if(i>9) { if(sudcontelzero(sud))System.out.println("no soln by far");   break; }
    }

    return sud;
}

//-----------------------------------------------------------------------------------------------------

public static int[] set9nos(int i, int [][]sud, int [][]suda){
    int x[][][]=new int [10][10][10];
    for(int j=1; j<=9; j++){
        x=allpossisudsolu(sud);
        
        if(suda[i][j]==0){
            sud[i][j]=rand(x[i][j]);
        }
       
    }
    return sud[i];
}

//----------------------------------------------------------------------------------------------------

public static int[] makesudi0(int i, int [][] sud, int[][] suda){
    for(int j=1; j<=9; j++){
        if(suda[i][j]==0) sud[i][j]=0;
    }
    return sud[i];
}


//------------------------------------------------------------------------------------------------------

public static int rand(int x[]){
    Random r= new Random(); int k=0;
    if(containsallzero(x)) return 0;
    while (x[k]==0)
    k=r.nextInt(10);
    return x[k];
    
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
 //now blocks are converted to 2d array ar1[][]   
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
                for(int r=1; r<=9; r++) { rtemp[r]=sud[i][r];      }
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
           
        }// System.out.println("");
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