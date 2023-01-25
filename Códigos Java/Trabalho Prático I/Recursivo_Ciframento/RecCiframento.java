import java.io.*;
import java.util.*;

/**
 * Ciframento de César - O Imperador Júlio César foi um dos principais nomes do Império
 * Romano. Entre suas contribuições, temos um algoritmo de criptografia chamado “Ciframento de
 * César”. Segundo os historiadores, César utilizava esse algoritmo para criptografar as mensagens
 * que enviava aos seus generais durante as batalhas. A ideia básica é um simples deslocamento
 * de caracteres. Assim, por exemplo, se a chave utilizada para criptografar as mensagens for 3,
 * todas as ocorrências do caractere ’a’ são substituídas pelo caractere ’d’, as do ’b’ por ’e’, e assim
 * sucessivamente. Crie um método iterativo que recebe uma string como parâmetro e retorna
 * outra contendo a entrada de forma cifrada. Neste exercício, suponha a chave de ciframento três.
 * Na saída padrão, para cada linha de entrada, escreva uma linha com a mensagem criptografada.
 */

class RecCiframento{
    public static void main(String[] args){
        try{
            File file = new File("./Códigos Java/Trabalho Prático I/Ciframento de Cesar/input.txt");

            Scanner leitor = new Scanner(file, "ISO-8859-1");

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();

                System.out.println(Cifra(linha));
            }
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static String cifra (String a, String s, int cifra, int i){
		if(i == a.length()) return s;
		else{
			s += (char)(a.charAt(i) + cifra);
			return cifra(a, s, cifra, i+1);
		}
	}

    public static String Cifra(String a)
	{
		String s = "";
        int cifra = 3;

        s = cifra(a, s, cifra, 0);
		return s;
	}
}