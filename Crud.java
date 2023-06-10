import java.io.*;
import java.util.ArrayList;

public class Crud {
    
    public boolean createStudent(Disciplina disciplina, Aluno aluno){
        
        try {
            FileWriter fWriter = new FileWriter("Data/"+ disciplina.nome + ".txt", true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(aluno.toSting());
            bWriter.newLine();
            bWriter.close();
            fWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public ArrayList<Aluno> readFile(String disciplina){
        ArrayList <Aluno> alunos = new ArrayList<Aluno>();
        Aluno aluno;
        String dados[], linha;
        
        try{
            FileReader fileReader = new FileReader("Data/"+disciplina+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            linha = bufferedReader.readLine();
            while(linha != null){
                dados = linha.split("\t");
                aluno =new Aluno(dados[1], dados[0]);
                alunos.add(aluno);

            }
            fileReader.close();
            bufferedReader.close();
        } catch(Exception e){
            return null;
        }
        

        return alunos;

    }

    public String readGabarito(String gabaritoFile){
        String resposta = "";
        try {
            FileReader fReader = new FileReader("Data/" +  gabaritoFile + ".txt");
            BufferedReader bReader = new BufferedReader(fReader);
            resposta = bReader.readLine();
            fReader.close();
            bReader.close();
            return resposta;
        } catch (Exception e) {
            System.out.println(e);
            return "arquivo corrompido";
        }
    }


    public boolean createFile(String disciplina){

        File file = new File("Data/"+disciplina+".txt");
        try {
            return file.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }
}
