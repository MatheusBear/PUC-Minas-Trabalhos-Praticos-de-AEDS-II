import java.io.*;
import java.util.*;

/**
 * Is - Crie um método iterativo que recebe uma string e retorna true se a mesma ́e composta somente por vogais. 
 * Crie outro método iterativo que recebe uma string e retorna true se a mesma ́e composta somente por consoantes. 
 * Crie um terceiro método iterativo que recebe uma string e retorna true se a mesma corresponde a um número inteiro. 
 * Crie um quarto método iterativo que recebe uma string e retorna true se a mesma corresponde a um número real. 
 * Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma 'X1', 'X2', 'X3', 'X4' 
 * onde cada 'Xi' ́e um booleano indicando se a ́e entrada ́e: composta somente por vogais (X1); 
 * composta somente somente por consoantes (X2); um número inteiro (X3); um número real (X4). 
 * Se 'Xi'for verdadeiro, seu valor ser ́a SIM, caso contrário, NAO
 */

class Is{
    public static void main(String[] args){
        try{
            File file = new File("./Códigos Java/Trabalho Prático I/IS/input.txt");

            Scanner leitor = new Scanner(file, "ISO-8859-1");

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();

                if(isVogais(linha) == true){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }

                if(isCons(linha) == true){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }

                if(isInt(linha) == true){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }
                
                if(isReal(linha) == true){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }
            }
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static String Virgula(String s){
        String ponto = "";	

        for ( int i = 0; i < s.length(); i++ ){
            if ( s.charAt(i) == ',' ){
                ponto += ".";
            }else ponto += s.charAt(i);
        }

        return ponto;
    }

    public static boolean isReal(String s){ //Descobrir se o char e real
        try{
      		Double.parseDouble(Virgula(s));
      		return true;
        }
        catch( Exception ex ){
            return false;
        }
    }

    public static boolean isInt(String s){ //Descobrir se o char e int
        try{
            Integer.parseInt(s);
            return true;
        }
        catch( Exception ex ){
            return false;
        }
    }

    public static boolean isCons(String s){ //Descobrir se o char e consoante
        s = s.toLowerCase();
        boolean cons = true;	

        for(int i = 0; i < s.length(); i++){
            if((int)s.charAt(i) >= 97 && (int)s.charAt(1) <= 122){
                    if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'h' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'y'){
                            return false;
                    }else{
                    cons = true;
                }
            }else{
                return false;
            }
        }

        return cons;
    }

    public static boolean isVogais(String s){
        s = s.toLowerCase();
        boolean vog = true;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ){
                vog = true;
            }else{
                return false;
            }
        }

        return vog;
    }

}