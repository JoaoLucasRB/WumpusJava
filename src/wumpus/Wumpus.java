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
        System.out.println(ambiente.getMatrizVisivel());
        
        
        
        
        
    }
    
}
