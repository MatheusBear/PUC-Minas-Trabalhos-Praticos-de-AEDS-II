import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pilha_Alocacao_Sequencial{
    public static void main(String[] args)throws Exception{
        Time time = new Time();
        Pilha pilha = new Pilha(1000);
        File file = new File("./Códigos Java/Programação Orientada a Objetos(POO)/Banco de Dados/Times/");
        File[] Lista = file.listFiles();
        //Leitura do input        
        try{
            File input = new File("./Códigos Java/Programação Orientada a Objetos(POO)/pubPilhaSequencial.in");

            Scanner leitor = new Scanner(input);

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();

                if(linha.equals("FIM")){
                    break;
                }

                //Tirar o /tmp/times/ do nome
                String[] EntradaClean = linha.split("/");
                String nome = EntradaClean[3];

                for (File folder : Lista) {
                    if (folder.isFile()) {
                        String i = folder.getName();
                        
                        if(i.equals(nome)){
                            time.leitura(i);
                            pilha.inserir(time);
                        }
                    }
                }
            }

            leitor.nextLine();

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();
                String nTime;

                if(linha.contains("I")){
                    String aux[] = linha.split(" ");
                    nTime = aux[1];

                    //Tirar o /tmp/times/ do nome
                    String[] EntradaClean = nTime.split("/");
                    String nome = EntradaClean[3];

                    time.leitura(nome);
                    pilha.inserir(time);
                }else if(linha.contains("R")){
                    System.out.println("(R) " + pilha.remover().getNome());
                }
            }
            pilha.Print();
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}

//Metodo da Pilha com Alocação Sequencial
class Pilha{
    private Time[] array;
    private int top;

    //Construtor da classe.
    public Pilha(){
        this(6);
    }

    /**
     * Construtor da classe
     * @param tam Tamanho da Pilha
     */
    public Pilha(int tam){
        array = new Time[tam];
        top = 0;
    }

    /**
     * Método para inserir um elemento na ultima posição da pilha.
     * @param time o objeto(Time) a ser inserido.
     * @throws Exception Caso a pilha esteja cheia, retorna um erro
     */
    public void inserir(Time time) throws Exception{
        //validar inserção
        if(top>= array.length){
            throw new Exception("Erro ao Inserir!");
        }
        array[top] = time.clone();
        top++;
    }

    /**
     * Método para remover o elemento na ultima posição da pilha.
     * @return array com o elemento na ultima posição deletado(Removido)
     * @throws Exception Caso a pilha estiver vazia, retornar um erro
     */
    public Time remover() throws Exception{
        //validar remocao
        if (top == 0) {
            throw new Exception("Erro ao remover!");
        }
        return array[--top].clone();
    }

    /**
     * Método para printar os elementos dentro do array
     */
    public void Print(){
        for(int i = 0; i < top; i++){
            array[i].Print();
        }
    }

    /**
     * Método para verificar se a pilha estiver vazia.
     * @return  true: Caso a pilha estiver vazia.
     *          false: Caso a pilha não estiver vazia.
     */
    public boolean isVazia(){
        if(top == 0) return true;
        else return false;
    }
}

class Time{
    private int capacidade, FundacaoDia, FundacaoMes, FundacaoAno;
    
    private String nome, apelido, estadio, tecnico, liga, nomeArquivo;

    private long paginaTamBytes;

    //Encapsulamento

    /** Metodo construtor vazio
        *@param   capacidade int
        *@param   FundacaoDia int
        *@param   FundacaoMes int
        *@param   FundacaoAno int
        *@param   nome String
        *@param   apelido String
        *@param   estadio String
        *@param   tecnico String
        *@param   liga String
        *@param   nomeArquivo String
        *@param   paginaTamBytes long
    */

    public Time(){
        capacidade = 0;
        FundacaoDia = 0;
        FundacaoMes = 0;
        FundacaoAno = 0;
        nome = "";
        apelido = "";
        estadio = "";
        tecnico = "";
        liga = "";
        nomeArquivo = "";
        paginaTamBytes = 0;
    }

    /** Metodo construtor
        *@param   capacidade int
        *@param   FundacaoDia int
        *@param   FundacaoMes int
        *@param   FundacaoAno int
        *@param   nome String
        *@param   apelido String
        *@param   estadio String
        *@param   tecnico String
        *@param   liga String
        *@param   nomeArquivo String
        *@param   paginaTamBytes long
    */

    public Time(int capacidade, int FundacaoDia, int FundacaoMes, int FundacaoAno, String nome, String apelido, String estadio, String tecnico, String liga, String nomeArquivo,  long paginaTamBytes){
		this.setCapacidade(capacidade);
		this.setFundacaoDia(FundacaoDia);
		this.setFundacaoMes(FundacaoMes);
		this.setFundacaoAno(FundacaoAno);
		this.setNome(nome);
		this.setApelido(apelido);
		this.setEstadio(estadio);
		this.setTecnico(tecnico);
		this.setLiga(liga);
		this.setNomeArquivo(nomeArquivo);
        this.setPaginaTam(paginaTamBytes);
    }

    /** Metodo clone
        *@return   capacidade int
        *@return   FundacaoDia int
        *@return   FundacaoMes int
        *@return   FundacaoAno int
        *@return   nome String
        *@return   apelido String
        *@return   estadio String
        *@return   tecnico String
        *@return   liga String
        *@return   nomeArquivo String
        *@return   paginaTamBytes long
    */

    public Time clone(){
        return new Time(getCapacidade(), getFundacaoDia(), getFundacaoMes(), getFundacaoDia(), getNome(), getApelido(), getEstadio(), getTecnico(), getLiga(), getNomeArquivo(), getPaginaTam());
    }

    //Setters

    void setCapacidade(int Capacidade){
        capacidade = Capacidade;
    }

    void setFundacaoDia(int FunDia){
        FundacaoDia = FunDia;
    }
	
    void setFundacaoMes(int FunMes){
        FundacaoMes = FunMes;
    }
    void setFundacaoAno(int FunAno){
        FundacaoAno = FunAno;
    }

    void setNome(String Nome){
        nome = Nome;
    }
    
    void setApelido(String Apelido){
        apelido = Apelido;
    }

    void setEstadio(String Estadio){
        estadio = Estadio;
    }

    void setTecnico(String Tecnico){
        tecnico = Tecnico;
    }
    
    void setLiga(String Liga){
        liga = Liga;
    }

    void setNomeArquivo(String NomeArquivo){
        nomeArquivo = NomeArquivo;
    }

    void setPaginaTam(long PaginaTam){
        paginaTamBytes = PaginaTam;
    }

    //Getters

    int getCapacidade(){
        return capacidade;
    }

    int getFundacaoDia(){
        return FundacaoDia;
    }

    int getFundacaoMes(){
		return FundacaoMes;
    }

    int getFundacaoAno(){
		return FundacaoAno;
    }

    String getNome(){
		return nome;
    }

    String getApelido(){
		return apelido;
    }

    String getEstadio(){
		return estadio;
    }

    String getTecnico(){
		return tecnico;
    }

    String getLiga(){
		return liga;
    }

    String getNomeArquivo(){
		return nomeArquivo;
    }

    long getPaginaTam(){
        return paginaTamBytes;
    }

    /**
     * Remover as Tags do arquivo html
     * Exemplo: remove <br>, <p>, <n> e etc.
     * @param linha = A linha do arquivo onde tem tag
     * @return a linha sem os Tags
     */

    String RemoveTag(String linha){
        for(int i = linha.indexOf("<"); linha.contains("<") && linha.contains(">"); i = linha.indexOf("<")){
            int j = linha.indexOf(">");
            linha = linha.replace(linha.substring( i, (j + 1)), "");
        }

        return linha;
    }

    public String removeTag(String s){
        s = s.replaceAll("<[^?>]*>", "");
		s = s.replaceAll("1&#93", "");
		s = s.replaceAll("&#91", "");
		s = s.replaceAll(";", "");
		s = s.replaceAll("&.*?;", "");
        
        return s;
    }

    public int getMes(String s){
        if(s.contains("january") == true){
            return 1;
        }else if(s.contains("february") == true){
            return 2;
        }else if(s.contains("march") == true){
            return 3;
        }else if(s.contains("april") == true){
            return 4;
        }else if(s.contains("may") == true){
            return 5;
        }else if(s.contains("june") == true){
            return 6;
        }else if(s.contains("july") == true){
            return 7;
        }else if(s.contains("august") == true){
            return 8;
        }else if(s.contains("september") == true){
            return 9;
        }else if(s.contains("october") == true){
            return 10;
        }else if(s.contains("november") == true){
            return 11;
        }else if(s.contains("december") == true){
            return 12;
        }

        return 0;
    }

    /**
     * Metodo para a leitura do arquivo mandado
     * @param url nome da pagina pesquisada
     */

    public void leitura(String url){
        try{
            int contNome = 0, contApelido = 0, contdia = 0, contAno = 0, contFund = 0, contEstadio = 0, contCapacidade = 0, contCoach = 0, contLeague = 0;
            String FilePath = "./Códigos Java/Programação Orientada a Objetos(POO)/Banco de Dados/Times/" + url;
            File file = new File(FilePath);


            Scanner leitor = new Scanner(file, "ISO-8859-1");

            this.setNomeArquivo(url);
            
            long bytes = Files.size(Paths.get(FilePath));

            this.setPaginaTam(bytes);

            this.setNomeArquivo(FilePath);

            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();

                if(leitor.hasNextLine()){
                    //Nome
                    if(linha.contains("Full name") && contNome == 0){
                        String[] test = linha.split("Full name");
                        String[] info = test[1].split("Nickname");
                        String Name = info[0];

                        Name = removeTag(Name);

                        
                        setNome(Name);
                        contNome++;
                    }

                    //Apelido
                    if(linha.contains("Nickname(s)") && contApelido == 0){
                        String[] test = linha.split("Nickname");                                               
                        String[] info = test[1].split("Founded");
                        String Apelido = info[0];
                        if(Apelido.contains("Short name")){
                            String[] limpa = Apelido.split("Short name");
                            Apelido = limpa[0];
                        }
                        Apelido = removeTag(Apelido);
                        Apelido = Apelido.substring(3);
                        
                        this.setApelido(Apelido);
                        contApelido++;
                    }

                    //Fundação

                    if(linha.contains("Founded") && contFund == 0){
                        String[] test = linha.split("Founded");
                        String[] info = test[1].split("Ground");

                        String fund = removeTag(info[0]);

                        int mes = this.getMes(fund.toLowerCase());

                        if(mes != 0){
                            this.setFundacaoMes(mes);

                            //Remover todas as letras na String

                            //Remover non-breaking space no html ( &#160 )
                            String[] funda = fund.split("&#160|&#59| |,");

                            for(int i = 0; i < funda.length; i++){
                                if((funda[i].length() == 2 || funda[i].length() == 1) && contdia == 0){
                                    if(Character.getNumericValue(funda[i].charAt(0)) < 10 && Character.getNumericValue(funda[i].charAt(0)) >= 0){
                                        String dia = funda[i];
                                        int diaInt = Integer.parseInt(dia);
                                        this.setFundacaoDia(diaInt);
                                    }
                                    contdia++;
                                }else if(funda[i].length() == 4 && contAno == 0){

                                    boolean LegitYear = true;
                                    for(int j = 0; j < 4; j++){
                                        if(!(Character.getNumericValue(funda[i].charAt(j)) < 10 && Character.getNumericValue(funda[i].charAt(j)) >= 0)){
                                            LegitYear = false;
                                        }
                                    }
                                    if(LegitYear){
                                        String ano = funda[i];
                                        int anoInt = Integer.parseInt(ano);

                                        this.setFundacaoAno(anoInt);
                                        contAno++;
                                    }
                                }

                            }

                            if(contdia == 0) this.setFundacaoDia(0);
                            if(contAno == 0) this.setFundacaoAno(0);

                        }else{
                            this.setFundacaoDia(0);
                            this.setFundacaoMes(0);
                            String ano = fund.substring(0, 4);
                            int anoInt = Integer.parseInt(ano);
                            this.setFundacaoAno(anoInt);
                        }


                        contFund++;
                    }

                    //Estadio
                    if(linha.contains("Ground") && contEstadio == 0){
                        String[] test = linha.split("Ground", 2);
                        String[] info = test[1].split("</a>");
                        String[] Stadium = info[0].split(">");

                        int x = Stadium.length - 1;

                        this.setEstadio(Stadium[x]);

                        contEstadio++;
                    }

                    //Capacidade
                    if(linha.contains("Capacity") && contCapacidade == 0){
                        String[] test = linha.split("Capacity");
                        String[] info = test[1].split("<td>");
                        String[] info2 = info[1].split("<|/|\\(|;| ");

                        String cap = info2[0];
                        cap = cap.replaceAll(",", "");
                        cap = cap.replaceAll("\\.", "");

                        int Cap = Integer.parseInt(cap);

                        this.setCapacidade(Cap);

                        contCapacidade++;

                    }

                    //Coach
                    if((linha.toLowerCase().contains("coach") || linha.toLowerCase().contains("manager")) && contCoach == 0){
                        if(linha.contains("Manager") && contCoach == 0){
                            String[] test = linha.split("Manager");
                            String[] info = test[1].split("League");

                            String Coach = removeTag(info[0]);
                            if(Coach.contains(">")){
                                String[] line = Coach.split(">");
                                this.setTecnico(line[1]);
                            }else{
                                this.setTecnico(Coach);
                            }
                            contCoach++;
                        }
                        if(linha.contains("Coach") && contCoach == 0){
                            String[] test = linha.split("Coach");
                            String[] info = test[1].split("League");
                            
                            String Coach = removeTag(info[0]);
                            if(Coach.contains(">")){
                                String[] line = Coach.split(">");
                                this.setTecnico(line[1]);
                            }else{
                                this.setTecnico(Coach);
                            }
                            contCoach++;
                        }
                        if(linha.contains("coach") && contCoach == 0){
                            String[] test = linha.split("coach");
                            String[] info = test[1].split("League");
                            
                            String Coach = removeTag(info[0]);

                            if(Coach.contains(">")){
                                String[] line = Coach.split(">");
                                this.setTecnico(line[1]);
                            }else{
                                this.setTecnico(Coach);
                            }
                            contCoach++;
                        }

                        //League
                        if(linha.contains("League") && contLeague == 0){
                            String[] test = linha.split("League", 2);
                            String[] info = test[1].split("</a>");

                            String league = removeTag(info[0]);

                            this.setLiga(league);

                            contLeague++;
                        }
                    }
                }
            }
            leitor.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    /** Metodo Print
        *@return   capacidade int
        *@return   FundacaoDia int
        *@return   FundacaoMes int
        *@return   FundacaoAno int
        *@return   nome String
        *@return   apelido String
        *@return   estadio String
        *@return   tecnico String
        *@return   liga String
        *@return   nomeArquivo String
        *@return   paginaTamBytes long
    */

    public void Print(){
        String Nome = convertUTF8toISO(this.getNome());
        String Apelido = convertUTF8toISO(this.getApelido());
        String Tecnico = convertUTF8toISO(this.getTecnico());
        String Liga = convertUTF8toISO(this.getLiga());
        String Estadio = convertUTF8toISO(this.getEstadio());

        System.out.println();
        System.out.println("Nome: " + Nome); 
        System.out.println("Nome do Arquivo: " + this.getNomeArquivo() + " Tamanho do Arquivo: " + this.getPaginaTam() + " bytes");      
        System.out.println("Apelido: " + Apelido);
        System.out.println("Data da Fundação: " + this.getFundacaoDia() + "/" + this.getFundacaoMes() + "/" + this.getFundacaoAno());
        System.out.println("Tecnico: " + Tecnico);
        System.out.println("Liga: " + Liga);
        System.out.println("Estadio: " + Estadio);
        System.out.println("Capacidade: " + this.getCapacidade());

    }

    public static String convertUTF8toISO(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return ret;
    }
}
