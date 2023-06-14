
public class Aluno implements Comparable<Aluno>{
    private String nome;
    private String resposta;
    private int nota;


    
    public Aluno(String nome , String resposta) {
        this.nome = nome;
        this.resposta = resposta;
    }
    public int compareTo(Aluno aluno){
        if(nota > aluno.getNota()){
            return -1;
        }
        if(nota > aluno.getNota()){
            return 1;
        }
        return 0;

    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta; 
    }

    public String toString(){
        return resposta + "\t" + nome;
    }

    public String toStringNota(){
        String linha = String.format("%-20s  %d", nome, nota);;
        return linha;
    }
}
