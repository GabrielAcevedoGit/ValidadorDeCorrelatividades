package domain;

import domain.alumnos.alumno;
import domain.inscripciones.inscripcion;
import domain.materias.materia;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class InscripcionTest {
    @Test
    public void inscripcionAprueboUnaMateria(){
        Set<materia> CorrelativasAyed = new HashSet<>();
        Set<materia> CorrelativasADS = new HashSet<>();
        Set<materia> CorrelativasPdeP = new HashSet<>();
        Set<materia> CorrelativasDDS = new HashSet<>();

        materia AYeD = new materia(CorrelativasAyed);

        CorrelativasADS.add(AYeD);
        materia ADS = new materia(CorrelativasADS);

        CorrelativasPdeP.add(AYeD);
        materia PdeP = new materia(CorrelativasPdeP);

        CorrelativasDDS.add(AYeD);
        CorrelativasDDS.add(PdeP);
        CorrelativasDDS.add(ADS);
        materia DDS = new materia(CorrelativasDDS);

        Set<materia> Aprobadas = new HashSet<>();
        Aprobadas.add(PdeP);
        Aprobadas.add(AYeD);
        Aprobadas.add(ADS);

        alumno Gabriel = new alumno(Aprobadas);

        Set<materia> MateriasIncripcion = new HashSet<>();
        MateriasIncripcion.add(DDS);

        inscripcion PrimeraOpcion = new inscripcion(MateriasIncripcion, Gabriel);

        Assert.assertTrue(PrimeraOpcion.aprobada());
    }
    @Test
    public void inscripcionDesaprueboUnaMateria(){
        materia AYeD = new materia(new HashSet<>());
        materia ADS = new materia(new HashSet<>());
        materia PdeP = new materia(new HashSet<>());

        Set<materia> CorrelativasDDS = new HashSet<>();
        CorrelativasDDS.add(AYeD);
        CorrelativasDDS.add(PdeP);
        CorrelativasDDS.add(ADS);

        materia DDS = new materia(CorrelativasDDS);

        Set<materia> Aprobadas = new HashSet<>();
        Aprobadas.add(PdeP);
        Aprobadas.add(AYeD);

        alumno Gabriel = new alumno(Aprobadas);

        Set<materia> MateriasIncripcion = new HashSet<>();
        MateriasIncripcion.add(DDS);

        inscripcion PrimeraOpcion = new inscripcion(MateriasIncripcion, Gabriel);
        Assert.assertFalse("No cumple con las correlativas", PrimeraOpcion.aprobada());
    }

    @Test
    public void inscripcionAprobadaVariasMaterias(){
        Set<materia> CorrelativasDDS = new HashSet<>();

        materia AYeD = new materia(new HashSet<>());
        materia ADS = new materia(new HashSet<>());
        materia PdeP = new materia(new HashSet<>());

        CorrelativasDDS.add(AYeD);
        CorrelativasDDS.add(PdeP);
        CorrelativasDDS.add(ADS);

        materia DDS = new materia(CorrelativasDDS);
        materia MatDiscreta = new materia(new HashSet<>());

        Set<materia> Aprobadas = new HashSet<>();
        Aprobadas.add(PdeP);
        Aprobadas.add(AYeD);
        Aprobadas.add(ADS);

        alumno Gabriel = new alumno(Aprobadas);

        Set<materia> MateriasIncripcion = new HashSet<>();
        MateriasIncripcion.add(DDS);
        MateriasIncripcion.add(MatDiscreta);

        inscripcion PrimeraOpcion = new inscripcion(MateriasIncripcion, Gabriel);

        Assert.assertTrue(PrimeraOpcion.aprobada());
    }

    @Test
    public void inscripcionDesaprobadaVariasMaterias(){
        Set<materia> CorrelativasDDS = new HashSet<>();

        materia AYeD = new materia(new HashSet<>());
        materia ADS = new materia(new HashSet<>());
        materia PdeP = new materia(new HashSet<>());

        CorrelativasDDS.add(AYeD);
        CorrelativasDDS.add(PdeP);
        CorrelativasDDS.add(ADS);
        materia DDS = new materia(CorrelativasDDS);

        materia MatDiscreta = new materia(new HashSet<>());
        Set<materia> CorrelativasAGA = new HashSet<>();
        CorrelativasAGA.add(MatDiscreta);

        materia AGA = new materia(CorrelativasAGA);

        Set<materia> Aprobadas = new HashSet<>();
        Aprobadas.add(PdeP);
        Aprobadas.add(AYeD);
        Aprobadas.add(ADS);

        alumno Gabriel = new alumno(Aprobadas);

        Set<materia> MateriasIncripcion = new HashSet<>();
        MateriasIncripcion.add(DDS);
        MateriasIncripcion.add(AGA);

        inscripcion PrimeraOpcion = new inscripcion(MateriasIncripcion, Gabriel);

        Assert.assertFalse(PrimeraOpcion.aprobada());
    }
}
