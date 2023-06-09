import java.io.*;

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


    public boolean createFile(String disciplina){

        File file = new File("Data/"+disciplina+".txt");
        try {
            return file.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }
}
