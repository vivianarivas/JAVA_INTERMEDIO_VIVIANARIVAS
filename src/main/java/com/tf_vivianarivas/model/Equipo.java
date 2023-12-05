package com.tf_vivianarivas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos", schema = "campeonato", catalog = "")
public abstract class Equipo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_equipo", nullable = false)
    private int id_equipo;
    @Basic
    @Column(name = "nombre_equipo", nullable = false, length = 100)
    private String nombre_equipo;
    @Basic
    @Column(name = "titulares", nullable = true)
    private Integer titulares;
    @Basic
    @Column(name = "suplentes", nullable = true)
    private Integer suplentes;
    @Basic
    @Column(name = "director_tecnico", nullable = true, length = 100)
    private String director_tecnico;
    @Basic
    @Column(name = "puntos", nullable = true)
    private Integer puntos;
    @Basic
    @Column(name = "partidos_jugados", nullable = true)
    private Integer partidos_jugados;

    public Equipo() {
    }

    public Equipo(String nombreEquipo, int titulares, int suplentes, String directorTec, int puntos, int partidosJugados) {
        this.nombre_equipo = nombreEquipo;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.director_tecnico = directorTec;
        this.puntos = puntos;
        this.partidos_jugados = partidosJugados;
    }

    public int getIdEquipo() {
        return id_equipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.id_equipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombre_equipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombre_equipo = nombreEquipo;
    }

    public int getTitulares() {
        return titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    public String getDirectorTec() {
        return director_tecnico;
    }

    public void setDirectorTec(String directorTec) {
        this.director_tecnico = directorTec;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidos_jugados;
    }


    public void setPartidosJugados(int partidosJugados) {
        this.partidos_jugados = partidosJugados;
    }




    public void calcularPuntos() {
        this.puntos = 0;
        for (int i = 0; i < this.partidos_jugados; i++) {
            int resultado = this.getResultado(i);
            switch (resultado) {
                case 0:
                    break;
                case 1:
                    this.puntos += 1;
                    break;
                case 3:
                    this.puntos += 3;
                    break;
            }
        }
    }

    protected abstract int getResultado(int partido);


}
