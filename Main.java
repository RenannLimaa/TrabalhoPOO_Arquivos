import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Disciplina disciplina;
        Scanner input = new Scanner(System.in);
        int comando;

        do {

            tela.ClearConsole();
            System.out.println("------------------- Bem vindo ao Sistema de Gabarito UECE -------------------\n\n");
            tela.mostrarTelaInicial();
    
            System.out.println("\nDigite o número respectivo ao que você deseja fazer: ");
            comando = input.nextInt();
            clearBuffer(input);
            tela.ClearConsole();
    
    
            switch(comando) {
                case 1: 
                    tela.criarDisciplina();
                    break;
    
                case 2: 
                    disciplina = tela.selecionarDisciplina();
                    if(disciplina == null){
                        System.out.println("Arquivo não encontrado.");
                        tela.mostrarTransição(2000);
                        break;
                    }
                    tela.mostrarMenuDisciplina(disciplina);
                    break;
                case 3: 
                    comando = -1;
                    break;
            }
            
        } while (comando != -1);
        
    
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
}  

