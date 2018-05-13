/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

/**
 *
 * @author Neto
 */
/*

    L - Livre
    P - Poço
    W - Wumpus
    M - Wumpus + Poço
    V - Wumpus + Tesouro
    T - Tesouro
    Ordem do vetor: brisa, fedor, cintilar, parede , grito
*/
public class Sensores {
    private Vetor[][] matrizSensores;
    private char matrizVisivel[][];
    public Sensores(char[][] ambiente){
        this.matrizVisivel = ambiente;
        matrizSensores = new Vetor[4][4];
        for(int x = 0;x<4;x++){
            for (int y=0;y<4;y++){
                matrizSensores[x][y] = new Vetor(false,false,false,false,false); //COLOCA UM OBJETO EM CADA POSIÇAO DA MATRIZ
            }
        }
    }
    
    public void gerarSubVetores(){
        for(int x = 0;x < this.matrizSensores.length;x++){
            for(int y = 0; y < this.matrizSensores[0].length; y++){
                if(x == 0 && y ==0) continue; //PULA A PIRMEIRA ITERAÇÃO
                
                //TODAS POSIÇÕES DE PAREDE PARA EVITAR ERRO DE INDEXAÇÃO DA MATRIZ
                
                if(x == 3 && y == 0){
                    matrizSensores[3][0].setParede(); //NA parede
                    //posição canto inferior esquerdo
                    //sensação parede sempre ativo
                    if(matrizVisivel[x-1][y] == 'P' || matrizVisivel[x][y+1] == 'P'){
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                    }else if(matrizVisivel[x-1][y] == 'W' || matrizVisivel[x][y+1] == 'W'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'M' || matrizVisivel[x][y+1] == 'M'){
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x-1][y].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'V' || matrizVisivel[x][y+1] == 'V'){
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'T' || matrizVisivel[x][y+1] == 'T'){
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                    }else{
                        continue;
                    }
                    //----------------------------------------------------------------
                 
                   //posição canto inferior direito
                }else if(x == 3 && y == 3){
                    
                    matrizSensores[3][3].setParede();//parede em todos
                    if(matrizVisivel[x-1][y] == 'P' || matrizVisivel[x][y-1] == 'P'){
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                    }else if(matrizVisivel[x-1][y] == 'W' || matrizVisivel[x][y-1] == 'W'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'M' || matrizVisivel[x][y-1] == 'M'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                    }else if(matrizVisivel[x-1][y] == 'V' || matrizVisivel[x][y-1] == 'V'){
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setOuro();
                        matrizSensores[x-1][y].setOuro();
                    }else if(matrizVisivel[x-1][y] == 'T' || matrizVisivel[x][y-1] == 'T'){
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                    }else{
                        continue;
                    }//---------------------------------------------------
                    
                //canto superior direito
                }else if(x == 0 && y == 3){
                    matrizSensores[0][3].setParede();
                    if(matrizVisivel[x+1][y] == 'P' || matrizVisivel[x][y-1] == 'P'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                    }else if(matrizVisivel[x+1][y] == 'W' || matrizVisivel[x][y-1] == 'W'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                    }else if(matrizVisivel[x+1][y] == 'M' || matrizVisivel[x][y-1] == 'M'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        
                    }else if(matrizVisivel[x+1][y] == 'V' || matrizVisivel[x][y-1] == 'V'){
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                    }else if(matrizVisivel[x+1][y] == 'T' || matrizVisivel[x][y-1] == 'T'){
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                    }else{
                        continue;
                    }
                    //-------------------------------------------------------------
                
                //parede de baixo quadrado esquerdo e direito
                }else if(x == 3 && (y ==1 || y ==2)){
                    if(matrizVisivel[x-1][y] == 'P' || matrizVisivel[x][y-1] == 'P' || matrizVisivel[x][y+1] == 'P'){
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                    }else if(matrizVisivel[x-1][y] == 'W' || matrizVisivel[x][y-1] == 'W' || matrizVisivel[x][y+1] == 'W'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'M' || matrizVisivel[x][y-1] == 'M' || matrizVisivel[x][y+1] == 'M'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                    }else if(matrizVisivel[x-1][y] == 'V' || matrizVisivel[x][y-1] == 'V' || matrizVisivel[x][y+1] == 'V'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                        matrizSensores[x][y-1].setOuro();
                    }else if(matrizVisivel[x-1][y] == 'T' || matrizVisivel[x][y-1] == 'T' || matrizVisivel[x][y+1] == 'T'){
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                        matrizSensores[x][y-1].setOuro();
                    }else{
                       continue;
                    }
                    //-------------------------------------------------------------------    
                //PAREDE DA DIREITA QUADRADOS CIMA E BAIXO
                }else if(y == 3 && x == 2 ){
                    if(matrizVisivel[x-1][y] == 'P' || matrizVisivel[x+1][y] == 'P' || matrizVisivel[x][y-1] == 'P'){
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        matrizSensores[x+1][y].setBrisa();
                        
                    }else if(matrizVisivel[x-1][y] == 'W' || matrizVisivel[x+1][y] == 'W' || matrizVisivel[x][y-1] == 'W'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x+1][y].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'V' || matrizVisivel[x+1][y] == 'V' || matrizVisivel[x][y-1] == 'V'){
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                        matrizSensores[x+1][y].setOuro();
                        
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x+1][y].setWumpus();
                    }else if(matrizVisivel[x-1][y] == 'T' || matrizVisivel[x+1][y] == 'T' || matrizVisivel[x][y-1] == 'T'){
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y-1].setOuro();
                        matrizSensores[x+1][y].setOuro();
                    }else if(matrizVisivel[x-1][y] == 'M' || matrizVisivel[x+1][y] == 'M' || matrizVisivel[x][y-1] == 'M'){
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        matrizSensores[x+1][y].setBrisa();
                    }else{
                        continue;
                    }//------------------------------------------------------
                //PAREDE DE CIMA
                }else if(x == 0 && y == 2){
                    matrizSensores[0][2].setParede();
                    if(matrizVisivel[x+1][y] == 'P' || matrizVisivel[x][y+1] == 'P' || matrizVisivel[x][y-1] == 'P'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        
                    }else if(matrizVisivel[x+1][y] == 'W' || matrizVisivel[x][y+1] == 'W' || matrizVisivel[x][y-1] == 'W'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                    }else if(matrizVisivel[x+1][y] == 'M' || matrizVisivel[x][y+1] == 'M' || matrizVisivel[x][y-1] == 'M'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x][y-1].setBrisa();
                        
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                    }else if(matrizVisivel[x+1][y] == 'V' || matrizVisivel[x][y+1] == 'V' || matrizVisivel[x][y-1] == 'V'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x][y-1].setWumpus();
                        
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                        matrizSensores[x][y-1].setOuro();
                    }else if(matrizVisivel[x+1][y] == 'T' || matrizVisivel[x][y+1] == 'T' || matrizVisivel[x][y-1] == 'T'){
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                        matrizSensores[x][y-1].setOuro();
                    }else{
                        continue;
                    }
                    //-----------------------------------------------------------------
                //PAREDE DA ESQUERDA    
                }else if(y == 0 && x == 1){
                    matrizSensores[1][0].setParede();
                    if(matrizVisivel[x+1][y] == 'P' || matrizVisivel[x-1][y] == 'P' || matrizVisivel[x][y+1]=='P'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                    }else if(matrizVisivel[x+1][y] == 'W' || matrizVisivel[x-1][y] == 'W' || matrizVisivel[x][y+1]== 'W'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                    }else if(matrizVisivel[x+1][y] == 'T' || matrizVisivel[x-1][y] == 'T' || matrizVisivel[x][y+1] == 'T'){
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                    }else if(matrizVisivel[x+1][y] == 'M' || matrizVisivel[x-1][y] == 'M' || matrizVisivel[x][y+1] == 'M'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x-1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                    }else if(matrizVisivel[x+1][y] == 'V' || matrizVisivel[x-1][y] == 'V' || matrizVisivel[x][y+1] == 'V'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x-1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x-1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                    }else{
                        continue;
                    }//--------------------------------------------------
                }else{
                    if(matrizVisivel[x][y] == 'P'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                    }else if(matrizVisivel[x][y] == 'W'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                    }else if(matrizVisivel[x][y] == 'T'){
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                        matrizSensores[x][y+1].setOuro();
                    }else if(matrizVisivel[x][y] == 'M'){
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x+1][y].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x][y+1].setBrisa();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                    }else if(matrizVisivel[x][y] == 'V'){
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x+1][y].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x][y+1].setWumpus();
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x+1][y].setOuro();
                        matrizSensores[x][y+1].setOuro();
                        matrizSensores[x][y+1].setOuro();
                    }else{
                        continue;
                    }
                }
            }
        }
    }
}
