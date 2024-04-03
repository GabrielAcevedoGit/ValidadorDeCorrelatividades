package domain.inscripciones;

import domain.alumnos.alumno;
import domain.materias.materia;

import java.util.HashSet;
import java.util.Set;
public class inscripcion {
    private Set<materia> MateriasInscripcion = new HashSet<>();
    private Set<materia> Correlativas = new HashSet<>();
    private alumno Alumno;
    public boolean aprobada(){
        return Alumno.Aprobadas.containsAll(Correlativas);
    }
    private void getTodasCorrelativas(){
        for(materia Materia : MateriasInscripcion){
            Correlativas.addAll(Materia.getCorrelativas());
        }
    }
    public inscripcion(Set<materia> Materias, alumno Persona){
        this.MateriasInscripcion = Materias;
        this.Alumno = Persona;
        this.getTodasCorrelativas();
    }
}
