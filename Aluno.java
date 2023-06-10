import java.io.Serializable;

public class Aluno implements Serializable{
    String nome;
    String respostas;

    public Aluno(String nome , String respostas) {
        this.nome = nome;
        this.respostas = respostas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRespostas() {
        return respostas;
    }

    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }

    public String toSting(){
        return "nome: " + nome + ", respostas: " + respostas;
    }
}
