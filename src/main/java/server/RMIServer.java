package server;

import rmi.VotingService;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class RMIServer {
    public static void main(String[] args) {
        try {
            VotingService service = new VotingServiceImpl();
            LocateRegistry.createRegistry(1099); // Start RMI registry on port 1099.
            Naming.rebind("VotingService", service);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

