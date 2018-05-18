/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.util.Arrays;

/**
 *
 * @author Neto
 */
public class Wumpus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AmbienteVisivel ambiente = new AmbienteVisivel();
        ambiente.gerarAmbientes();
        ambiente.gerarPocos();
        ambiente.gerarTesouro();
        ambiente.gerarWumpus();
        Sensores sense = new Sensores(ambiente.getMatrizVisivel());
        sense.gerarSubVetores();
        Agente wumpufibco = new Agente(sense.getSensacoes());
        wumpufibco.moverDireita();
        
        while(wumpufibco.status){
            wumpufibco.update();
            System.out.println(Arrays.toString(wumpufibco.consultarSenses(wumpufibco.xPos,wumpufibco.yPos)));
            System.out.println(Arrays.deepToString(ambiente.getMatrizVisivel()));
        }
        
        
        
        
        
    }
    
}
