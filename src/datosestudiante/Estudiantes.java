package datosestudiante;

/**
 *
 * @author Giovanni López
 */
public class Estudiantes {
    private int id_estudiante;
    private String carnet_estudiante;
    private String nom_estudiante;
    private String ape_estudiante;
    private int edad_estudiante;

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCarnet_estudiante() {
        return carnet_estudiante;
    }

    public void setCarnet_estudiante(String carnet_estudiante) {
        this.carnet_estudiante = carnet_estudiante;
    }

    public String getNom_estudiante() {
        return nom_estudiante;
    }

    public void setNom_estudiante(String nom_estudiante) {
        this.nom_estudiante = nom_estudiante;
    }

    public String getApe_estudiante() {
        return ape_estudiante;
    }

    public void setApe_estudiante(String ape_estudiante) {
        this.ape_estudiante = ape_estudiante;
    }

    public int getEdad_estudiante() {
        return edad_estudiante;
    }

    public void setEdad_estudiante(int edad_estudiante) {
        this.edad_estudiante = edad_estudiante;
    }
}
