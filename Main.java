public class Main {
    public static void main(String[] args) {
        Crud teste = new Crud();
        Disciplina Algebra = new Disciplina("Algebra");
        Aluno Yuri = new Aluno("Yuri", "VFVFVFVFVF");
        Algebra.addAluno(Yuri);
        
        Aluno Diogo = new Aluno("Diogo", "VVVVVVVVVV");

        if(teste.createFile("Algebra"))
            System.out.println("Arquivo criado com sucesso");
        else    
            System.out.println("Arquivo já existe");


        if(teste.createStudent( Algebra, Diogo))
            System.out.println("Aluno add");
        else{
            System.out.println("Não foi possível add");
        }


    }
}
