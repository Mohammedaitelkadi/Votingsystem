package server;

import rmi.VotingService;
import kafka.KafkaUtils;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

public class VotingServiceImpl extends UnicastRemoteObject implements VotingService {
    private ConcurrentHashMap<String, String> userDatabase;
    private ConcurrentHashMap<String, Boolean> votedUsers;

    public VotingServiceImpl() throws RemoteException {
        userDatabase = new ConcurrentHashMap<>();
        votedUsers = new ConcurrentHashMap<>();
        userDatabase.put("user1", "password1"); // Example user.
        userDatabase.put("user2", "password2"); // Another example user.
    }

    @Override
    public boolean authenticateUser(String userId, String password) {
        return userDatabase.containsKey(userId) && userDatabase.get(userId).equals(password);
    }

    @Override
    public boolean castVote(String userId, String candidate) {
        if (votedUsers.getOrDefault(userId, false)) {
            return false; // Already voted.
        }
        votedUsers.put(userId, true);
        KafkaUtils.publishVote(candidate);
        return true;
    }
}

