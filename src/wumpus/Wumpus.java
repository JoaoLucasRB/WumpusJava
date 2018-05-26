/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.util.Arrays;
import java.util.Scanner;

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
        Scanner controle = new Scanner(System.in);
        
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
            String asdasdasda = controle.nextLine();
            wumpufibco.update();
            char mobi = ambiente.getPosicao(wumpufibco.xPos, wumpufibco.yPos);
            
            System.out.println(Arrays.toString(wumpufibco.consultarSenses(wumpufibco.xPos,wumpufibco.yPos)));
            System.out.println(Arrays.deepToString(ambiente.getMatrizVisivel()));
            System.out.println(wumpufibco.xPos+""+wumpufibco.yPos);
            
            if(mobi == 'P' || mobi == 'W' || mobi == 'M') {
                wumpufibco.matarAgente();
                System.out.println("Morreu");
            }else if(mobi == 'V'){
                System.out.println("Achou o ouro mas morreu :(");
                wumpufibco.matarAgente();
            }else if(mobi == 'T'){
                System.out.println("Ganhou!");
                wumpufibco.matarAgente();
            }
        }
        
        
        
        
        
    }
    
}
