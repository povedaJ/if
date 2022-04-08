/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Equipo
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void reduce(int n) {
        while (n != 0) {
            System.out.println(n);
            n = n - 2;
        }
    }

    public static void reduce2(int n) {
        if (n != 0) {
            //System.out.println(n);
            reduce2(n - 2);
        }
    }

    public static void recorreFila(int[][] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void recorreFila2(int[][] tabla) {
        for (int k = 0; k < tabla.length * tabla[0].length; k++) {
            System.out.println(tabla[k / tabla[0].length][k % tabla[0].length]);
        }
    }

    public static void recorreCol2(int[][] tabla) {
        for (int k = 0; k < tabla.length * tabla[0].length; k++) {
            System.out.println(tabla[k % tabla.length][k / tabla.length]);
        }
    }

    public static void transpuesta(int[][] tabla) {
        int temp;
        for (int i = 0; i < tabla.length - 1; i++) {
            for (int j = i + 1; j < tabla[0].length; j++) {
                // intercambiar tabla[i][j] con tabla[j][i]
                temp = tabla[i][j];
                tabla[i][j] = tabla[j][i];
                tabla[j][i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        //reduce(10);
        //reduce2(11);
        int[][] tabla = {{1, 2, 3},
        {4, 5, 6}};

//        recorreCol2(tabla);
        int[][] tabla2 = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};

        // transpuesta(tabla2);
        //recorreFila(tabla2);
        // 
        int[][][] arreglo3D = {
            {{1, 2, 3}, {4, 5, 6}},
            {{7, 8, 9}, {10, 11, 12}},
            {{13, 14, 15}, {16, 17, 18}}
        };

        //recorre3D(arreglo3D);
        //recorre3D2(arreglo3D);
        int[] a = {1,0,0,0,1,1,1,0};
        //intTB(a);

        //intTB(a);
        System.out.println(empaquetaB(a));

    }

    public static void recorre3D(int[][][] array) {

        for (int i = 2; i >= 0; i--) {
            for (int e = 0; e < array[0].length; e++) {
                for (int o = 0; o < array[0][0].length; o++) {
                    System.out.println(array[o][e][i]);

                }
            }
        }
    }

    public static void recorre3D2(int[][][] array) {

        for (int i = 1; i >= 0; i--) {
            for (int e = 2; e >= 0; e--) {
                for (int o = 0; o < array[0][0].length; o++) {
                    System.out.println(array[e][i][o]);

                }
            }
        }
    }

    public static void intTB(int[] arrayA) {

        byte x = 0;
        String n = "";
        int e = 0;

        for (int i = arrayA.length; i >= 0; i--) {
            if (arrayA[i] != 0) {
                e = i;
                i = 0;

            }
        }
        for (int o = e - 1; o >= 0; o--) {
            if (arrayA[o] == 0) {
                arrayA[o] = 1;

            } else {
                arrayA[0] = 0;
            }

        }
        n = arrayA.toString();

        System.out.println(n);
    }

    public static byte empaquetaB(int[] arrayA) {
        int y;
        short x = 0;
        short mascara = 128;
        

        for (int i = 0; i < arrayA.length; i++) {

            if (arrayA[i] == 1) {
                y = mascara | x;
                x = (short) y;
            }
            y = mascara >> 1;
            mascara = (short)y;
        }
        return (byte)x;
    }
}
