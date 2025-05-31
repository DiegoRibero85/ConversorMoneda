import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lecturaTeclado = new Scanner(System.in);

        int opcionElegida = 0;


        AccesoApi AccesoApi = new AccesoApi(); //Conexión a la Api de conversión de mondea

        CrearConversion CrearConversion = new CrearConversion(AccesoApi); //Clase donde se convierte el tipo de moneda


        List<String> respuestas = new ArrayList<>();

        String InterfazMenu = """
                ***************************************************
                Conversor de Monedas Alura LATAM
                
                1. Dólar estadounidense =>> Peso Colombiano
                2. Peso Colombiano =>> Dólar estadounidense
                3. Peso Argentino =>> Dólar estadounidense 
                4. Dólar estadounidense =>> Peso Argentino
                5. Peso Chileno =>> Dólar estadounidense
                6. Dólar estadounidense =>> Peso Chileno                       
                7. Salir
                Elija una opción válida
                ***************************************************
                """;

        while (opcionElegida != 7) {
            try {
                System.out.println(InterfazMenu);
                opcionElegida = Integer.parseInt(lecturaTeclado.nextLine());

                // Obtener la marca de tiempo actual
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionElegida) {
                    case 1:
                        CrearConversion.almacenarValores("USD", "COP");
                        respuestas.add(formattedDate + " - " + CrearConversion.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        CrearConversion.almacenarValores("COP", "USD");
                        respuestas.add(formattedDate + " - " + CrearConversion.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        CrearConversion.almacenarValores("ARS", "USD");
                        respuestas.add(formattedDate + " - " + CrearConversion.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        CrearConversion.almacenarValores("USD", "ARS");
                        respuestas.add(formattedDate + " - " + CrearConversion.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        CrearConversion.almacenarValores("CLP", "USD");
                        respuestas.add(formattedDate + " - " + CrearConversion.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        CrearConversion.almacenarValores("USD", "CLP");
                        respuestas.add(formattedDate + " - " + CrearConversion.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese solo códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }
        }


        System.out.println("Finalizando programa");
    }
}