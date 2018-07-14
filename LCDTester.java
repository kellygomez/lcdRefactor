
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {

        //VARIABLES Y OBJETOS
        //variables para guardar las entradas
        List<String> listaDeNumeros = new ArrayList<>();
        String datoIngresado;
        int espacioEntreDigitos = 0;
        boolean esDatoValido = true;

        //objeto para realizar la impresion
        ImpresorLCD impresorLCD = new ImpresorLCD();

        try (Scanner lector = new Scanner(System.in)) {
            //repetir bloque de código hasta que el dato ingresado sea valido
            do {
                System.out.print("Espacio entre los Digitos (0 a 5): ");
                datoIngresado = lector.next();
                // Valida si es un numero
                if (ImpresorLCD.isNumeric(datoIngresado)) {
                    esDatoValido = false;
                    espacioEntreDigitos = Integer.parseInt(datoIngresado);

                    // se valida que el espaciado este entre 0 y 5
                    if (espacioEntreDigitos < 0 || espacioEntreDigitos > 5) {
                        esDatoValido = true;
                        System.out.println("El espacio entre digitos debe estar entre 0 y 5: ");
                    }
                } else {
                    System.out.println("Cadena " + datoIngresado + " no es un entero");
                }
            } while (esDatoValido);

            //repetir bloque de codigo hasta que se ingrese la cadena final = 0,0
            do {
                System.out.print("Entrada: ");
                datoIngresado = lector.next();
                esDatoValido = impresorLCD.validarCadenaIngresada(datoIngresado);
                if (!datoIngresado.equalsIgnoreCase(CADENA_FINAL) && esDatoValido) {
                    listaDeNumeros.add(datoIngresado);
                }
            } while (!datoIngresado.equalsIgnoreCase(CADENA_FINAL));
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        //recorrido de la lista a imprimir e impresion de numeros
        Iterator<String> iterator = listaDeNumeros.iterator();
        while (iterator.hasNext()) {
            try {
                impresorLCD.procesarDatoIngresado(iterator.next(), espacioEntreDigitos);
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }

}
