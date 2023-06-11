

public class Aluno {
    private String nome;
    private String resposta;
    private int nota;

    public Aluno(String nome , String resposta) {
        this.nome = nome;
        this.resposta = resposta;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
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
