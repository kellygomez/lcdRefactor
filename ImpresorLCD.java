
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

    // Puntos iniciales fijos donde se comienza a dibujar la linea del segmento o parte del digito
    private final int[] puntoFijo1;
    private final int[] puntoFijo2;
    private final int[] puntoFijo3;
    private final int[] puntoFijo4;
    private final int[] puntoFijo5;
    private String[][] matrizImpr;//matriz a imprimir
    private String[] parametrosDeEntrada;//parametros de la cadena: size y numero a imprimir

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    // TODO code application logic here
    //String entrada = JOptionPane.showInputDialog("Digite el numero");
    private int size;

    // Calcula el numero de filas y columnas a dibujar
    private int cantidadFilasDigito;
    private int cantidadColumDigito;
    private int totalFilasMatriz;
    private int totalColumMatriz;

    public ImpresorLCD() {
        // Inicializa variables
        this.puntoFijo1 = new int[2];
        this.puntoFijo2 = new int[2];
        this.puntoFijo3 = new int[2];
        this.puntoFijo4 = new int[2];
        this.puntoFijo5 = new int[2];
    }

    /**
     *
     * Metodo encargado de añadir una linea del digito a dibujar a la matriz de
     * Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote de posicion en la matriz para dibujar el
     * segmento
     * @param posFija Posicion Fija en la que se mueve las coordenadas del la
     * matriz (eje X o eje Y)
     * @param size Tamaño Segmento
     * @param caracter Caracter a dibujar del Segmento
     */
    private void adicionarLineaDelDigito(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        //mueve las coordenadas de cada linea de la matriz en el eje X
        if (posFija.equalsIgnoreCase(POSICION_X)) {
            for (int y = 1; y <= size; y++) {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } //mueve las coordenadas de cada linea de la matriz en el eje Y
        else {
            for (int i = 1; i <= size; i++) {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }

    /**
     *
     * Metodo encargado de un segmentoDelDigito para enviar a dibujar en la
     * matriz de Impresion
     *
     * @param segmentoDelDigito Segmento o parte del digito que se va a
     * adicionar o dibujar
     */
    private void adicionarSegmentoDelDigito(int segmentoDelDigito) {

        switch (segmentoDelDigito) {
            case 1:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLineaDelDigito(this.matrizImpr, this.puntoFijo3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y a
     * partir de los segmentos adicionar la representacion del digito a la
     * matriz
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {

        List<Integer> listaDeSegmentos = new ArrayList<>();

        // Establece los segmentos de cada numero
        switch (numero) {
            case 1:
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(4);
                break;
            case 2:
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(2);
                listaDeSegmentos.add(7);
                break;
            case 3:
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(4);
                listaDeSegmentos.add(7);
                break;
            case 4:
                listaDeSegmentos.add(1);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(4);
                break;
            case 5:
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(1);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(4);
                listaDeSegmentos.add(7);
                break;
            case 6:
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(1);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(2);
                listaDeSegmentos.add(7);
                listaDeSegmentos.add(4);
                break;
            case 7:
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(4);
                break;
            case 8:
                listaDeSegmentos.add(1);
                listaDeSegmentos.add(2);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(4);
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(7);
                break;
            case 9:
                listaDeSegmentos.add(1);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(4);
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(6);
                listaDeSegmentos.add(7);
                break;
            case 0:
                listaDeSegmentos.add(1);
                listaDeSegmentos.add(2);
                listaDeSegmentos.add(3);
                listaDeSegmentos.add(4);
                listaDeSegmentos.add(5);
                listaDeSegmentos.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iteradorDeSegmentos = listaDeSegmentos.iterator();

        //envia cada segmento de la lista a ser dibujardo
        while (iteradorDeSegmentos.hasNext()) {
            adicionarSegmentoDelDigito(iteradorDeSegmentos.next());
        }
    }

    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImprimir Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    private void imprimirNumero(int size, String numeroImprimir, int espacio) {
        int pivotX = 0;
        char[] digitos;

        this.size = size;

        // Calcula el numero de filas cada digito
        this.cantidadFilasDigito = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.cantidadColumDigito = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilasMatriz = this.cantidadFilasDigito;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColumMatriz = (this.cantidadColumDigito * numeroImprimir.length())
                + (espacio * numeroImprimir.length());

        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[this.totalFilasMatriz][this.totalColumMatriz];

        // crea el arreglo de digitos
        digitos = numeroImprimir.toCharArray();

        // Inicializa matriz
        for (int i = 0; i < this.totalFilasMatriz; i++) {
            for (int j = 0; j < this.totalColumMatriz; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }

        //llena la matriz con los numeros a mostrar
        for (char digito : digitos) { //recorre cada caracter del numero ingresado

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.puntoFijo1[0] = 0;
            this.puntoFijo1[1] = 0 + pivotX;

            this.puntoFijo2[0] = (this.cantidadFilasDigito / 2);
            this.puntoFijo2[1] = 0 + pivotX;

            this.puntoFijo3[0] = (this.cantidadFilasDigito - 1);
            this.puntoFijo3[1] = 0 + pivotX;

            this.puntoFijo4[0] = (this.cantidadColumDigito - 1);
            this.puntoFijo4[1] = (this.cantidadFilasDigito / 2) + pivotX;

            this.puntoFijo5[0] = 0;
            this.puntoFijo5[1] = (this.cantidadColumDigito - 1) + pivotX;

            pivotX = pivotX + this.cantidadColumDigito + espacio;

            adicionarDigito(numero);
        }

        // Imprime matriz
        for (int i = 0; i < this.totalFilasMatriz; i++) {
            for (int j = 0; j < this.totalColumMatriz; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     *
     * Metodo encargado de procesarDatoIngresado la entrada que contiene el size
     * del segmento de los digitos y los digitos a imprimir
     *
     * @param datoIngresado Entrada que contiene el size del segmento de los
     * digito y el numero a imprimir
     * @param espacioEntreDigitos Espacio Entre digitos
     */
    public void procesarDatoIngresado(String datoIngresado, int espacioEntreDigitos) {

        int tamañoDeImpresion;

        //Se hace el split de la cadena
        parametrosDeEntrada = datoIngresado.split(",");

        //se obtiene el size de la impresion
        tamañoDeImpresion = Integer.parseInt(parametrosDeEntrada[0]);

        // Realiza la impresion del numero
        imprimirNumero(tamañoDeImpresion, parametrosDeEntrada[1], espacioEntreDigitos);

    }

    /**
     * Metodo encargado de validar la cadena ingresada, de manera que este en el
     * formato establecido
     *
     * @param datoIngresado Entrada que contiene el size del segmento de los
     * digito y el numero a imprimir
     * @return
     */
    public boolean validarCadenaIngresada(String datoIngresado) {

        int tamañoDeImpresion;

        //valida que el dato contenga el caracter ,
        if (!datoIngresado.contains(",")) {
            System.out.println("Cadena " + datoIngresado + " no contiene caracter ,");
            return false;
        }

        //Se hace el split de la cadena 
        parametrosDeEntrada = datoIngresado.split(",");

        //Valida la cantidad de parametros
        if (parametrosDeEntrada.length > 2) {
            System.out.println("Cadena " + datoIngresado + " contiene mas caracter ,");
            return false;
        }

        //Valida la cantidad de parametros
        if (parametrosDeEntrada.length < 2) {
            System.out.println("Cadena " + datoIngresado + " no contiene los parametros requeridos");
            return false;
        }

        //Valida que el parametro size sea un numerico
        if (isNumeric(parametrosDeEntrada[0])) {
            tamañoDeImpresion = Integer.parseInt(parametrosDeEntrada[0]);

            // se valida que el size este entre 1 y 10
            if (tamañoDeImpresion < 1 || tamañoDeImpresion > 10) {
                System.out.println("El parametro size [" + tamañoDeImpresion + "] debe estar entre 1 y 10");
                return false;
            }
        } else {
            System.out.println("Parametro Size [" + parametrosDeEntrada[0] + "] no es un numero");
            return false;
        }

        //Valida que el segundo parametro de entrada sea un numero
        if (!isNumeric(parametrosDeEntrada[1])) {
            System.out.println("El dato " + parametrosDeEntrada[1] + " no es un numero");
            return false;
        }

        return true;
    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
