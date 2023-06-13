import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Crud teste = new Crud();
        String nomeDisciplina;
        Disciplina disciplina;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome da disciplina que deseja acessar");
        nomeDisciplina = input.nextLine();
        disciplina = new Disciplina(nomeDisciplina);


        teste.readFile(disciplina);
        for(Aluno aluno: disciplina.getAlunos()) {
            System.out.println(aluno.getNome());
        }
        
        input.close(); 
        /* O código não vai ficar assim na main original, mas como fiz sem o código atualizado, precisei fazer assim */
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
}  


