import java.io.File;
import java.util.Scanner;

public class Tela {
    Scanner input = new Scanner(System.in);

    public void mostrarTelaInicial() {
        System.out.println("1. Adicionar disciplina");
        System.out.println("2. Consultar disciplina");
        System.out.println("Sair do programa");  // System.exit();
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

    public void mostrarTelaDisciplina() {
        System.out.println("1. Matricular alunos ");
        System.out.println("2. Mostrar alunos matriculados");
        System.out.println("3. Mostrar resultados da disciplina");
        System.out.println("4. Voltar para tela inicial");
    }

    public Aluno mostrarTelaAluno(Aluno aluno) {
        String nome, respostas;
        System.out.println("Digite o nome do aluno");
       
        nome = input.nextLine();
        aluno.setNome(nome);

        System.out.println("Digite o cartao resposta do aluno:");
        respostas = input.nextLine();

        aluno.setRespostas(respostas);


        return aluno;
    }
}