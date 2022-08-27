package otrs;

/**
 *Se crea clase usuario el cual obtendrá atributos, constructor, get, set, etc.,
 * los cuales utilizaremos para guardar la información de nuestro programa.
 */
public class Usuario {

    private String nit;
    private String problema;

    private String estado;

    /**
     *
     * @param nit será el nit del usuario
     * @param problema descripcion sobre el ticket
     * @param estado será el tipo de estado que se encuentre el cual iniciará como creado
     */
    public Usuario(String nit, String problema,  String estado) {
        this.nit = nit;
        this.problema = problema;
        this.estado=estado;

    }

    /**
     * Constructores con y sin parametros
     */
    public Usuario() {

    }

    /**
     * get y setter sobre el estado del ticket
     * @return
     */
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * get y setter sobre el nit del usuario
     * @return
     */
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * get y set sobre el problema del ticket que sería el detalle
     * @return
     */
    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    /**
     * To string para la devolución de la informaciónss♦
     * @return
     */

    @Override
    public String toString() {
        return "Usuario{" +
                "nit='" + nit + '\'' +
                ", problema='" + problema + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

