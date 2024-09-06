public class Cliente {
    String documento;
    String nombre; 
    String apellido; 
    int edad; 

    public Cliente(String documento, String nombre, String apellido, int edad){
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
