import java.io.*;
import java.util.ArrayList;

public class Crud {
    
    public boolean createStudent(String disciplina, Aluno aluno){
        File file = new File("Data/"+disciplina + ".txt");
        try {
            ObjectOutputStream objWriter = new ObjectOutputStream(new FileOutputStream(file));
            objWriter.writeObject(aluno);
            objWriter.close();
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


    public boolean createFile(String disciplina){

        File file = new File("Data/"+disciplina+".txt");
        try {
            return file.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }
}
