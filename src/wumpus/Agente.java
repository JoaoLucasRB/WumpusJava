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
public class Agente {
    boolean sense[];
    float matrizProbabilidade[][];
    Vetor matrizSenses[][];
    int xPos;
    int yPos;
    public Agente(Vetor sensacoes[][]){
        this.matrizSenses = sensacoes;
        this.xPos = 0;
        this.yPos = 0;
        this.sense = consultarSenses(0,0);
    }
    
    public boolean[] consultarSenses(int x, int y){
        return matrizSenses[x][y].getSensacoes();
    }
    public void moverBaixo(){
        try{
            this.xPos +=1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        }catch(Exception e){
            xPos = 3;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }
    public void moverCima(){
        try{
            this.xPos -=1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        }catch(Exception e){
            xPos = 0;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }
    public void moverDireita(){
        try{
            this.yPos +=1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        }catch(Exception e){
            yPos = 3;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }
    public void moverEsquerda(){
        try{
            this.yPos -=1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        }catch(Exception e){
            yPos = 0;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }
    
}
