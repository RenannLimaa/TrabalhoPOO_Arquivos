import java.io.File;
import java.util.Scanner;

public class Tela {
    private Scanner input = new Scanner(System.in);
    private File file;
    private Controller controller = new Controller();
    private String nomeDisciplina;
    private String gabarito;
    private Aluno aluno;

    public void mostrarTelaInicial() {
        System.out.println("1. Adicionar disciplina");
        System.out.println("2. Consultar disciplinas");
        System.out.println("3. Sair do programa");  // System.exit();
    }

    public void criarDisciplina(){
        Disciplina disciplina;

        System.out.println("Digite o nome da disciplina que deseja adicionar");
        nomeDisciplina = input.nextLine();
        
        disciplina = new Disciplina(nomeDisciplina);
        controller.createFile(nomeDisciplina);

        System.out.println("Disciplina criada com sucesso.");
        mostrarTransição(2000);
    }

    public void mostrarDisciplinas() {
        File CaminhoDoDiretorio = new File("Data");
        File listaDeArquivos[] = CaminhoDoDiretorio.listFiles();

        if(listaDeArquivos.length == 0)
            System.out.println("O diretorio esta vazio");

        else {
            System.out.println("            DISCIPLINAS");
            System.out.println("------------------------------------");
            for(File arquivo: listaDeArquivos) {
                System.out.println(arquivo.getName());
                System.out.println("------------------------------------");
            }
        }
    }

    public Disciplina selecionarDisciplina() {
        Scanner input = new Scanner(System.in);
        Disciplina disciplina;

        System.out.println("Disciplinas cadastradas no sistema: \n");
        mostrarDisciplinas();
        System.out.println("\nDigite o nome da disciplina que deseja consultar: ");
        nomeDisciplina = input.nextLine();
        ClearConsole();

        disciplina = new Disciplina(nomeDisciplina);  
        file = new File("Data/" + nomeDisciplina);

        if(file.exists() == false) {
            return null;
        }
        
        controller.readFile(disciplina);

        return disciplina;

    }


    public void mostrarMenuDisciplina(String nomeDisciplina) {
        System.out.println("-------------------------- "+ nomeDisciplina+ " --------------------------");

        System.out.println("\n\n1. Matricular aluno ");
        System.out.println("2. Mostrar alunos matriculados");
        System.out.println("3. Gerar resultados da disciplina");
        System.out.println("4. Adicionar ou editar gabarito");
        System.out.println("5. Voltar para tela inicial");
    }


    public void mostrarMenuDisciplina(Disciplina disciplina){
        int comando = -1;


        while(comando != 5){

            ClearConsole();
            mostrarMenuDisciplina(disciplina.getNome());
    
            System.out.println("\nDigite o numero respectivo ao que você deseja fazer");
            comando = input.nextInt();
            clearBuffer(input);
            ClearConsole();

            switch (comando) {
            case 1:
                aluno = cadastrarAluno();   
                controller.createStudent(disciplina, aluno);                   
                
                break;
            case 2:
                controller.readFile(disciplina);
                mostrarAlunos(disciplina);
                mostrarTransição(3000);
                break;
            
            case 3: 
                file = new File("Data/"+disciplina.getNome()+"/Gabarito.txt");
                if(disciplina.getAlunos().isEmpty()){
                    System.out.println( disciplina.getNome() +" não possui alunos matriculados");
                    mostrarTransição(2000);
                    break;
                }
                
                if(file.exists()==false){
                    System.out.println( disciplina.getNome() +" não possui gabarito");
                    mostrarTransição(2000);
                    break;
                }
                controller.readFile(disciplina);
                disciplina.gerarLista();
                disciplina.gerarRanking();
                System.out.println("Arquivos com resultados gerados com sucesso.");
                mostrarTransição(2000);
                break;

            case 4:

                System.out.println("Digite o gabarito para " + disciplina.getNome());
                gabarito = input.nextLine();

                File file = new File("Data/"+ nomeDisciplina +"/Gabarito.txt");

                if(file.exists())
                    file.delete();

                controller.writeFile(gabarito, "Data/"+ nomeDisciplina +"/Gabarito.txt" );    

                System.out.println("Gabarito adicionado com sucesso.");
                mostrarTransição(2000);

                break;
        
            default:
                
                break;
            
        }
        }
        
    }

    public void mostrarAlunos(Disciplina disciplina){
        if(disciplina.getAlunos().isEmpty()){
                    System.out.println( disciplina.getNome() +" não possui alunos matriculados");
                    return;
        }

        System.out.println("                    ALUNOS");
        System.out.println("---------------------------------------------");

        for(Aluno aluno: disciplina.getAlunos()) {
            System.out.println(aluno.getNome());
            System.out.println("---------------------------------------------");
        }
    }

    public Aluno cadastrarAluno() {
        Aluno aluno;
        String nome, respostas;
        System.out.println("Digite o nome do aluno: ");
       
/*         clearBuffer(input);
 */        nome = input.nextLine();
        

        System.out.println("Digite o cartao resposta do aluno:");
        respostas = input.nextLine();

        aluno = new Aluno(nome, respostas);


        return aluno;
    }

    public void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name");
            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
    
                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void mostrarTransição(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            // TODO: handle exception
        }
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}