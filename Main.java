
public class Main {
    public static void main(String[] args) {
        Crud teste = new Crud();
        Disciplina algebra = new Disciplina("Algebra");
        /* 
        Aluno aluno1 = new Aluno("Emanuel", "VVVVVFFFFF");
        Aluno aluno2 = new Aluno("Gabriel", "FFFFFVVVVV");
        Aluno aluno3 = new Aluno("Diego", "VVVVVVVFFF");

        algebra.addAluno(aluno1);
        algebra.addAluno(aluno2);
        algebra.addAluno(aluno3);

        teste.createFile("Algebra");
        if(teste.createStudent(algebra, aluno1)){
            System.out.println("aluno criado com sucesso");

        }
        if(teste.createStudent(algebra, aluno2)){
            System.out.println("aluno criado com sucesso");

        }
        if(teste.createStudent(algebra, aluno3)){
            System.out.println("aluno criado com sucesso");


        }   */
        
          teste.readFile(algebra);

        for (Aluno aluno: algebra.getAlunos()) {
            System.out.println(aluno.getNome() +" "+aluno.getResposta());
        } 

        algebra.gerarLista();
    
    }
    
}  


