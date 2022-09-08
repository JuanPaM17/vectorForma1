/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Clases.Polinomio;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanPablo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Polinomio poli = new Polinomio();
        int[] A = null;
        int menu, expo;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Crear un polinomio \n2. Mostrar Polinomio"
                    + "\n3. Exponente menor coeficiente \n4. Ajustar Polinomio"
                    + "\n5. Ajustar polinomio nuevo vector \n6. Sumar dos polinomios"
                    + "\n7. Multiplicar dos polinomios \n8. Insertar "
                    + "\n0. Salir"));
            switch (menu) {
                case 1: {
                    expo = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos exponentes va tener su polinomio"));
                    A = poli.crear_polinomio(expo);
                    break;
                }
                case 2: {
                    poli.mostrar_polinomio(A);
                    break;
                }
                case 3: {
                    poli.menor_coeficiente(A);
                    break;
                }
                case 4: {
                    poli.ajustar(A);
                    break;
                }
                case 5: {
                    int[] B = poli.ajustar_nuevo_vector(A);
                    if (B != null) {
                        A = B;
                    }
                    break;
                }
                case 6: {
                    expo = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos exponentes tiene el primer polinomio"));
                    A = poli.crear_polinomio(expo);
                    System.out.println("\nPolinomio #1 --->\n");
                    poli.mostrar_polinomio(A);
                    expo = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos exponentes tiene el segundo polinomio"));
                    int[] B = poli.crear_polinomio(expo);
                    System.out.println("\nPolinomio #2 --->\n");
                    poli.mostrar_polinomio(B);
                    A = poli.sumar_polinomios(A, B);
                    break;
                }
                case 7: {
                    expo = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos exponentes tiene el primer polinomio"));
                    A = poli.crear_polinomio(expo);
                    System.out.println("\nPolinomio #1 --->\n");
                    poli.mostrar_polinomio(A);
                    expo = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos exponentes tiene el segundo polinomio"));
                    int[] B = poli.crear_polinomio(expo);
                    System.out.println("\nPolinomio #2 --->\n");
                    poli.mostrar_polinomio(B);
                    A = poli.multi_polinomios(A, B);
                    break;
                }
                case 8: {
                    if (poli.vector_vacio()) {
                        int coe = Integer.parseInt(JOptionPane.showInputDialog(null, "Coeficiente a ingresar"));
                        expo = Integer.parseInt(JOptionPane.showInputDialog(null, "En que exponente lo desea?"));
                        A = poli.insertar(A, coe, expo);
                        break;
                    }

                }
            }
        } while (menu != 0);
    }

}
