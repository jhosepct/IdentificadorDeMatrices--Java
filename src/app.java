import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int valor = 0;
        welcome();   // mensaje de bienvenida
        while(valor != 2){
            try{
                valor = menu();
                switch (valor){
                    case 1:
                        body();  // programa clasificador de matrices
                        break;
                    case 2:
                        good_bye();  // mensaje de despedida
                        break;
                    default:
                        System.out.println("Digite 1 o 2");
                        break;
                }
            }catch(Exception e){
                System.out.println("Digite un número");
                entrada.next();  // borrar lo que digito el usuario
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

        // crear matriz
        double [][] matriz = new double [fil][col];

        // llenar matriz
        System.out.println("\nMatriz de dimensión "+fil+"x"+col);
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Ingrese elemento ("+(i+1)+","+(j+1)+"): ");
                matriz[i][j] = entrada.nextDouble();
            }
        }
        System.out.println();

        //Imprimir matriz
        System.out.print("A =  ");
        for (int i = 0; i < fil; i++) {
            if (i==0) System.out.print("| ") ;
            else System.out.print("\t | ");
            for (int j = 0; j < col; j++) {
                System.out.print("\t"+matriz[i][j]+" ");
            }
            System.out.println("\t|");
        }
        //Fin imprimir matriz

        //Imprimir tipo de matriz
        System.out.println("\n******************************************");

        // Reconocimiento del tipo


        //Si es una matriz nula
        int count_ceros = 0;
        // 0  0  0      (0,0)  (0,1) (0,2)
        // 0  0  0      (1,0)  (1,1) (1,2)
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                if(matriz[i][j]==0){
                    count_ceros++;
                }
            }
        }

        // Si es una matriz fila
        if(fil == 1 && col > 1){
            System.out.println("Matriz fila"); // Frank
            if(count_ceros == fil*col){
                System.out.println("Matriz nula");
            }
        }
        // Si es una matriz columna
        else if(col == 1 && fil > 1){
            System.out.println("Matriz columna"); // Frank
            if(count_ceros == fil*col){
                System.out.println("Matriz nula");
            }
        }
        // Si es una matriz rectangular
        else if (fil != col){
            System.out.println("Matriz rectangular"); // samira
            if(count_ceros == fil*col){
                System.out.println("Matriz nula"); // samira
            }
        }
        // Si es una matriz cuadrada
        else{
            System.out.println("Matriz cuadrada"); // kevin
            int count_matriz_inferior = 0;
            int count_matriz_superior = 0;
            double [] diagonal_datos = new double[fil];
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < col; j++) {
                    //1 0 0     (0,0) (0,1) (0,2)
                    //2 5 0     (1,0) (1,1) (1,2)
                    //3 4 9     (2,0) (2,1) (2,2)
                    if(i < j && matriz[i][j] == 0){
                        count_matriz_inferior++;
                    }
                    if(i > j && matriz[i][j] == 0){
                        count_matriz_superior++;
                    }
                    if(i == j){
                        diagonal_datos[i] = matriz[i][j];
                    }
                }
            }
            // Si es una matriz cuadrada nula
            if(count_ceros == fil*col){
                System.out.println("Matriz nula");  // kevin
            }else{

                // Si es una matriz diagonal
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
                            System.out.println("Matriz identidad"); // cristian
                        }else{
                            System.out.println("Matriz escalar");  // cristien
                        }
                    }else{
                        System.out.println("Matriz diagonal");  // cristian
                    }
                }

                //Si es una matriz triangular inferior
                else if (count_matriz_inferior == (fil*fil - fil)/2 ){
                    System.out.println("Matriz triangular inferior"); // hemsy
                }

                //Si es una matriz triangular superior
                else if (count_matriz_superior == (fil*fil - fil)/2){
                    System.out.println("Matriz triangular superior");  // hemsy
                }
                // t. inferior   |  t. superior
                //   1 0 0            7  6  8
                //   2 5 0            0  9  5
                //   3 4 9            0  0  4
            }
        }
        System.out.println("******************************************");
    }
    public  static void good_bye(){
        System.out.println("\nGracias por usar la aplicación de identificación de matrices");
        System.out.println("Este programa fue creado con cariño por:\n Cristian, Frank, Hemsy, Kevin y Samira");
    }
}