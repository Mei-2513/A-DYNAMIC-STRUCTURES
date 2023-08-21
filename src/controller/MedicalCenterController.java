package controller;

import java.util.PriorityQueue;

import model.Patient;

public class MedicalCenterController {
    private PriorityQueue<Patient> queue;

    public MedicalCenterController() {
        queue = new PriorityQueue<>();
    }

    public void addPatient(String name, int severity) {
        Patient patient = new Patient(name, severity);
        queue.add(patient);
    }

    public Patient getNextPatient() {
        return queue.poll();
    }

    public boolean hasPatients() {
        return !queue.isEmpty();
    }
}

