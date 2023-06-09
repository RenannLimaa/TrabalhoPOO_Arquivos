import java.util.ArrayList;

public class Disciplina {
    String nome;
    ArrayList <Aluno> alunos;


    public Disciplina (String nome){
        this.nome = nome;
        alunos = new ArrayList<Aluno>();
    }

    public boolean addAluno(Aluno newAluno){
        if(alunos.contains(newAluno))
            return false;

        alunos.add(newAluno);
        return true;
    }

    
}
