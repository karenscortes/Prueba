public class Producto {
    String id;
    String nombre;
    String proveedor;
    float costo_unidad; 
    int cantidad_disponible; 

    public Producto(String id,String nombre, String proveedor, float costo_unidad, int cantidad_disponible){
        this.id = id;
        this.nombre = nombre; 
        this.proveedor = proveedor;
        this.costo_unidad = costo_unidad;
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public float getCostoUnidad() {
        return costo_unidad;
    }

    public int getCantidadDisponible() {
        return cantidad_disponible;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setCostoUnidad(float costo_unidad) {
        this.costo_unidad = costo_unidad;
    }

    public void setCantidadDisponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
}
