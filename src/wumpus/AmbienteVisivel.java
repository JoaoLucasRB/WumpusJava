package wumpus;
import java.util.*;

/*

    L - Livre
    P - Poço
    W - Wumpus
    M - Wumpus + Poço
    V - Wumpus + Tesouro
    T - Tesouro
*/
public class AmbienteVisivel {
    private char[][] matrizVisivel;
    int xA, yA;
    public AmbienteVisivel(){
       matrizVisivel = new char[4][4];
       
    }
    
    public void gerarAmbientes(){   //Gerar os ambientes livres (Sem poço, monstro ou tesouro)
        for (int x=0; x<4; x++){
            for(int y=0; y<4; y++){
                matrizVisivel[x][y] = 'L';
            }
        }
    }
    
    public void gerarPocos(){   //Gerar 3 poços no ambiente
        Random aleatorio = new Random();
        for (int n=0; n<3; n++){
            do{
                xA = aleatorio.nextInt(4);
                yA = aleatorio.nextInt(4);
            }while(((xA > 3) || (yA > 3) || ( (xA == 0) && (yA == 0) ) || ( (xA == 0) && (yA == 1) ) || ( (xA == 1) && (yA == 0) )) || (matrizVisivel[xA][yA] == 'P'));
            matrizVisivel[xA][yA] = 'P';    //P - Poço
        }
    }
    
    public void gerarWumpus(){  //Gerar Wumpus no ambiente
        Random aleatorio = new Random();
        do{
           xA = aleatorio.nextInt(4);
           yA = aleatorio.nextInt(4); 
        }while((xA > 3) || (yA > 3) || ( (xA == 0) && (yA == 0) ) || ( (xA == 0) && (yA == 1) ) || ( (xA == 1) && (yA == 0) ) );
        if(matrizVisivel[xA][yA] == 'P'){   //se houver poço no ponto escolhido
            matrizVisivel[xA][yA] = 'M';    // M - Wumpus + Poço
        }else{
            matrizVisivel[xA][yA] = 'W';    // W - Somente Wumpus
        }
    }
    
    public void gerarTesouro(){     //Gerar tesouro no ambiente
        Random aleatorio = new Random();
        do{
            xA = aleatorio.nextInt(4);
            yA = aleatorio.nextInt(4); 
        }while( (xA > 3) || (yA > 3) || ( (xA == 0) && (yA == 0) ) || ( (xA == 0) && (yA == 1) ) || ( (xA == 1) && (yA == 0) ) || (matrizVisivel[xA][yA] == 'P') || matrizVisivel[xA][yA] == 'M');
        if(matrizVisivel[xA][yA] == 'W'){   //se houver wumpus no ponto escolhido
            matrizVisivel[xA][yA] = 'V';    // V - Wumpus + Tesouro
        }else{
            matrizVisivel[xA][yA] = 'T';    // T - Tesouro
        }
    }
    
    public char[][] getMatrizVisivel(){ //PODE MUDAR PARA RETORNAR UMA MATRIZ : public char[][] getMatrizVisivel()
        return matrizVisivel;
    }
    
}