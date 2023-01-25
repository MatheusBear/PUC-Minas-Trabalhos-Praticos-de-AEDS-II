import java.io.*;
import java.util.Scanner;

/**
 *  Aquecimento - Crie um método iterativo que receba como parâmetro uma string e retorne seu
 *  número de caracteres maiúsculos. Em seguida, teste o método anterior usando redirecionamento
 *  de entrada e saída.
 *  A saída padrão contém um número inteiro para cada linha de entrada.
 */

class RecAquecimento{
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
   public static int contarLetrasMaiusculas (String s){
		int i = 0, resp = 0;
		
		return contarLetrasMaiusculas(s, i, resp);
	}

   public static int contarLetrasMaiusculas (String s, int i, int resp){

		if(i == s.length())	return resp;
        else if(isMaiuscula(s.charAt(i)) == true){
        	resp++; 
			return contarLetrasMaiusculas(s, i+1, resp);
		}
		else 
			return contarLetrasMaiusculas(s, i+1, resp);

   }
   public static boolean isMaiuscula (char c){
      return (c >= 'A' && c <= 'Z');
   }
}