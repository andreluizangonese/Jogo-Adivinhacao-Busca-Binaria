import java.util.Random;

public class JogoAdivinhacao {

    private static final int N_Min = 1;
    private static final int N_Max = 1000;

    public static int buscaBinaria(int inicio, int fim, int secreto, int[] tentativas) {
        // Ponto médio no intervalo, é basicamente o chute do computador
        int chute = (inicio + fim) / 2;

        // Conta a tentativa uma vez, antes de comparar
        tentativas[0]++;

        if (chute > secreto) {
            System.out.println("Tentativa " + tentativas[0] + ": chute = " + chute + " -> Muito alto");
            fim= chute - 1;
            return buscaBinaria(inicio, fim, secreto, tentativas);
            // Passo recursivo (1): chute alto, o secreto está na metade de baixo.
            // O chute já foi testado, então o novo fim é chute - 1.
        } else if (chute < secreto) {
           
            System.out.println("Tentativa " + tentativas[0] + ": chute = " + chute + " -> Muito baixo");
            inicio= chute+1;
            return buscaBinaria(inicio, fim, secreto, tentativas);
            // Passo recursivo 2 chute baixo, o secreto está na metade de cima.
            // O novo início é chute + 1
        } else {
            // Caso base N secreto é igual ao chute
            System.out.println("Tentativa " + tentativas[0] + ": chute = " + chute + " -> Acertou!");
            return chute;
        }
    }

    public static void main(String[] args) {

        
        int  secreto = new Random().nextInt( N_Max) + N_Min;

        // Contador em array são passado por referência,então todas as chamadas recursivas atualizam o mesmo contador
        int[] tentativas = new int[1];

        System.out.println("=== JOGO DE ADIVINHAÇÃO ===");
        System.out.println("Número secreto sorteado no intervalo [" + N_Min + ", " + N_Max+ "].\n");

        int encontrado = buscaBinaria( N_Min,  N_Max, secreto, tentativas);
        
        System.out.println("\n O número secreto era " + encontrado + ".");
        System.out.println("Total de tentativas: " + tentativas[0]);
        System.out.println("A busca linear levaria até " +  N_Max + " tentativas, mas a busca binária levou " + tentativas[0] );
    }
}