/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

/**
 *
 * @author 171051224
 */
public class Historico {
    int wumpus;
    int poco;
    int ouro;
    
    public Historico(){
        wumpus = 0;
        poco = 0;
        ouro = 0;
    }
    
    public void alertaOuro(int x, int y, Historico matriz[][]){
        if(x == 0 && y ==0){
            System.out.println("");;
        } //PULA A PIRMEIRA ITERAÇÃO
                
                //TODAS POSIÇÕES DE PAREDE PARA EVITAR ERRO DE INDEXAÇÃO DA MATRIZ
                
                if(x == 3 && y == 0){ //canto inferior esquerdo
                    matriz[x-1][y].ouroSomar();
                    matriz[x][y+1].ouroSomar();
                }else if(x == 3 && y == 3){ // canto inferior direito
                    matriz[x-1][y].ouroSomar();
                    matriz[x][y-1].ouroSomar();
                
                }else if(x == 0 && y == 3){ //canto superior direito
                    matriz[x+1][y].ouroSomar();
                    matriz[x][y-1].ouroSomar();
                
                }else if(x == 3 && (y ==1 || y ==2)){ //parede de baixo quadrado esquerdo e direito
                    matriz[x][y-1].ouroSomar();
                    matriz[x][y+1].ouroSomar();
                    matriz[x-1][y].ouroSomar();
                
                }else if(y == 3 && (x == 2 || x == 1) ){ //PAREDE DA DIREITA QUADRADOS CIMA E BAIXO
                    matriz[x-1][y].ouroSomar();
                    matriz[x+1][y].ouroSomar();
                    matriz[x][y-1].ouroSomar();
                    
                }else if(x == 0 && (y == 2 || y == 1)){ //PAREDE DE CIMA
                    matriz[x][y-1].ouroSomar();
                    matriz[x][y+1].ouroSomar();
                    matriz[x+1][y].ouroSomar();
                
                }else if(y == 0 && (x == 1 || x == 2)){ //PAREDE DA ESQUERDA    
                    matriz[x-1][y].ouroSomar();
                    matriz[x+1][y].ouroSomar();
                    matriz[x][y+1].ouroSomar();
                }else{ // MEIO
                    matriz[x-1][y].ouroSomar();
                    matriz[x][y+1].ouroSomar();
                    matriz[x+1][y].ouroSomar();
                    matriz[x][y-1].ouroSomar();
                }
    }
    public void alertaWumpus(int x, int y, Historico matriz[][]){
        if(x == 0 && y ==0){
            System.out.println("");;
        } //PULA A PIRMEIRA ITERAÇÃO
                
                //TODAS POSIÇÕES DE PAREDE PARA EVITAR ERRO DE INDEXAÇÃO DA MATRIZ
                
                if(x == 3 && y == 0){ //canto inferior esquerdo
                    matriz[x-1][y].wumpusSomar();
                    matriz[x][y+1].wumpusSomar();
                }else if(x == 3 && y == 3){ // canto inferior direito
                    matriz[x-1][y].wumpusSomar();
                    matriz[x][y-1].wumpusSomar();
                
                }else if(x == 0 && y == 3){ //canto superior direito
                    matriz[x+1][y].wumpusSomar();
                    matriz[x][y-1].wumpusSomar();
                
                }else if(x == 3 && (y ==1 || y ==2)){ //parede de baixo quadrado esquerdo e direito
                    matriz[x][y-1].wumpusSomar();
                    matriz[x][y+1].wumpusSomar();
                    matriz[x-1][y].wumpusSomar();
                
                }else if(y == 3 && (x == 2 || x == 1) ){ //PAREDE DA DIREITA QUADRADOS CIMA E BAIXO
                    matriz[x-1][y].wumpusSomar();
                    matriz[x+1][y].wumpusSomar();
                    matriz[x][y-1].wumpusSomar();
                    
                }else if(x == 0 && (y == 2 || y == 1)){ //PAREDE DE CIMA
                    matriz[x][y-1].wumpusSomar();
                    matriz[x][y+1].wumpusSomar();
                    matriz[x+1][y].wumpusSomar();
                
                }else if(y == 0 && (x == 1 || x == 2)){ //PAREDE DA ESQUERDA    
                    matriz[x-1][y].wumpusSomar();
                    matriz[x+1][y].wumpusSomar();
                    matriz[x][y+1].wumpusSomar();
                }else{ // MEIO
                    matriz[x-1][y].wumpusSomar();
                    matriz[x][y+1].wumpusSomar();
                    matriz[x+1][y].wumpusSomar();
                    matriz[x][y-1].wumpusSomar();
                }
    }
    public void alertaPoco(int x, int y, Historico matriz[][]){
        if(x == 0 && y ==0){
            System.out.println("");;
        } //PULA A PIRMEIRA ITERAÇÃO
                
                //TODAS POSIÇÕES DE PAREDE PARA EVITAR ERRO DE INDEXAÇÃO DA MATRIZ
                
                if(x == 3 && y == 0){ //canto inferior esquerdo
                    matriz[x-1][y].pocoSomar();
                    matriz[x][y+1].pocoSomar();
                }else if(x == 3 && y == 3){ // canto inferior direito
                    matriz[x-1][y].pocoSomar();
                    matriz[x][y-1].pocoSomar();
                
                }else if(x == 0 && y == 3){ //canto superior direito
                    matriz[x+1][y].pocoSomar();
                    matriz[x][y-1].pocoSomar();
                
                }else if(x == 3 && (y ==1 || y ==2)){ //parede de baixo quadrado esquerdo e direito
                    matriz[x][y-1].pocoSomar();
                    matriz[x][y+1].pocoSomar();
                    matriz[x-1][y].pocoSomar();
                
                }else if(y == 3 && (x == 2 || x == 1) ){ //PAREDE DA DIREITA QUADRADOS CIMA E BAIXO
                    matriz[x-1][y].pocoSomar();
                    matriz[x+1][y].pocoSomar();
                    matriz[x][y-1].pocoSomar();
                    
                }else if(x == 0 && (y == 2 || y == 1)){ //PAREDE DE CIMA
                    matriz[x][y-1].pocoSomar();
                    matriz[x][y+1].pocoSomar();
                    matriz[x+1][y].pocoSomar();
                
                }else if(y == 0 && (x == 1 || x == 2)){ //PAREDE DA ESQUERDA    
                    matriz[x-1][y].pocoSomar();
                    matriz[x+1][y].pocoSomar();
                    matriz[x][y+1].pocoSomar();
                }else{ // MEIO
                    matriz[x-1][y].pocoSomar();
                    matriz[x][y+1].pocoSomar();
                    matriz[x+1][y].pocoSomar();
                    matriz[x][y-1].pocoSomar();
                }
    }
    
    private void pocoSomar(){
        poco++;
    }
    
    private void ouroSomar(){
        ouro++;
    }
    
    private void wumpusSomar(){
        wumpus++;
    }
}
