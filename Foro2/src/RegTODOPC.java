/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Daniela
 */
    /**
     * @param args the command line arguments
     */
        // TODO code application logic here

// Clase base para los equipos (Clase padre)
class Equipo {
    // Atributos comunes a todos los equipos
    protected String fabricante;
    protected String modelo;
    protected String microprocesador;

    // Constructor de la clase Equipo. Inicializa los atributos fabricante, modelo y microprocesador del equipo.
    public Equipo(String fabricante, String modelo, String microprocesador) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
    }
    
    // Método para representar la información del equipo en forma de cadena de texto.
    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\n Modelo: " + modelo + "\n Microprocesador: " + microprocesador;
    }
}

// Subclase para Desktops
class Desktop extends Equipo {
    // Atributos específicos de los equipos de escritorio
    private int memoria;
    private String tarjetaGrafica;
    private String tamanoTorre;
    private int capacidadDiscoDuro;

    // Constructor de la clase Desktop. Inicializa los atributos comunes heredados de Equipo, así como los atributos específicos
    // de los equipos de escritorio.
    public Desktop(String fabricante, String modelo, String microprocesador, int memoria, String tarjetaGrafica,
                   String tamanoTorre, int capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador);
        this.memoria = memoria;
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }
    
    // Método para representar la información del equipo de escritorio en forma de cadena de texto.
    @Override
    public String toString() {
        return super.toString() + "\n Memoria: " + memoria + "GB\n Tarjeta Gráfica: " + tarjetaGrafica +
                "\n Tamaño de Torre: " + tamanoTorre + "\n Capacidad de Disco Duro: " + capacidadDiscoDuro + "GB";
    }
}

// Subclase para Laptops
class Laptop extends Equipo {
    // Atributos específicos de los equipos Laptops
    private int memoria;
    private double tamanoPantalla;
    private int capacidadDiscoDuro;

    // Constructor de la clase Laptop. Inicializa los atributos comunes heredados de Equipo, así como los atributos específicos
    // de los equipos portátiles.
    public Laptop(String fabricante, String modelo, String microprocesador, int memoria, double tamanoPantalla,
                  int capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador);
        this.memoria = memoria;
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    // Método para representar la información del equipo portátil en forma de cadena de texto.
    @Override
    public String toString() {
        return super.toString() + "\n Memoria: " + memoria + "GB\n Tamaño de Pantalla: " + tamanoPantalla +
                " pulgadas\n Capacidad de Disco Duro: " + capacidadDiscoDuro + "GB";
    }
}

// Subclase para Tablets
class Tablet extends Equipo {
    // Atributos específicos de los equipos portátiles
    private double tamanoPantalla;
    private String tipoPantalla;
    private int memoriaNAND;
    private String sistemaOperativo;

    // Constructor de la clase Tablet. Inicializa los atributos comunes heredados de Equipo, así como los atributos específicos
    // de los equipos Tablets.
    public Tablet(String fabricante, String modelo, String microprocesador, double tamanoPantalla, String tipoPantalla,
                  int memoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador);
        this.tamanoPantalla = tamanoPantalla;
        this.tipoPantalla = tipoPantalla;
        this.memoriaNAND = memoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Método para representar la información del equipo portátil en forma de cadena de texto.
    @Override
    public String toString() {
        return super.toString() + "\n Tamaño de Pantalla: " + tamanoPantalla + " pulgadas\n Tipo de Pantalla: " +
                tipoPantalla + "\n Memoria NAND: " + memoriaNAND + "GB\n Sistema Operativo: " + sistemaOperativo;
    }
}

//Clase publica, aqui se escribe el procedimiento (en este caso el menu principal)
public class RegTODOPC {
    public static void main(String[] args) {
        // Se crea una lista para almacenar los equipos registrados.
        List<Equipo> equipos = new ArrayList<>();
         // Se muestra un bucle de menú principal que permite al usuario seleccionar entre registrar un equipo,
        // ver los equipos registrados o salir de la aplicación.
        while (true) {
            // Se define un conjunto de opciones para el menú.
            String[] options = {"Registrar equipo", "Ver equipos", "Salir"};
            
            // Se muestra un cuadro de diálogo de opción para que el usuario seleccione una opción.
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Registro de Equipos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            // Se ejecuta una acción según la opción seleccionada por el usuario.
            switch (choice) {
                case 0: // Registrar equipo
                    registrarEquipo(equipos); // Llama al método para registrar un equipo.
                    break;
                case 1: // Ver equipos
                    verEquipos(equipos); // Llama al método para mostrar los equipos registrados.
                    break;
                case 2: // Salir
                    System.exit(0); // Termina la aplicación.
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    private static void registrarEquipo(List<Equipo> equipos) {
        
        // Se define un conjunto de opciones para que el usuario seleccione el tipo de equipo a registrar.
        String[] tiposEquipos = {"Desktop", "Laptop", "Tablet"};
        
        // Se muestra un cuadro de diálogo de entrada para que el usuario seleccione el tipo de equipo.
        String tipoEquipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de equipo a registrar:",
                "Registro de Equipos", JOptionPane.QUESTION_MESSAGE, null, tiposEquipos, tiposEquipos[0]);

        // Se verifica si el usuario seleccionó un tipo de equipo.
        if (tipoEquipo != null) {
            // Se utiliza un bloque switch para determinar qué tipo de equipo se seleccionó y llamar al método correspondiente
        // para registrar ese tipo específico de equipo
            switch (tipoEquipo) {
                case "Desktop":
                    registrarDesktop(equipos); // Llama al método para registrar un equipo de escritorio.
                    break;
                case "Laptop":
                    registrarLaptop(equipos); // Llama al método para registrar una laptop.
                    break;
                case "Tablet":
                    registrarTablet(equipos); // Llama al método para registrar una tablet.
                    break;
            }
        }
    }
    
    private static String validarCampoNoVacio(String mensaje, boolean esNumero) {
    String valor; // Almacena el valor ingresado por el usuario.
    do {
        valor = JOptionPane.showInputDialog(mensaje);// Solicita al usuario que ingrese un valor para el campo.

        // Verifica si el valor es nulo o está vacío.
        if (valor == null || valor.trim().isEmpty()) {
            
            // Muestra un mensaje de error si el valor está vacío y solicita nuevamente al usuario que ingrese el valor.
            valor = JOptionPane.showInputDialog("El valor no puede quedar vacío. " + mensaje);
        } else if (esNumero) { // Verifica si se espera un valor numérico.
            try {
                // Intenta convertir el valor a un número.
                Double.parseDouble(valor);    
            } catch (NumberFormatException e) {
                
                // Muestra un mensaje de error si el valor no es un número válido y solicita nuevamente al usuario que ingrese el valor.
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                valor = null; // Reiniciamos el valor para que el bucle continúe
            }
        }
    } while (valor == null);// Continúa solicitando al usuario que ingrese el valor hasta que se ingrese un valor válido.
    return valor;// Devuelve el valor ingresado por el usuario que cumple con los requisitos establecidos.
}
    
    private static void registrarDesktop(List<Equipo> equipos) {
        //Se pide ingresar cada campo de informacion sobre el registro de Desktop,
        //usando las validaciones en el metodo validarCampoNoVacio
        String fabricante = validarCampoNoVacio("Ingrese el fabricante:", false);
        String modelo = validarCampoNoVacio("Ingrese el modelo:", false);
        String microprocesador = validarCampoNoVacio("Ingrese el microprocesador:", false);
        int memoria = Integer.parseInt(validarCampoNoVacio("Ingrese la memoria en GB:", true));
        String tarjetaGrafica = validarCampoNoVacio("Ingrese la tarjeta gráfica:", false);
        String tamanoTorre = validarCampoNoVacio("Ingrese el tamaño de la torre (pulgadas):", true);
        int capacidadDiscoDuro = Integer.parseInt(validarCampoNoVacio("Ingrese la capacidad de disco duro en GB:", true));

        // Se crea un objeto Desktop con la información ingresada por el usuario.
        Desktop desktop = new Desktop(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre,
        capacidadDiscoDuro);
        // Se agrega el equipo de escritorio registrado a la lista de equipos.
        equipos.add(desktop);
        // Se muestra un mensaje de confirmación indicando que el equipo de escritorio ha sido registrado exitosamente.
        JOptionPane.showMessageDialog(null, "Desktop registrado exitosamente");
    }

    private static void registrarLaptop(List<Equipo> equipos) {
        //Se pide ingresar cada campo de informacion sobre el registro de Laptop,
        //usando las validaciones en el metodo validarCampoNoVacio
        String fabricante = validarCampoNoVacio("Ingrese el fabricante:", false);
        String modelo = validarCampoNoVacio("Ingrese el modelo:", false);
        String microprocesador = validarCampoNoVacio("Ingrese el microprocesador:", false);
        int memoria = Integer.parseInt(validarCampoNoVacio("Ingrese la memoria en GB:", true));
        double tamanoPantalla = Double.parseDouble(validarCampoNoVacio("Ingrese el tamaño de pantalla en pulgadas:", true));
        int capacidadDiscoDuro = Integer.parseInt(validarCampoNoVacio("Ingrese la capacidad de disco duro en GB:", true));

        //Se crea un objeto Laptop con la información ingresada por el usuario
        Laptop laptop = new Laptop(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro);
        equipos.add(laptop);
        //Mensaje de confirmacion de registro exitoso
        JOptionPane.showMessageDialog(null, "Laptop registrado exitosamente");
    }
    

    private static void registrarTablet(List<Equipo> equipos) {
        //Se pide ingresar cada campo de informacion sobre el registro de Tablet,
        //usando las validaciones en el metodo validarCampoNoVacio
        String fabricante = validarCampoNoVacio("Ingrese el fabricante:", false);
        String modelo = validarCampoNoVacio("Ingrese el modelo:", false);
        String microprocesador = validarCampoNoVacio("Ingrese el microprocesador:", false);
        double tamanoPantalla = Double.parseDouble(validarCampoNoVacio("Ingrese el tamaño de pantalla en pulgadas:", true));
        String tipoPantalla = validarCampoNoVacio("Ingrese el tipo de pantalla (Capacitiva/Resistiva):", false);
        int memoriaNAND = Integer.parseInt(validarCampoNoVacio("Ingrese la memoria NAND en GB:", true));
        String sistemaOperativo = validarCampoNoVacio("Ingrese el sistema operativo:", false    );

        //Se crea un objeto Tablet con la información ingresada por el usuario
        Tablet tablet = new Tablet(fabricante, modelo, microprocesador, tamanoPantalla, tipoPantalla, memoriaNAND,
            sistemaOperativo);
        equipos.add(tablet);
        //Mensaje de confirmacion de registro exitoso
        JOptionPane.showMessageDialog(null, "Tablet registrado exitosamente");
    }

    private static void verEquipos(List<Equipo> equipos) {
        
    // Se define un conjunto de opciones para que el usuario seleccione el tipo de equipo a ver.
    String[] tiposEquipos = {"Desktops", "Laptops", "Tablets"};
    // Se muestra un cuadro de diálogo de entrada para que el usuario seleccione el tipo de equipo a ver.
    String tipoEquipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de equipo a ver:",
            "Ver Equipos", JOptionPane.QUESTION_MESSAGE, null, tiposEquipos, tiposEquipos[0]);

    // Se verifica si el usuario seleccionó un tipo de equipo.
    if (tipoEquipo != null) {
        // Se utiliza un bloque switch para determinar qué tipo de equipo se seleccionó y llamar al método para mostrar
        // los equipos registrados de ese tipo específico.
        switch (tipoEquipo) {
            case "Desktops":
                mostrarEquipos(equipos, Desktop.class);// Llama al método para mostrar los equipos de escritorio.
                break;
            case "Laptops":
                mostrarEquipos(equipos, Laptop.class); // Llama al método para mostrar las laptops.
                break;
            case "Tablets":
                mostrarEquipos(equipos, Tablet.class);// Llama al método para mostrar las tablets.
                break;
        }
    }
}

private static void mostrarEquipos(List<Equipo> equipos, Class<? extends Equipo> tipoEquipo) {
    // Se crea una lista para almacenar los equipos filtrados por el tipo especificado.
    List<Equipo> equiposFiltrados = new ArrayList<>();
    // Se itera sobre todos los equipos registrados.
        for (Equipo equipo : equipos) {
        // Se verifica si el equipo actual es una instancia del tipo de equipo especificado.
        if (tipoEquipo.isInstance(equipo)) {
            // Si el equipo es del tipo especificado, se agrega a la lista de equipos filtrados.
            equiposFiltrados.add(equipo);
        }
    }

    // Se verifica si no se encontraron equipos del tipo especificado.
    if (equiposFiltrados.isEmpty()) {
        // Si no se encontraron equipos, se muestra un mensaje indicando que no hay equipos registrados de ese tipo.
        JOptionPane.showMessageDialog(null, "No hay equipos registrados de este tipo.", "Ver Equipos",
                JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Si se encontraron equipos del tipo especificado, se construye un mensaje con la información de cada equipo.
        StringBuilder message = new StringBuilder();
        for (Equipo equipo : equiposFiltrados) {
            // Se agrega el tipo de equipo al mensaje seguido de su información detallada.
            if (equipo instanceof Desktop) {
                message.append("+++++ Desktop +++++\n")
                        .append(((Desktop) equipo).toString()).append("\n");
            } else if (equipo instanceof Laptop) {
                message.append("+++++ Laptop +++++\n")
                        .append(((Laptop) equipo).toString()).append("\n");
            } else if (equipo instanceof Tablet) {
                message.append("+++++ Tablet +++++\n")
                        .append(((Tablet) equipo).toString()).append("\n");
            }
        }
        // Se muestra un cuadro de diálogo con el mensaje que contiene la información de los equipos del tipo especificado.
        JOptionPane.showMessageDialog(null, message.toString(), "Ver " + tipoEquipo.getSimpleName(),
                JOptionPane.INFORMATION_MESSAGE);
        }
    }   
}

