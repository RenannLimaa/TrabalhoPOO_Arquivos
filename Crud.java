import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Crud {
    
    public boolean createStudent(Disciplina disciplina, Aluno aluno){
        
        try {
            FileWriter fWriter = new FileWriter(disciplina.nome + ".txt", true);
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
    public ArrayList<Aluno> readFile(String disciplina){
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        Aluno aluno = new Aluno();
        
        try{
            FileReader fileReader = new FileReader("Data/"+disciplina+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = bufferedReader.readLine();
            while(linha != null){
                String[] dados = linha.split("\t");
                System.out.println(dados[1] + dados[0]);
                System.out.println(aluno.toString());
                alunos.add(aluno);
                linha = bufferedReader.readLine();

            }
            fileReader.close();
            bufferedReader.close();
        } catch(Exception e){
            System.out.println("entrou");
            Scanner teclado = new Scanner(System.in);
            teclado.nextLine();
            return null;
        }
        
        System.out.println(alunos.get(0).nome);
        return alunos;

    }
    public void readFile(Disciplina disciplina){
        disciplina.alunos.clear();
        Aluno aluno = new Aluno();
        FileReader fReader;
        String nome, resposta;
    
        try{
            fReader = new FileReader("Data/"+disciplina.nome+".txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String linha = bReader.readLine();
            while(linha != null){
                System.out.println("entrou no while");
                String[] dados = linha.split("\t");
                nome = dados[1];
                resposta= dados[0];
                aluno.setNome(nome);
                aluno.setResposta(resposta);
                System.out.println(aluno.toString());
                disciplina.alunos.add(aluno);
                linha = bReader.readLine();

            }
            fReader.close();
            bReader.close();
        } catch(FileNotFoundException e){
            System.out.println("arquivo não encontrado");
            Scanner teclado = new Scanner(System.in);
            teclado.nextLine();
        }catch(Exception e){
            System.out.println("entrou");
            Scanner teclado = new Scanner(System.in);
            teclado.nextLine();
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
