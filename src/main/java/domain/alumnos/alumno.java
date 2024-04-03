package domain.alumnos;

import domain.materias.materia;

import java.util.HashSet;
import java.util.Set;

public class alumno {
    public Set<materia> Aprobadas = new HashSet<>();
    public alumno (Set<materia> Aprobada){
        Aprobadas = Aprobada;
    }

}
