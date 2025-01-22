package client;

import rmi.VotingService;

import java.rmi.Naming;

public class VotingClient {
    public static void main(String[] args) {
        try {
            VotingService service = (VotingService) Naming.lookup("rmi://localhost/VotingService");

            if (service.authenticateUser("user1", "password1")) {
                System.out.println("Authenticated!");
                boolean voted = service.castVote("user1", "Candidate A");
                System.out.println(voted ? "Vote cast successfully!" : "You have already voted.");
            } else {
                System.out.println("Authentication failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

