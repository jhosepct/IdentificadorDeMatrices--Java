package Algoritmia.Array;

import java.util.Scanner;

public class identificadorDeMatrices {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int valor = 0;
        welcome();
        while(valor != 2){
            try{
                valor = menu();
                switch (valor){
                    case 1:
                        body();
                        break;
                    case 2:
                        good_bye();
                        break;
                    default:
                        System.out.println("Digite 1 o 2");
                        break;
                }
            }catch(Exception e){
                System.out.println("Digite un número");
                entrada.next();
            }
        }
    }
    public static void welcome(){
        System.out.println("******************************************");
        System.out.println("********                          ********");
        System.out.println("** ---  Identificación de matrices  --- **");
        System.out.println("********                          ********");
        System.out.println("******************************************");
    }
    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        int valor;
        System.out.println("\n-------------------Menu-------------------");
        System.out.println("\n\t\t1. Consultar | 2. Salir");
        System.out.print("> ");
        valor = entrada.nextInt();
        return valor;
    }
    public static void body(){
        Scanner entrada = new Scanner(System.in);
        int  fil , col;

        do {
            System.out.print("\nNº de fila: ");
            fil = entrada.nextInt();
        }while(fil <= 0);

        do {
            System.out.print("Nº de columna: ");
            col = entrada.nextInt();
        }while(col <= 0);

        double [][] matriz = new double [fil][col];
        System.out.println("\nMatriz de dimensión "+fil+"x"+col);
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Ingrese elemento ("+(i+1)+","+(j+1)+"): ");
                matriz[i][j] = entrada.nextDouble();
            }
        }
        System.out.println();
        System.out.print("A =  ");
        for (int i = 0; i < fil; i++) {
            if (i==0) System.out.print("| ") ;
            else System.out.print("\t | ");
            for (int j = 0; j < col; j++) {
                System.out.print("\t"+matriz[i][j]+" ");
            }
            System.out.println("\t|");
        }
        System.out.println("\n******");
        if(fil == 1 && col > 1){
            System.out.println("Matriz fila");
        }else if (col == 1 && fil > 1){
            System.out.println("Matriz columna");
        }else if (fil != col){
            System.out.println("Matriz rectangular");
            int count_ceros = 0;
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < col; j++) {
                    if(matriz[i][j]==0){
                        count_ceros++;
                    }
                }
            }
            if(count_ceros == fil*col){
                System.out.println("Matriz nula");
            }
        }
        else{
            System.out.println("Matriz cuadrada");
            int count_ceros = 0;
            int count_matriz_inferior = 0;
            int count_matriz_superior = 0;
            double [] diagonal_datos = new double[fil];
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < col; j++) {
                    if(matriz[i][j]==0){
                        count_ceros++;
                    }
                    //1 0 0     0,0 0,1 0,2
                    //2 5 0     1,0 1,1 1,2
                    //3 4 9     2,0 2,1 2,2
                    if(i > j && matriz[i][j] == 0){
                        count_matriz_superior++;
                    }
                    if(i < j && matriz[i][j] == 0){
                        count_matriz_inferior++;
                    }
                    if(i == j){
                        diagonal_datos[i] = matriz[i][j];
                    }
                }
            }

            if(count_ceros == fil*col){
                System.out.println("Matriz nula");
            }else{
                if(count_matriz_inferior == (fil*fil - fil)/2 && count_matriz_superior == (fil*fil - fil)/2){
                    int count_iguales = 0;
                    int count_identidad = 0;

                    for (double dato: diagonal_datos) {
                        if(dato == diagonal_datos[0]){
                            if (dato == 1){
                                count_identidad++;
                            }
                            count_iguales++;
                        }
                    }
                    if (count_iguales == fil){
                        if(count_identidad == fil){
                            System.out.println("Matriz identidad");
                        }else{
                            System.out.println("Matriz escalar");
                        }
                    }else{
                        System.out.println("Matriz diagonal");
                    }
                }
                else if (count_matriz_inferior == (fil*fil - fil)/2 ){
                    System.out.println("Matriz triangular inferior");
                }else if (count_matriz_superior == (fil*fil - fil)/2){
                    System.out.println("Matriz triangular superior");
                }
            }
        }
        System.out.println("******");
    }
    public  static void good_bye(){
        System.out.println("\nGracias por usar la aplicación de identificación de matrices");
        System.out.println("Este programa fue creado con cariño por:\n Cristian, Frank, Hemsy, Kevin y Samira");
    }
}
