public class Factura {

    Cliente cliente; 
    DetalleFactura[] detalles; 
    float total_factura;
    float descuento; 
    float totalCompra;
    int numeroDetalles;

    int MAX_DETALLES = 50;

    public Factura(Cliente cliente,  float total_factura, float descuento, float totalCompra){
        this.cliente = cliente;
        this.detalles = new DetalleFactura[50];
        this.total_factura = 0;
        this.descuento = descuento;
        this.numeroDetalles= 0;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public DetalleFactura[] getDetalles(){
        return detalles;
    }

    public float getTotal(){
        return total_factura;
    }

    public float getDescuento(){
        return descuento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotal_factura(float total_factura) {
        this.total_factura = total_factura;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        if (numeroDetalles < MAX_DETALLES) {
            detalles[numeroDetalles] = detalle;
            numeroDetalles++;
        } else {
            System.out.println("No se pueden agregar mas productos a la factura.");
        }
    }

    public Float calcularDescuento( float totalCompra) {
        if (totalCompra >= 200000) {
            descuento = totalCompra * 0.15f;
        } else if (totalCompra >= 50000) {
            descuento = totalCompra * 0.02f;
        } else if (totalCompra >= 20000) {
            descuento = totalCompra * 0.015f;
        } else {
            descuento = 0;
        }

        return descuento;
    }

    public Float calcularTotalPagar( Float totalCompra, float descuento) {
        total_factura = totalCompra - descuento;
        return total_factura;
    }

    public void imprimirFactura( float totalCompra, float descuento, float total_factura) {
        System.out.println("-------------------------------------");
        System.out.println("||       Factura de compra         ||");
        System.out.println("-------------------------------------");
        System.out.println("   Cliente: " + cliente.getNombre());
        System.out.println("   Monto Total: $" + totalCompra);
        System.out.println("   Descuento: $" + descuento);
        System.out.println("   Total a Pagar: $" + total_factura);
        System.out.println("-------------------------------------");
        System.out.println("¡Gracias por su compra "+ cliente.getNombre() + "!");
        System.out.println("-------------------------------------");
    }

}
