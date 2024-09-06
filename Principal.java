import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner tecladoN = new Scanner(System.in);
        Scanner tecladoT = new Scanner(System.in);
        Cliente[] clientes = new Cliente[100];
        Producto[] productos = new Producto[100];
        Factura[] facturas = new Factura[100];
        int contClientes = 2;
        int contProductos = 3;
        int contFacturas = 0;
        float pago = 0;

        clientes[0] = new Cliente("1120", "Juan", "Pérez", 30);
        clientes[1] = new Cliente("1021", "Ana", "García", 25);

        productos[0] = new Producto("01","Producto A", "Proveedor A", 5000.0f, 100);
        productos[1] = new Producto("02","Producto B", "Proveedor B", 15000.0f, 50);
        productos[2] = new Producto("03","Producto C", "Proveedor C", 30000.0f, 200);

        while (true) {
            System.out.println("||------------------------------||");
            System.out.println("||             Menú             ||");
            System.out.println("||------------------------------||");
            System.out.println("||  1. Insertar Cliente         ||");
            System.out.println("||  2. Insertar Producto        ||");
            System.out.println("||  3. Insertar Compra          ||");
            System.out.println("||  4. Salir                    ||");
            System.out.println("||------------------------------||");
            System.out.println();
            System.out.print("Elige una opción: ");
            int opcion = tecladoN.nextInt();
            
            switch (opcion) {
                case 1:

                    System.out.print("Ingrese el documento del cliente: ");
                    String documentoCliente = tecladoT.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = tecladoT.nextLine();
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellidoCliente = tecladoT.nextLine();
                    System.out.print("Ingrese la edad del cliente: ");
                    int edadCliente = tecladoN.nextInt();

                    clientes[contClientes++] = new Cliente(documentoCliente,nombreCliente, apellidoCliente, edadCliente);
                    System.out.println("Cliente insertado correctamente.");

                    break;
                case 2:
                    System.out.print("Ingrese el id del producto: ");
                    String idProducto = tecladoT.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = tecladoT.nextLine();
                    System.out.print("Ingrese el proveedor del producto: ");
                    String proveedorProducto = tecladoT.nextLine();
                    System.out.print("Ingrese el costo por unidad del producto: ");
                    float costoUnidadProducto = tecladoN.nextFloat();
                    System.out.print("Ingrese la cantidad disponible del producto: ");
                    int cantidadDisponibleProducto = tecladoN.nextInt();

                    productos[contProductos++] = new Producto(idProducto,nombreProducto, proveedorProducto, costoUnidadProducto, cantidadDisponibleProducto);
                    System.out.println("Producto insertado correctamente.");
                    break;
                case 3:

                    if (contClientes == 0 || contProductos == 0) {
                        System.out.println("No hay clientes o productos para realizar una compra.");
                        break;
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("||       Clientes registrados      ||");
                    System.out.println("-------------------------------------");
                    for (int i = 0; i < contClientes; i++) {
                        System.out.println(" "+(i+1)+ ". " + clientes[i].getNombre() + " " + clientes[i].getApellido());
                    }
                    System.out.println("-------------------------------------");
                    System.out.println();
                    System.out.print("Elige el cliente (número): ");
                    int clienteIndex = tecladoN.nextInt() - 1;

                    Factura factura = new Factura(clientes[clienteIndex], 0, 0,0);

                    while (true) {
                        System.out.println("-------------------------------------");
                        System.out.println("||       Productos disponibles     ||");
                        System.out.println("-------------------------------------");
                        for (int i = 0; i < contProductos; i++) {
                            System.out.println("  "+(i+1)+ ". " + productos[i].getNombre() + ", Cant: " + productos[i].getCostoUnidad());
                        }
                        System.out.println("-------------------------------------");
                        System.out.println();
                        System.out.print("Elige el producto (número): ");
                        int productoIndex = tecladoN.nextInt() - 1;
                        System.out.print("Ingrese la cantidad: ");
                        int cantidad = tecladoN.nextInt();

                        float subtotal = productos[productoIndex].getCostoUnidad() * cantidad;
                        DetalleFactura detalle = new DetalleFactura(productos[productoIndex], cantidad,subtotal);

                        factura.agregarDetalle(detalle);
                        
                        pago = pago + detalle.getSubtotal();

                        System.out.print("¿Desea agregar otro producto? (s/n): ");
                        String respuesta = tecladoT.nextLine();
                        if (!respuesta.equals("s")) {
                            break;
                        }
                    }

                    float descuento = factura.calcularDescuento(pago);
                    factura.setDescuento(descuento);
                    float pago_total = factura.calcularTotalPagar(pago,descuento);
                    factura.setTotal_factura(pago_total);
                    factura.imprimirFactura(pago,factura.getDescuento(),pago_total);

                    facturas[contFacturas++] = factura;
                    break; 

                case 4:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    
            }
        }
    }
}
