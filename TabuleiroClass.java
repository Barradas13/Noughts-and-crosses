import java.util.Scanner;

public class TabuleiroClass{
    int tamanho, possivelEmpate;
    String coordenadas[][];
    String jogadorVez;
    String valores[];
    String venceu;
    boolean diagonalPrim;
    final static Scanner input = new Scanner(System.in);

    public TabuleiroClass(int tamanho){        
        this.tamanho = tamanho;  
        this.coordenadas = new String[tamanho][tamanho];
        this.jogadorVez = "O";
        this.possivelEmpate = 0;

        //the values of the coluns or lines or diagonals to be called on the 
        //verificaValores to see if the game has a winner
        this.valores = new String[this.coordenadas.length];
        this.diagonalPrim = true;

        //if someone wins it will change this variable
        this.venceu = "";
    }


    //ask the player the coordenates for the play, if the coordenate doesn´t have any O or X it will change it
    public void colocandoValores(){
        
        while(true){
            System.out.println("Digite as cordenadas desejadas para a jogada: ");
            int linhaColuna[] = {input.nextInt(), input.nextInt()};
            
            if(this.coordenadas[linhaColuna[0] - 1][linhaColuna[1] - 1] != "X" && this.coordenadas[linhaColuna[0] - 1][linhaColuna[1] - 1] != "O"){
                this.possivelEmpate ++;
                if(this.jogadorVez == "X") this.jogadorVez = "O";
                else this.jogadorVez = "X";

                this.coordenadas[linhaColuna[0] - 1][linhaColuna[1] - 1] = this.jogadorVez;
                break;
                }else{
                    System.out.println("A coluna e linha indicada já possui um valor");
                    continue;
                }
        }
    }


    //shows the board and verify if an empate has happened
    public void mostrandoTabuleiroCoord(){
        for(int c = 0; c < this.coordenadas[0].length; c ++){
            for(int i = 0; i < this.coordenadas[0].length; i++){
                if(this.coordenadas[c][i] == null) this.coordenadas[c][i] = "-";
                if(i == this.coordenadas[0].length - 1) System.out.println(this.coordenadas[c][i]);
                else System.out.print(this.coordenadas[c][i] + " ");
            }
        }
    }


    //verify if the gived values has an sequence like 'X-X-X'
    public String verificaValores(){
        String valorAnterior = valores[0];
        boolean continuar = true;
        for(int i = 0; i < valores.length; i ++){
            if(this.valores[i] == valorAnterior && continuar && this.valores[i] != "-"){
                continuar = true;
                valorAnterior = valores[i];
            }else{
                continuar = false;
            }
        }
        if(continuar){
            return valorAnterior + " venceu";
        }
        return "";
    }


    //calls the verificaValores giving the sequence of the verticals
    public String verificaVerticais(){

        for(int c = 0; c < this.coordenadas[0].length; c++){
            for(int i = 0; i < this.coordenadas[0].length; i++){
                this.valores[i] = this.coordenadas[i][c];
            }
            if(verificaValores().length() != 0){
                this.venceu = this.verificaValores();
            }
        }
        return "";
    }


    //calls the verificaValores giving the sequence of the horizontals
    public String verificaHorizontais(){

        for(int c = 0; c < this.coordenadas[0].length; c++){
            for(int i = 0; i < this.coordenadas[0].length; i++){
                this.valores[i] = this.coordenadas[c][i];
            }
            if(verificaValores().length() != 0) this.venceu = this.verificaValores();
        }
        return "";
    }


    //calls the verificaValores giving the sequence of the diagonals
    public String verificaDiagonais(){
        for(int n = 0; n < 2; n++){
            if(this.diagonalPrim){
                for(int i = 0; i < this.coordenadas[0].length; i++){
                    valores[i] = this.coordenadas[i][i];
                }
                if(this.verificaValores().length() != 0) this.venceu = this.verificaValores();
                this.diagonalPrim = false;
            }else{
                int c = this.coordenadas[0].length;
                for(int i = 0; i < this.coordenadas[0].length; i++){
                    this.valores[i] = this.coordenadas[i][c - 1];
                    c --;
                }
                if(this.verificaValores().length() != 0) this.venceu = this.verificaValores();
                this.diagonalPrim = true;
            }
        }
        return "";
    }

}
