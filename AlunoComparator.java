import java.util.Comparator;

public class AlunoComparator implements Comparator<Aluno> {
    
    public int compare(Aluno aluno1, Aluno aluno2){
        return aluno1.getNome().compareTo(aluno2.getNome());
    }


}
