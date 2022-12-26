import java.io.*;
import java.util.*;

/**
 * Alteralção Aleatória - Crie um método iterativo que recebe uma string, sorteia duas letras minúsculas aleatórias (código ASCII ≥ ’a’ e ≤ ’z’), 
 * substitui todas as ocorrências da primeira letra na string pela segunda e retorna a string com as alterações efetuadas. Na saída padrão, 
 * para cada linha de entrada, execute o m ́etodo desenvolvido nesta quest ̃ao e mostre a string retornada como uma linha de saída. 
 * Abaixo, observamos um exemplo de entrada supondo que para a primeira linha as letras sorteados foram o ’a’ e o ’q’. Para a segunda linha, foram o ’e’ e o ’k’.
 * 
 * EXEMPLO DE ENTRADA:
 * o rato roeu a roupa do rei de roma
 * e qwe qwe qwe ewq ewq ewq
 * 
 * EXEMPLO DE SAÍDA:
 * o rqto roeu q roupq do rei de romq
 * k qwk qwk qwk kwq kwq kwq
 * 
 * A classe Random do Java gera números (ou letras) aleatórios e o exemplo abaixo mostra uma letra minúscula na tela. 
 * Em especial, destacamos que: 
 * i) seed ́e a semente para geração de números aleatórios; 
 * ii) nesta questão, por causa da correção automática, a seed será quatro; 
 * iii) a disciplina de Estatística e Probabilidade faz uma discussão sobre “aleatório”.
 */

class Alteracao{
    public static void main(String[] args){
        Random gerador = new Random();
        gerador.setSeed(4);

        try{
            File file = new File("./Códigos Java/Trabalho Prático I/Alteração Aleatorio/input.txt");

            Scanner leitor = new Scanner(file, "ISO-8859-1");

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();

                System.out.println(Aleatorio(linha, gerador));
            }
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static String Aleatorio(String s, Random gerador){
        char PrimeiraPalavra = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
        char SegundaPalavra = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));

        String a = "";    

        for(int i = 0; i < s.length(); i++){            
            if(s.charAt(i) == PrimeiraPalavra)
                a+= SegundaPalavra;
            else
                a+= s.charAt(i);
        }

        return a;
    }
}