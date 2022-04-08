
package lab0.repaso;

public class Ejercicios {
       public void stackverflow(int n){
           if(n!=0){
             n=n-2;
             stackverflow(n); 
           }   
            
        }
        
        public void linea3(){
            byte y = -70;
            short x = y;
            
            System.out.println(x);
            // al poner un byte a short, deja el resto de espacios en "1" entonces queda negativo
               
        }
        public void ejercicioE(){
            short y= -256;
            byte x= (byte) y;
            System.out.println(x);
            // al forzar un short a ser un byte, agarra el primer byte del short y lo imprime, y al ser este primer byte puros "0", imprime un cero.
        }
        
        public boolean sudoku(int i, int k, int j){
            
           // int matriz[][] = new int[9][9];
           
            int matriz[][]= {{0,6,2,0,7,0,0,0,0},
                     {0,0,0,0,0,0,0,0,6},
                     {0,4,0,6,9,1,0,7,0},
                     {8,0,1,0,2,9,6,0,0},
                     {0,9,0,0,0,7,8,0,0},
                     {0,0,0,8,6,3,5,0,0},
                     {3,0,0,0,8,0,0,0,0},
                     {0,2,7,0,0,0,0,6,0},
                     {0,1,0,0,5,0,0,4,0}};
              while(matriz[i][k]!=matriz[k][j]){
                
            }
          return  ;
        }
            
          
        }
