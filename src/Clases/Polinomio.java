/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.lang.*;

import javax.swing.JOptionPane;

/**
 *
 * @author JuanPablo
 */
public class Polinomio {

    // --- Atributos ---//
    private int exponente;
    private int coeficente;
    private int dato_util;
    private int[] vector;

    // --- Contructor Defecto --- //
    public Polinomio() {
    }

    // --- vector vacio --- //
    public boolean vector_vacio() {
        if (vector != null) {
            return true;
        } else {
            System.out.println("No hay un polinomio, cree uno");
            return false;
        }
    }

    // --- METODOS --- //
    // --- #1 Creacion del vector (Polinomio) --- //
    public int[] crear_polinomio(int exponente) {
        this.exponente = exponente;
        this.dato_util = exponente + 2;
        vector = new int[this.dato_util];
        vector[0] = this.exponente;
        int j = this.exponente;
        for (int i = 1; i < this.dato_util; i++) {
            coeficente = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor del coeficiente con el exponente " + j));
            vector[i] = coeficente;
            j--;
        }
        return vector;
    }

    // --- #2 Mostrar --- //
    public void mostrar_polinomio(int[] A) {
        if (vector_vacio()) {
            this.dato_util = A[0] + 2;
            System.out.println("\nEl Polinomio es:\n");
            for (int i = 0; i < this.dato_util; i++) {
                System.out.print(A[i] + "x + ");
                System.out.print(" ");
            }
        }
    }

    // --- #3 Menor Coeficiente --- //
    public void menor_coeficiente(int[] A) {
        if (vector_vacio()) {
            this.dato_util = A[0] + 2;
            int menor = A[1];
            int posicion = 1;
            for (int i = 2; i < this.dato_util; i++) {
                if (A[i] != 0) {
                    if (A[i] < menor) {
                        posicion = i;
                    }
                }
            }
            int formula_buscar_pos = A[0] + 1 - posicion;
            int numero = A[0] + 1 - formula_buscar_pos;
            System.out.println("El exponente con menor coeficiente es: " + formula_buscar_pos + " con el numero: " + A[numero] + " y se encuentra en la posición: " + numero);
        }

    }

    // --- #4 Ajustar --- //
    public void ajustar(int[] A) {
        if (vector_vacio()) {
            this.dato_util = A[0] + 2;
            int contador = 0;
            if (A[1] == 0) {
                int i = 1;
                while (i < this.dato_util && A[i] == 0) {
                    contador++;
                    i++;
                }
                for (int j = i; j < this.dato_util; j++) {
                    A[j - contador] = A[j];
                    A[j] = 0;
                }
                A[0] = A[0] - contador;
                System.out.println("Polinimio ajustado con exito");
            } else {
                System.out.println("El polinomio ya cumple con las condiciones");
            }
        }

    }

    // --- #4b Ajustar vector --- //
    public int[] ajustar_nuevo_vector(int[] A) {
        int[] nuevo = null;
        if (vector_vacio()) {
            this.dato_util = A[0] + 2;
            int contador = 0;
            if (A[1] == 0) {
                int i = 1;
                while (i < this.dato_util && A[i] == 0) {
                    contador++;
                    i++;
                }
                for (int j = i; j < this.dato_util; j++) {
                    A[j - contador] = A[j];
                    A[j] = 0;
                }
                A[0] = A[0] - contador;
                nuevo = new int[A[0] + 2];
                for (int j = 0; j < A[0] + 2; j++) {
                    nuevo[j] = A[j];
                }
                this.dato_util = nuevo[0] + 2;
                System.out.println("Polinimio ajustado con exito");
            } else {
                System.out.println("El polinomio ya cumple con las condiciones");
            }
        }
        return nuevo;
    }

    // --- #5 Suma de polinomios --- //
    public int[] sumar_polinomios(int[] A, int[] B) {
        int[] resultado;
        int grado1 = A[0] + 2;
        int grado2 = B[0] + 2;
        if (grado1 >= grado2) {
            resultado = new int[grado1];
            resultado[0] = A[0];
        } else {
            resultado = new int[grado2];
            resultado[0] = B[0];
        }
        int j = 1, i = 1, k = 1;
        while (j < grado1 && k < grado2) {
            int expA = A[0] + 1 - j;
            int expB = B[0] + 1 - i;
            if (expA > expB) {
                resultado[k] = A[j];
                k++;
                j++;
            } else {
                if (expB > expA) {
                    resultado[k] = B[i];
                    i++;
                    k++;
                } else {
                    resultado[k] = A[j] + B[i];
                    i++;
                    k++;
                    j++;
                }
            }
        }
        System.out.println("\nPolinomios sumados con exito: ---> RESULTADO ");
        this.dato_util = resultado[0] + 2;
        mostrar_polinomio(resultado);
        return resultado;
    }

    // --- #6 Multiplicacion de polinomios --- //
    public int[] multi_polinomios(int[] A, int[] B) {
        int[] resultado = new int[A[0] + B[0] + 2];
        int posR = 0, coefR, expB, expA, expR;
        this.dato_util = A[0] + B[0];
        resultado[0] = this.dato_util;
        for (int i = 1; i < B[0] + 2; i++) {
            expB = B[0] + 1 - i;
            for (int k = 1; k < A[0] + 2; k++) {
                expA = A[0] + 1 - k;
                expR = expA + expB;
                coefR = A[k] * B[i];
                posR = resultado[0] + 1 - expR;
                resultado[posR] = resultado[posR] + coefR;
            }
        }
        ajustar_nuevo_vector(resultado);
        return resultado;
    }

    // --- #7 Insertar dato --- //
    public int[] insertar(int[] A, int coeficiente, int exponente) {
        if (vector_vacio()) {
            this.dato_util = A[0] + 2;
            if (coeficiente <= 0 || exponente < 0) {
                System.out.println("Datos Invalidos");
            } else {
                int posA, expA, expC, k = 1;
                if (A[0] >= exponente) {
                    posA = A[0] + 1 - exponente;
                    A[posA] = A[posA] + coeficiente;
                    ajustar_nuevo_vector(A);
                } else {
                    int[] nuevo = new int[exponente + 2];
                    nuevo[0] = exponente;
                    nuevo[1] = coeficiente;
                    this.dato_util = nuevo[0] + 2;
                    for (int i = 2; i < this.dato_util; i++) {
                        expC = nuevo[0] + 1 - i;
                        expA = A[0] + 1 - k;
                        if (expA == expC) {
                            nuevo[i] = A[k];
                            k++;
                        } else {
                            nuevo[i] = 0;
                        }
                    }
                    A = nuevo;
                }
                System.out.println("Coeficiente ingresado con exito");
            }
        }

        return A;
    }
    
    // --- #8 Dividir --- //
    public int[] dividir_polinomios(int A[], int B[]){
        int[] resultado = null;
        return resultado;
    }
}
