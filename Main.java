public class Main {
    public static void main(String[] args) {
        Crud teste = new Crud();
        Disciplina Algebra = new Disciplina("Algebra");
        Aluno aluno1 = new Aluno("Yuri", "VFVFVFVFVF");
        Aluno aluno2 = new Aluno("Renan", "VFVFVFVFVF");
        Aluno aluno3 = new Aluno("Diogo", "VVVVVVVVVV");

        Algebra.addAluno(aluno1);
        Algebra.addAluno(aluno2);
        Algebra.addAluno(aluno3);

        teste.createFile("Algebra");
        if(teste.createStudent(Algebra, aluno1)){

        }
        if(teste.createStudent(Algebra, aluno2)){

        }
        if(teste.createStudent(Algebra, aluno3)){

        }
        
        /* Algebra.alunos = teste.readFile("Algebra");

        for (Aluno aluno: Algebra.alunos) {
            System.out.println(aluno.nome);
        }  */

        


    }
}
