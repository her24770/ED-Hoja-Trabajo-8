import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Seleccione el tipo de cola de prioridad:");
        System.out.println("1. VectorHeap (Implementación custom)");
        System.out.println("2. Java Collection Framework (Estándar)");
        System.out.print("Opción: ");
        
        String queueType = scanner.nextLine();
        
        InterfacePriorityQueue<Paciente> colaEmergencias;
        colaEmergencias = PriorityQueueFactory.createPriorityQueue(queueType);
        cargarPacientes(colaEmergencias, "pacientes.txt");

        String opcion="";
        boolean loop=true;
        while(loop){
            System.out.println("\n=== SISTEMA DE EMERGENCIAS HOSPITALARIAS ===");
            System.out.println("1. Agregar nuevo paciente");
            System.out.println("2. Atender siguiente paciente");
            System.out.println("3. Mostrar todos los pacientes en espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1": {
                    System.out.println("\n--- AGREGAR NUEVO PACIENTE ---");
                    
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Síntoma o diagnóstico: ");
                    String sintoma = scanner.nextLine();
                    
                    char codigo;
                    System.out.print("Código de emergencia (A-E, donde A es máxima prioridad): ");
                    codigo = scanner.nextLine().toUpperCase().charAt(0);
                    if (codigo < 'A' || codigo > 'E') {
                        System.out.println("Error: El código debe ser una letra entre A y E");
                        break;
                    }

                    Paciente nuevoPaciente = new Paciente(nombre, sintoma, codigo);
                    colaEmergencias.add(nuevoPaciente);
                    
                    System.out.println("\nPaciente agregado correctamente:");
                    System.out.println(nuevoPaciente);
                    break;
                }
                
                case "2": {
                    System.out.println("\n--- ATENDER PACIENTE ---");
                    
                    if (colaEmergencias.isEmpty()) {
                        System.out.println("No hay pacientes en espera.");
                        break;
                    }
                    
                    Paciente atendido = colaEmergencias.remove();
                    System.out.println("Paciente atendido:");
                    System.out.println(atendido);
                    break;
                }
                
                case "3": {
                    System.out.println("\n--- PACIENTES EN ESPERA ---");
                    
                    if (colaEmergencias.isEmpty()) {
                        System.out.println("No hay pacientes en espera.");
                        break;
                    }
                    
                    InterfacePriorityQueue<Paciente> copia = PriorityQueueFactory.createPriorityQueue(queueType);
                    
                    int posicion = 1;
                    
                    while (!colaEmergencias.isEmpty()) {
                        Paciente p = colaEmergencias.remove();
                        System.out.println(posicion++ + ". " + p);
                        copia.add(p);
                    }
                    
                    while (!copia.isEmpty()) {
                        colaEmergencias.add(copia.remove());
                    }
                    
                    System.out.println("\nTotal de pacientes en espera: " + (posicion - 1));
                    break;
                }
                
                case "4":
                    System.out.println("Saliendo del sistema...");
                    loop = false;
                    break;
                    
                default:
                    System.out.println("Opción invalida");
            }
        }

        scanner.close();
    }

    private static void cargarPacientes(InterfacePriorityQueue<Paciente>cola, String nombreArchivo) {
        try {
            Scanner lector = new Scanner(new File(nombreArchivo));
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(",");
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String sintoma = datos[1].trim();
                    char codigo = datos[2].trim().toUpperCase().charAt(0);
                    cola.add(new Paciente(nombre, sintoma, codigo));
                }
            }
            lector.close();
            System.out.println("Pacientes cargados exitosamente desde: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        }
    }
}