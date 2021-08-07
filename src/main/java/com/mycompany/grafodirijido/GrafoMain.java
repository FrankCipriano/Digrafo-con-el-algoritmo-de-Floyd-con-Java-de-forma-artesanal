/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.grafodirijido;

/**
 *
 * @author frankdev
 */
public class GrafoMain {
    public static void main(String[] args){
        long infinito=999999999;
        //-Matriz de adyacencia
        long matriz[][]={
            {0       ,3       ,4       ,infinito,8       ,infinito},
            {infinito,0       ,infinito,infinito,5       ,infinito},
            {infinito,infinito,0       ,infinito,3       ,infinito},
            {infinito,infinito,infinito,0       ,infinito,infinito},
            {infinito,infinito,infinito,7       ,0       ,3       },
            {infinito,infinito,infinito,2       ,infinito,0       }
        };
        CaminoCorto ruta1 = new CaminoCorto();
        System.out.println(ruta1.algoritmoFloyd(matriz));
    }
}
