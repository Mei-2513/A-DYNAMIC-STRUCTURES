package view;

import java.util.Scanner;

import controller.MedicalCenterController;
import model.Patient;

public class MedicalCenterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalCenterController controller = new MedicalCenterController();

        while (true) {
            System.out.print("Ingrese el nombre del paciente (o escribe 'salir' para terminar): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingrese el nivel de gravedad del paciente: ");
            int severity = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente

            controller.addPatient(name, severity);
        }

        System.out.println("\nTurnos de pacientes atendidos en orden de gravedad:");
        while (controller.hasPatients()) { // Verificar si hay pacientes en la cola
            Patient patient = controller.getNextPatient();
            System.out.println("Paciente: " + patient.getName() + " - Gravedad: " + patient.getSeverity());
        }
    }
}


