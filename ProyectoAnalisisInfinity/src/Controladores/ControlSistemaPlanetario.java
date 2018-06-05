/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class ControlSistemaPlanetario {

    private int codigoSistemaPlanetario;
    private final ControlPlaneta controlPlaneta;
    private SistemaPlanetario sistemaPlanetario;
    private final List<String> imagenesSistemasPlanetarios;

    public ControlSistemaPlanetario() {
        this.codigoSistemaPlanetario = 0;
        this.controlPlaneta = new ControlPlaneta();
        this.imagenesSistemasPlanetarios = new LinkedList<>();
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo1.png");
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo2.png");
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo3.png");
    }

    public SistemaPlanetario CrearSistamPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        this.codigoSistemaPlanetario++;
        SistemaPlanetario sistemaPlanetario = new SistemaPlanetario(this.codigoSistemaPlanetario, nombre, enemigo, posicionX, posicionY, this.imagenesSistemasPlanetarios.get(tipoSistemaPlanetario));
        return sistemaPlanetario;
    }

    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlPlaneta.CrearPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        this.sistemaPlanetario.getListaPlanetas().add(planeta);
        return planeta;
    }

    void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
        planetaInicial.getAdyacencias().add(new Nodo(planetaFinal.getNombre(), 0));
    }

    public Planeta BuscarPlaneta(String nombrePlaneta) {
        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
            if (planeta.getNombre().equals(nombrePlaneta)) {
                return planeta;
            }
        }
        return null;
    }

    public List<Planeta> ListaPlanetas() {
        List<Planeta> planetas = this.sistemaPlanetario.getListaPlanetas();
        return planetas;
    }

    /**
     * @return the sistemaPlanetario
     */
    public SistemaPlanetario getSistemaPlanetario() {
        return sistemaPlanetario;
    }

    /**
     * @param sistemaPlanetario the sistemaPlanetario to set
     */
    public void setSistemaPlanetario(SistemaPlanetario sistemaPlanetario) {
        this.sistemaPlanetario = sistemaPlanetario;
    }

}
