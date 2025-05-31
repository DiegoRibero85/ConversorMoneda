import java.util.Scanner;

public class CrearConversion {
    //Creación de las variables
    private String moneda1;
    private String moneda2;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    AccesoApi conversion;

//Creación de las instancias
    public CrearConversion(AccesoApi conversion) {
        this.conversion = conversion;
    }

    public String getMoneda1() {
        return moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void almacenarValores(String moneda1, String moneda2){
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;

        System.out.println("Ingrese la cantidad que desea convertir: ");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }


    public String obtenerMensajeRespuesta() {
        String mensaje = getMoneda1().toUpperCase() + " " + getCantidad() + " equivale a: " + getMoneda2().toUpperCase() + " " + conversion.buscaConversion(getMoneda1(), getMoneda2(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}