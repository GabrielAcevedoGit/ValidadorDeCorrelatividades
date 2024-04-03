package domain.materias;

import java.util.HashSet;
import java.util.Set;


public class materia {
    private Set<materia> Correlativas = new HashSet<>();
    public Set<materia> getCorrelativas(){
        return Correlativas;
    }

    public materia (Set<materia> Correlativa){
        this.Correlativas = Correlativa;
    }
}
