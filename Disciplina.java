import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Disciplina {
    public String nome;
    public ArrayList <Aluno> alunos;


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

    public void gerarResultado(){
        Crud write = new Crud();
        corrigirProvas(nome);

        for (Aluno aluno : alunos) {
            write.writeFile(aluno.toString(), "Data/Relatório" + nome +".txt");
        }

    } 


    public void corrigirProvas(String gabaritoFile){
        int pontos = 0;
        Crud read = new Crud();
        String gabarito = read.readGabarito(gabaritoFile);

        for (Aluno aluno : alunos) {
            if(aluno.resposta.equals("VVVVVVVVVV") || aluno.resposta.equals("FFFFFFFFFF")){
                continue;
            }
            for(int i = 0; i < 10 ; i++){
                if(gabarito.charAt(i) == aluno.resposta.charAt(i))
                    pontos++;
            }
            aluno.nota = pontos;
        }
    }

   

    
}
