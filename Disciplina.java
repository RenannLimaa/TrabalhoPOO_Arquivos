import java.io.BufferedReader;
import java.io.FileReader;
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

    public boolean gerarResultado(ArrayList<Aluno> alunos){
         

        return false;
    } 
    public void corrigirProvas(String gabaritoFile){
        int pontos = 0;
        Crud read = new Crud();
        String gabarito = read.readGabarito(gabaritoFile);

        for (Aluno aluno : alunos) {
            for(int i = 0; i < 10 ; i++){
                if(gabarito.charAt(i) == aluno.resposta.charAt(i))
                    pontos++;
            }
            aluno.nota = pontos;
        }
    }

    
}
