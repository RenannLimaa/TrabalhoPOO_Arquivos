public class Main {
    public static void main(String[] args) {
        Crud teste = new Crud();
        Disciplina Algebra = new Disciplina("Algebra");
        
        Algebra.alunos = teste.readFile("Algebra");

        /* for (Aluno aluno: Algebra.alunos) {
            System.out.println(aluno.nome);
        } */

        


    }
}
