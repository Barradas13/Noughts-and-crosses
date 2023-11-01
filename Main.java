import java.util.Scanner;


public class Main {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite o tamanho do tabuleiro");
        TabuleiroClass tabuleiro = null;
        tabuleiro = new TabuleiroClass(input.nextInt());

        while(true){
            
            if(tabuleiro.possivelEmpate == tabuleiro.tamanho * tabuleiro.tamanho){
                System.out.println("Empate");
                break;
            }
            tabuleiro.colocandoValores();

            tabuleiro.mostrandoTabuleiroCoord();

            tabuleiro.verificaDiagonais();

            if(tabuleiro.venceu.length() != 0){
                System.out.println(tabuleiro.venceu);
                break;
            }

            tabuleiro.verificaVerticais();

            if(tabuleiro.venceu.length() != 0){
                System.out.println(tabuleiro.venceu);
                break;
            }

            tabuleiro.verificaHorizontais();

            if(tabuleiro.venceu.length() != 0){
                System.out.println(tabuleiro.venceu);
                break;
            }
        }
    }
}