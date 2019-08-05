
//package chintu;

import java.util.*;
public class sudcheck{
 public static void main(String args[]){
   
    }

public static boolean numbers(int ar[][]){
  for(int i=1; i<=9; i++){
    for(int j=1; j<=9; j++){
      if(ar[i][j]>9||ar[i][j]<0) return false;
    }
  }
  return true;
}


public static boolean row(int arr[][]){
 for (int a=1; a<=9; a++){
   for (int i=1; i<=9; i++){
     for(int j=i+1; j<=9; j++){
        if(arr[a][i]!=arr[a][j] || arr[a][i]==0 || arr[a][j]==0) continue;
        else return false;
                           }}}
return true;
}


public static boolean column(int arr[][]){
  for (int a=1; a<=9; a++){
      for (int i=1; i<=9; i++){
        for(int j=i+1; j<=9; j++){
              if(arr[i][a]!=arr[j][a] || arr[a][i]==0 || arr[j][a]==0) continue;
              else return false;
        }
      }
  }
  return true;
 }


 public static boolean blocks(int sud[][]){
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

return row(ar1);

 }
} 