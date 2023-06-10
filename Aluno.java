import java.io.Serializable;

public class Aluno implements Serializable{
    String nome;
    String resposta;
    int nota;

    public Aluno(String nome , String resposta) {
        this.nome = nome;
        this.resposta = resposta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta; 
    }

    public String toSting(){
        return "nome: " + nome + ", nota: " + resposta;
    }
}
