

public class Aluno {
    public String nome;
    public String resposta;
    public int nota;

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

    public String toString(){
        return resposta + "\t" + nome;
    }

    public String toStringNota(){
        return nome + "\t\t" + nota;
    }
}
