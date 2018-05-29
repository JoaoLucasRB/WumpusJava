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
    Historico matrizConhecimento[][];
    Vetor matrizSenses[][];
    AmbienteVisivel j;
    int xPos;
    int yPos;
    boolean status;

    public Agente(Vetor sensacoes[][], AmbienteVisivel j) {
        this.matrizSenses = sensacoes;
        this.xPos = 0;
        this.yPos = 0;
        this.sense = consultarSenses(0, 0);
        this.status = true;
        this.j = j;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                matrizConhecimento[x][y] = new Historico();
            }
        }
    }

    void update() {
        //AÇOES DO BONECO
        if(this.matrizSenses[xPos][yPos].getSensacoes()[0] == true){
            matrizConhecimento[xPos][yPos].alertaPoco(xPos, yPos, matrizConhecimento);
        }
        //NAO MUDE
        if (this.status != true) {
            System.out.println("Perdeu");
        }
    }

    public boolean[] consultarSenses(int x, int y) {
        return matrizSenses[x][y].getSensacoes();
    }
    public void matarAgente(){
        this.status = false;
    }

    public void moverBaixo() {
        try {
            this.xPos += 1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        } catch (Exception e) {
            xPos = 3;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }

    public void moverCima() {
        try {
            this.xPos -= 1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        } catch (Exception e) {
            xPos = 0;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }

    public void moverDireita() {
        try {
            this.yPos += 1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        } catch (Exception e) {
            yPos = 3;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }

    public void moverEsquerda() {
        try {
            this.yPos -= 1;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
        } catch (Exception e) {
            yPos = 0;
            this.sense = matrizSenses[this.xPos][this.yPos].getSensacoes();
            System.out.println("Parede!");
        }
    }

    public void atirarHorizontal() {
        for (int y = 0; y < 4; y++) {
            if ((j.getPosicaoVisivel(xPos, y) == 'W') || (j.getPosicaoVisivel(xPos, y) == 'V') || (j.getPosicaoVisivel(xPos, y) == 'M')) {
                this.matrizSenses[xPos - 1][y].setMorteWumpous();
                this.matrizSenses[xPos + 1][y].setMorteWumpous();
                this.matrizSenses[xPos][y - 1].setMorteWumpous();
                this.matrizSenses[xPos][y + 1].setMorteWumpous();
            }
        }
    }
    
    public void atirarVertical() {
        for (int x = 0; x < 4; x++) {
            if ((j.getPosicaoVisivel(x, yPos) == 'W') || (j.getPosicaoVisivel(x, yPos) == 'V') || (j.getPosicaoVisivel(x, yPos) == 'M')) {
                this.matrizSenses[x-1][yPos].setMorteWumpous();
                this.matrizSenses[x+1][yPos].setMorteWumpous();
                this.matrizSenses[x][yPos - 1].setMorteWumpous();
                this.matrizSenses[x][yPos + 1].setMorteWumpous();
            }
        }
    }

}
