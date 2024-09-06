public class DetalleFactura {
    private Producto producto;
    private int cantidad;
    private float subtotal;

    public DetalleFactura(Producto producto, int cantidad, float subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;    
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubTotal(float subtotal) {
        this.subtotal =subtotal;    
    }

}
