import java.io.BufferedReader;
import java.io.File;
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

    public void gerarLista(){
        File file = new File("Data/"+nome+"/Relatório/Lista.txt");
        Crud write = new Crud();
        double media = 0;

        if(file.exists()){
            file.delete();
        }

        corrigirProvas();
        sortByName(alunos);

        for (Aluno aluno : alunos) {
            write.writeFile(aluno.toStringNota(), "Data/"+nome+"/Relatório/Lista.txt");
            media += aluno.getNota();
        }

            media /= alunos.size();
            write.writeFile("\nMedia geral:  " + media, "Data/"+nome+"/Relatório/Lista.txt");
    }
    private static void sortByName(ArrayList<Aluno> alunos) {
        Collections.sort(alunos, new AlunoComparator());
    }
    
    public void gerarRanking(){
        File file = new File("Data/"+nome+"/Relatório/Ranking.txt");
        Crud write = new Crud();
        double media = 0;

        if(file.exists()){
            file.delete();
        }
        corrigirProvas();
        Collections.sort(alunos);
        

        for (Aluno aluno : alunos) {
            write.writeFile(aluno.toStringNota(), "Data/"+nome+"/Relatório/Ranking.txt");
            media += aluno.getNota();
        }
            media /= alunos.size();
            write.writeFile("\nMedia geral:  " + media, "Data/"+nome+"/Relatório/Ranking.txt");
    }

    
    public void corrigirProvas(){
        String resposta  = "";
        try {
            FileReader fReader = new FileReader("Data/"+nome+"/Gabarito.txt");
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
