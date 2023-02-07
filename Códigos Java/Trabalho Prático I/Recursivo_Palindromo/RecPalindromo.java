import java.io.*;
import java.util.Scanner;

/**
 *  Palíndromo - Crie um método iterativo que recebe uma string como parâmetro e retorna true
 *  se essa é um palíndromo. Na saída padrão, para cada linha de entrada, escreva uma linha de
 *  saída com Sim / Nao indicando se a linha é um palíndromo
 */

class RecPalindromo{
        public static void main(String[] args){
        try{
            File file = new File("./Códigos Java/Trabalho Prático I/Palindromo/input.txt");

            Scanner leitor = new Scanner(file, "ISO-8859-1");

            int line = 1;
            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();

                
                System.out.println("Linha " + line + " Frase: '" + linha + "' é palindromo? ");
                if(isPalindromo(linha) == true){
                    System.out.println("Sim");
                }else{
                    System.out.println("Nao");
                }
                line++;
            }
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static boolean isPalindromo (String s, int i){
        boolean resp;
        if(i == s.length()){
            resp = true;
        } else if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
            resp = false;
        } else {
            resp = isPalindromo(s, i + 1);
        }
        return resp;
    }
    
    public static boolean isPalindromo(String s){
      return isPalindromo(s, 0);
    }
}