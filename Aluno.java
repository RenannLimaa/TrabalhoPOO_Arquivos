
public class Aluno implements Comparable<Aluno>{
    public String nome;
    public String resposta;
    public int nota;

    public Aluno(String nome , String resposta) {
        this.nome = nome;
        this.resposta = resposta;
    }
    public int compareTo(Aluno aluno){
        if(this.nota < aluno.getNota()){
            return -1;
        }
        if(this.nota < aluno.getNota()){
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
        return nome + "\t\t" + nota;
    }
}
