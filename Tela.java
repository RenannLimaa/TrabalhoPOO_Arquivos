import java.io.File;
import java.util.Scanner;

public class Tela {
    Scanner input = new Scanner(System.in);
    File file;
    Crud crud = new Crud();

    public void mostrarTelaInicial() {
        System.out.println("1. Adicionar disciplina");
        System.out.println("2. Consultar disciplinas");
        System.out.println("3. Sair do programa");  // System.exit();
    }

    public void mostrarDisciplinas() {
        File CaminhoDoDiretorio = new File("Data");
        File listaDeArquivos[] = CaminhoDoDiretorio.listFiles();

        if(listaDeArquivos.length == 0)
            System.out.println("O diretorio esta vazio");

        else {
            for(File arquivo: listaDeArquivos) {
                System.out.println(arquivo.getName());
            }
        }
    }

    public void mostrarTelaDisciplina(String nomeDisciplina) {
        System.out.println("--------------------------"+ nomeDisciplina+ "--------------------------");

        System.out.println("1. Matricular aluno ");
        System.out.println("2. Mostrar alunos matriculados");
        System.out.println("3. Mostrar resultados da disciplina");
        System.out.println("4. Voltar para tela inicial");
    }

    public void selecionarDisciplina() {
        String nomeDisciplina;
        Scanner input = new Scanner(System.in);
        Disciplina disciplina;
        Integer comando;

        mostrarDisciplinas();
        System.out.println("Digite o nome da disciplina que deseja consultar");
        nomeDisciplina = input.nextLine();
        ClearConsole();

        disciplina = new Disciplina(nomeDisciplina);  
        file = new File("Data/" + nomeDisciplina);

        if(file.exists() == false) {
            return;
        }
        
        crud.readFile(disciplina);
        mostrarTelaDisciplina(nomeDisciplina);

        System.out.println("Digite o numero respectivo ao que você deseja fazer");
        comando = input.nextInt();
        ClearConsole();

        switch (comando) {
            case 1:
                mostrarTelaAluno();                        
                
                break;
            case 2:
                for(Aluno newAluno: disciplina.getAlunos()) {
                    System.out.println(newAluno.getNome());
                }

                break;
            
            case 3: 
                
                break;
        
            case 4: 
                
            default:
                break;
            
        }

    }

    public Aluno mostrarTelaAluno() {
        Aluno aluno;
        String nome, respostas;
        System.out.println("Digite o nome do aluno");
       
        nome = input.nextLine();

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
}