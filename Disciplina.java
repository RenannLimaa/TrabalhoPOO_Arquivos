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

    public void corrigirProvas(String gabaritoFile){
        String resposta  = "";
        int pontos = 0;
        try {
            FileReader fReader = new FileReader("Data/" +  gabaritoFile + ".txt");
            BufferedReader bReader = new BufferedReader(fReader);
            resposta = bReader.readLine();
            fReader.close();
            bReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Aluno aluno : alunos) {
            for(int i = 0; i < 10 ; i++){
                if(resposta.charAt(i) == aluno.respostas.charAt(i))
                    pontos++;
            }
            aluno.nota = pontos;
        }
    }

    
}
