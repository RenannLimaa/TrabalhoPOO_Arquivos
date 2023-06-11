import java.io.*;

public class Crud {
    
    public boolean createStudent(Disciplina disciplina, Aluno aluno){
        
        try {
            FileWriter fWriter = new FileWriter("Data/"+disciplina.nome+"/"+disciplina.nome + ".txt", true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(aluno.toString());
            bWriter.newLine();
            bWriter.close();
            fWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    public void readFile(Disciplina disciplina){
        disciplina.alunos.clear();
        Aluno aluno;
        FileReader fReader;

        try{
            fReader = new FileReader("Data/"+disciplina.nome+"/"+disciplina.nome+".txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String linha = bReader.readLine();
            while(linha != null){
                String[] dados = linha.split("\t");
                aluno = new Aluno(dados[1], dados[0]);
                disciplina.alunos.add(aluno);
                linha = bReader.readLine();

            }
            fReader.close();
            bReader.close();
        }catch(Exception e){
           return;
        }
    }

    public boolean writeFile(String content, String file ){
        try {
            FileWriter fWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(content);
            bWriter.newLine();
            bWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    public String readGabarito(String disciplina,String gabaritoFile){
        String resposta = "";
        try {
            FileReader fReader = new FileReader("Data/"+disciplina+"/" +  gabaritoFile + ".txt");
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
    public boolean createDirectory(String nome){
        File diretorio = new File("Data/"+nome+"/Relatório");
        if(diretorio.mkdirs()){
            return true;
        }
        return false;
    }
    public boolean createFile(String disciplina){
        if(createDirectory(disciplina)){

            File file = new File("Data/"+disciplina+"/"+disciplina+".txt");
            try {
                return file.createNewFile();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
