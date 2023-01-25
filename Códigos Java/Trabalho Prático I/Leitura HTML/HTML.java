import java.io.*;
import java.util.*;
import java.net.*;

/**
 * 
 */

class HTML{
    public static void main(String[] args){
        try{
            File file = new File("./Códigos Java/Trabalho Prático I/Leitura HTML/input.txt");

            Scanner leitor = new Scanner(file, "ISO-8859-1");

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();
                if(leitor.hasNextLine()){
                    String nome = linha;
                    String Link = leitor.nextLine();

                    LerHTML(Link, nome);
                }

            }
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public static void LerHTML(String url, String nome){
		String l;
		BufferedReader br;
		int[] val = new int[26];
		for(int i=0;i<26;i++){
			val[i]= 0;
		}
	
		try{
			URL	site = new URL(url);
			InputStream s = site.openStream();
			br = new BufferedReader(new InputStreamReader(s));

			while((l = br.readLine()) != null){
				Processar(l, val);
			}
		}catch(MalformedURLException e){

		}catch(IOException a){

		}

		System.out.println("a(" + val[0] + ") e(" + val[1] + ") i(" + val[2] + ") o(" + val[3] + ") u(" + val[4] + ") á(" + val[5] + ") é(" + val[6] + 
		") í(" + val[7] + ") ó(" + val[8] + ") ú(" + val[9] + ") à(" + val[10] + ") è(" + val[11] + ") ì(" + val[12] + ") ò(" + val[13] + ") ù(" 
		+ val[14] + ") ã(" + val[15] + ") õ(" + val[16] + ") â(" + val[17] + ") ê(" + val[18] + ") î(" + val[19] + ") ô(" + val[20] + 
		") û(" + val[21] + ") consoante(" + val[22] + ") <br>(" + val[23] + ") <table>(" + val[24] + ") " + nome);
	}

	public static boolean cons(char x){
		String consoante = "bcdfghjklmnpqrstvwxyz";
		boolean aux = false;

		for(int i=0; i < consoante.length();i++){
			if(x==consoante.charAt(i)){
				aux = true;
				return aux;
			}else{
				aux = false;
			}
		}return aux;
	}

	public static void Processar(String s, int[] val){
		for(int y = 0; y < s.length(); y++){
			if(cons(s.charAt(y))){
				val[22]++;
			}
			if(s.charAt(y) == 'a'){
				val[0]++;
			}
			else if(s.charAt(y) == 'e'){
				val[1]++;
			}
			else if(s.charAt(y) == 'i'){
				val[2]++;
			}
			else if(s.charAt(y) == 'o'){
				val[3]++;
			}
			else if(s.charAt(y) == 'u'){
				val[4]++;
			}
			else if(s.charAt(y) == 'á'){
				val[5]++;
			}
			else if(s.charAt(y) == 'é'){
				val[6]++;
			}
			else if(s.charAt(y) == 'í'){
				val[7]++;
			}
			else if(s.charAt(y) == 'ó'){
				val[8]++;
			}
			else if(s.charAt(y) == 'ú'){
				val[9]++;
			}
			else if(s.charAt(y) == 'à'){
				val[10]++;
			}
			else if(s.charAt(y) == 'è'){
				val[11]++;
			}
			else if(s.charAt(y) == 'ì'){
				val[12]++;
			}
			else if(s.charAt(y) == 'ò'){
				val[13]++;
			}
			else if(s.charAt(y) == 'ù'){
				val[14]++;
			}
			else if(s.charAt(y) == 'ã'){
				val[15]++;
			}
			else if(s.charAt(y) == 'õ'){
				val[16]++;
			}
			else if(s.charAt(y) == 'â'){
				val[17]++;
			}
			else if(s.charAt(y) == 'ê'){
				val[18]++;
			}
			else if(s.charAt(y) == 'î'){
				val[19]++;
			}
			else if(s.charAt(y) == 'ô'){
				val[20]++;
			}
			else if(s.charAt(y) == 'û'){
				val[21]++;
			}
			else if(s.charAt(y) == '<'){
				if(s.charAt(y+1) == 'b'){
					if(s.charAt(y+2) == 'r'){
						if(s.charAt(y + 3) == '>'){
							val[23]++;
							y += 4;
						}
					}
				}
				if(s.charAt(y + 1) == 't'){
					if(s.charAt(y + 2) == 'a'){
						if(s.charAt(y + 3) == 'b'){
							if(s.charAt(y + 4) == 'l'){
								if(s.charAt(y + 5) == 'e'){
									if(s.charAt(y + 6) == '>'){
										val[24]++;
										y+=7;
									}
								}
							}
						}
					}
				}
			}
			
		}
	}
}