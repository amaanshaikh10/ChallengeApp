package com.apiproject.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private long nextId = 1L;

    public ChallengeService() {
        Challenge challenge1 = new Challenge(nextId++, "jan", "This is the default challenge.");
        challenges.add(challenge1);
    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public Challenge getChallenge(String month) {
        for (Challenge challenge : challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month)) { // Case-insensitive comparison
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(long id, Challenge updatedChallenge) {
        for (Challenge challenge : challenges) {
            if (challenge.getId() == id) { // ✅ Corrected condition
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean addChallenge(Challenge newChallenge) {
        if (newChallenge != null) {
            newChallenge.setId(nextId++); // ✅ Assign a unique ID
            challenges.add(newChallenge);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(long id) {
       return challenges.removeIf(challenge -> challenge.getId() == id);
    }
}
