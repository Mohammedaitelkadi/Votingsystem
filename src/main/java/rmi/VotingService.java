package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VotingService extends Remote {
    boolean authenticateUser(String userId, String password) throws RemoteException;
    boolean castVote(String userId, String candidate) throws RemoteException;
}

