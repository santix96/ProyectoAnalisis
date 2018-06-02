/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;

/**
 *
 * @author USER
 */
public class ControlUniverso {

    private Universo universo;
    private final ControlNebulosa controlNebulosa;

    public ControlUniverso() {
        this.controlNebulosa = new ControlNebulosa();
    }

    public Universo CrearUniverso(String nombre) {
        this.setUniverso(new Universo(nombre));
        return this.getUniverso();
    }

    public Nebulosa AgregarNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        Nebulosa nebulosa = this.controlNebulosa.CrearNebulosa(nombre, enemigo, posicionX, posicionY, tipoNebulosa);
        this.universo.getListaNebulosas().add(nebulosa);
        return nebulosa;

    }

    public Nebulosa EntrarNebulosa(String nombreNebulosa) {
        Nebulosa nebulosa = BuscarNebulosa(nombreNebulosa);
        this.ActualizarNebulosa(nebulosa);
        return nebulosa;
    }

    private Nebulosa BuscarNebulosa(String nombreNebulosa) {

        for (Nebulosa nebulosa : this.universo.getListaNebulosas()) {
            if (nebulosa.getNombre().equals(nombreNebulosa)) {
                return nebulosa;
            }
        }
        return null;
    }

    private void ActualizarNebulosa(Nebulosa nebulosa) {
        this.controlNebulosa.setNebulosa(nebulosa);
    }

    public SistemaPlanetario AgregarSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY) {
        SistemaPlanetario sistemaPlanetario = this.controlNebulosa.AgregarSistemaPlanetario(nombre, enemigo, posicionX, posicionY);
        return sistemaPlanetario;
    }

    public SistemaPlanetario EntrarSistemaPlanetario(String nombreSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlNebulosa.EntrarSistemaPlanetario(nombreSistemaPlanetario);
        return sistemaPlanetario;
    }

    /**
     * @return the universo
     */
    public Universo getUniverso() {
        return universo;
    }

    /**
     * @param universo the universo to set
     */
    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

}
