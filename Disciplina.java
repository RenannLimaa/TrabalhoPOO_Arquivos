import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

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

    public void gerarLista(){
        Crud write = new Crud();
        corrigirProvas(nome);
        sortByName(alunos);

        for (Aluno aluno : alunos) {
            write.writeFile(aluno.toStringNota(), "Data/"+nome+"/Relatório/Lista.txt");
        }
    }
    private static void sortByName(ArrayList<Aluno> alunos) {
        Collections.sort(alunos, new AlunoComparator());
    }
    
    public void gerarRanking(){
        Crud write = new Crud();
        corrigirProvas(nome);
        sortNotas();

        for (Aluno aluno : alunos) {
            write.writeFile(aluno.toStringNota(), "Data/"+nome+"/Relatório/ranking.txt");
        }
    }

    public void sortNotas(){
        for(int i = 0; i < alunos.size(); i++){
            for (int j = i+1; j < alunos.size(); j++){
                if(alunos.get(i).nota < alunos.get(j).nota ){
                    Collections.swap(alunos, i, j);
                }
            }
        }
    }


    public void corrigirProvas(String gabaritoFile){
        String resposta  = "";
        try {
            FileReader fReader = new FileReader("Data/"+nome+"/" +  gabaritoFile + ".txt");
            BufferedReader bReader = new BufferedReader(fReader);
            resposta = bReader.readLine();
            fReader.close();
            bReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Aluno aluno : alunos) {
            if(aluno.resposta.equals("VVVVVVVVVV") || aluno.resposta.equals("FFFFFFFFFF")){
                aluno.nota = 0;
                continue;
            }
            int pontos = 0;
            for(int i = 0; i < 10 ; i++){
                if(resposta.charAt(i) == aluno.resposta.charAt(i))
                    pontos++;
            }
            aluno.nota = pontos;
        }
    }

    
}
