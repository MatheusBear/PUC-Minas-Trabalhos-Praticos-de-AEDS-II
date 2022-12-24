import java.io.*;
import java.util.Scanner;

/**
 *  Aquecimento - Crie um método iterativo que receba como parâmetro uma string e retorne seu
 *  número de caracteres maiúsculos. Em seguida, teste o método anterior usando redirecionamento
 *  de entrada e saída.
 *  A saída padrão contém um número inteiro para cada linha de entrada.
 */

class Aquecimento{
   public static void main(String[] args){
      try{
         File file = new File("./Códigos Java/Trabalho Prático I/Aquecimento/input.txt");

         Scanner leitor = new Scanner(file, "ISO-8859-1");

         int line = 1;

         while(leitor.hasNextLine()){
            String linha = leitor.nextLine();

            System.out.println("Linha " + line + " tem: " + contarLetrasMaiusculas(linha) + " Letras Maiúsculas");
            line++;
         }
         leitor.close();
      }catch(IOException e){
         System.out.println("Error");
         e.printStackTrace();
      }
   }

   /**
    * Método para contar a quantidade de letras maiúsculas em uma string
    * @param s - String de entrada
    * @return a quantidade de letras maiúsculas
    */
   public static int contarLetrasMaiusculas (String s){
      int resp = 0;

      for(int i = 0; i < s.length(); i++){
         if(isMaiuscula(s.charAt(i)) == true){
            resp ++; 
         }
      }

      return resp;
   }
/**
 * 
 * @param c recebe cada char da string
 * @return retorna true se for uma letra maiúscula
 */
   public static boolean isMaiuscula (char c){
      return (c >= 'A' && c <= 'Z');
   }
}