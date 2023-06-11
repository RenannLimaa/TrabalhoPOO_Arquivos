import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Disciplina {
    private String nome;
    private ArrayList <Aluno> alunos;


    
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
        
        sortNotas();
        
        for (Aluno aluno : alunos) {
            write.writeFile(aluno.toStringNota(), "Data/Relatório" + nome +".txt");
        }
    }

    public void sortNotas(){
        for(int i = 0; i < alunos.size(); i++){
            for (int j = i+1; j < alunos.size(); j++){
                if(alunos.get(i).getNota() < alunos.get(j).getNota() ){
                    Collections.swap(alunos, i, j);
                }
            }
        }
    }
    
    
    public void corrigirProvas(String gabaritoFile){
        String resposta  = "";
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
            if(aluno.getResposta().equals("VVVVVVVVVV") || aluno.getResposta().equals("FFFFFFFFFF")){
                aluno.setNota(0);
                continue;
            }
            int pontos = 0;
            for(int i = 0; i < 10 ; i++){
                if(resposta.charAt(i) == aluno.getResposta().charAt(i))
                    pontos++;
            }
            aluno.setNota(pontos);
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    
    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}
