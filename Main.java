import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();
        Scanner sc = new Scanner(System.in);
        String opcionMenu;

        // Datos de prueba iniciales
        colaEmergencias.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        colaEmergencias.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        colaEmergencias.add(new Paciente("Lorenzo Toledo", "chikunguya", 'E'));

        boolean loop = true;
        while (loop) {
            System.out.println("\n=== SISTEMA DE EMERGENCIAS HOSPITALARIAS ===");
            System.out.println("1. Agregar nuevo paciente");
            System.out.println("2. Atender siguiente paciente");
            System.out.println("3. Mostrar todos los pacientes en espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcionMenu = sc.nextLine();

            switch (opcionMenu) {
                case "1": 
                    System.out.println("\n--- AGREGAR NUEVO PACIENTE ---");
                    
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    
                    System.out.print("Síntoma o diagnóstico: ");
                    String sintoma = sc.nextLine();
                    
                    char codigo;
                    System.out.print("Código de emergencia (A-E, donde A es máxima prioridad): ");
                    codigo = sc.nextLine().toUpperCase().charAt(0);
                    if (codigo < 'A' || codigo > 'E') {
                        System.out.println("El código debe ser una letra entre A y E");
                        break;
                    }
                        Paciente nuevoPaciente = new Paciente(nombre, sintoma, codigo);
                        colaEmergencias.add(nuevoPaciente);
                        
                        System.out.println("\nPaciente agregado correctamente:");
                        System.out.println(nuevoPaciente);
                    
                    break;
                

                case "2": {
                    System.out.println("\n--- ATENDER SIGUIENTE PACIENTE ---");
                    
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
                    
                    // Para mostrar todos sin modificar la cola original
                    PriorityQueue<Paciente> copia = new VectorHeap<>();
                    int posicion = 1;
                    
                    while (!colaEmergencias.isEmpty()) {
                        Paciente p = colaEmergencias.remove();
                        System.out.println(posicion++ + ". " + p);
                        copia.add(p);
                    }
                    
                    // Restaurar la cola original
                    while (!copia.isEmpty()) {
                        colaEmergencias.add(copia.remove());
                    }
                    
                    System.out.println("\nTotal de pacientes en espera: " + (posicion - 1));
                    break;
                }
                
                case "4":
                    loop = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Opción invalida");
            }
        }

        sc.close();
    }
}