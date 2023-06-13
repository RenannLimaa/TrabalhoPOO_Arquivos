import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Crud crud = new Crud();

        Disciplina disciplina;
        Aluno aluno;
        File file;

        Scanner input = new Scanner(System.in);
        String nomeDisciplina;
        Integer comando;
        
        tela.ClearConsole();
        System.out.println("Bem vindo ao Sistema de Gabarito UECE");
        tela.mostrarTelaInicial();

        System.out.println("Digite o número respectivo ao que você deseja fazer");
        comando = input.nextInt();
        clearBuffer(input);
        tela.ClearConsole();


        switch(comando) {
            case 1: 
                System.out.println("Digite o nome da disciplina que deseja adicionar");

                nomeDisciplina = input.nextLine();
                disciplina = new Disciplina(nomeDisciplina);
                crud.createFile(nomeDisciplina);
                break;

            case 2: 
                tela.selecionarDisciplina();
                break;
            case 3: 
                System.exit(0);
        }





    
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
}  

