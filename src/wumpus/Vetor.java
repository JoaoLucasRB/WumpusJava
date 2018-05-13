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
public class Vetor {
    public boolean[] sensacoes;
    
    
    public Vetor(boolean brisa,boolean fedor,boolean cintilar,boolean parede,boolean grito){
        sensacoes = new boolean[]{brisa,fedor,cintilar,parede,grito};
        
    }
    public boolean[] getSensacoes(){
        return sensacoes;
    }
    public void setBrisa(){
        this.sensacoes[0] = true;
    }
    public void setWumpus(){
        this.sensacoes[1] = true;
    }
    public void setOuro(){
        this.sensacoes[2] = true;
    }
    public void setParede(){
        this.sensacoes[3] = true;
    }
    public void setGrito(){
        this.sensacoes[4] = true;
    }
}
