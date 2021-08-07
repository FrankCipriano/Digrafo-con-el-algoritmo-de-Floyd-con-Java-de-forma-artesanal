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
public class CaminoCorto {
    //METODO PARA DETERMINAR TODOS LOS CAMINOS POR EL ALGORITMO DE FLOYD
    public String algoritmoFloyd(long [][] adyacente){
        int vertices=adyacente.length;
        long matrizAyte[][]=adyacente;
        String caminos[][]=new String[vertices][vertices];
        String caminos_aux[][]=new String[vertices][vertices];
        String camino_recorrido="",cadena="",caminitos="";
        int i,j,k;
        float temporal1,temporal2,temporal3,temporal4,minimo;
        //-inicializando las matrices caminos y caminos_aux
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){
                caminos[i][j]="";
                caminos_aux[i][j]="";
            }
        }
        for(k=0;k<vertices;k++){
            for(i=0;i<vertices;i++){
                for(j=0;j<vertices;j++){
                    temporal1=matrizAyte[i][j];
                    temporal2=matrizAyte[i][k];
                    temporal3=matrizAyte[k][j];
                    temporal4=temporal2+temporal3;
                    //Encontrando al minimo
                    minimo=Math.min(temporal1, temporal4);
                    if(temporal1!=temporal4){
                        if(minimo==temporal4){
                            camino_recorrido="";
                            caminos_aux[i][j]=k+"";
                            caminos[i][j]=caminoR(i,k,caminos_aux,camino_recorrido)+(k+1);
                        }
                    }
                    matrizAyte[i][j]=(long)minimo;
                }
            }
        }
        //-agregando el camino a cadena
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){//----
                cadena+="["+matrizAyte[i][j]+"]";
            }
            cadena+="\n";
        }
        //-formando el camino
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){
                if(matrizAyte[i][j]!=1000000000){
                    if(i!=j){
                        if(caminos[i][j].equals("")){
                            caminitos+="De ("+(i+1)+"---->"+(j+1)+"), Irse por: ("+(i+1)+", "+(j+1)+")\n";
                        }else{
                            caminitos+="De ("+(i+1)+"---->"+(j+1)+"), Irse por: ("+(i+1)+", "+caminos[i][j]+", "+(j+1)+")\n";
                        }
                    }
                }
            }
        }
        return "La matriz de caminos más cortos entre los diferentes vértices es:\n"+cadena+
                "\nLos diferentes caminos más cortos entre vértices son;\n"+caminitos;
    }
    //METODO PARA ENCONTRAR EL CAMINO
    public String caminoR(int i, int k,String[][] caminos_aux,String camino_recorrido){
        if(caminos_aux[i][k].equals("")){
            return "";
        }else{
            camino_recorrido+=caminoR(i,Integer.parseInt(caminos_aux[i][k].toString()),caminos_aux,camino_recorrido)+(Integer.parseInt(caminos_aux[i][k].toString())+1)+", ";
            return camino_recorrido;
        }
    }
}
