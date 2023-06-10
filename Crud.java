import java.io.*;

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


    public boolean createFile(String disciplina){

        File file = new File("Data/"+disciplina+".txt");
        try {
            return file.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }
}
