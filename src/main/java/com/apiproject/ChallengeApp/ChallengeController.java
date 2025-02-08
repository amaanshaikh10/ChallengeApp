package com.apiproject.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Challenges") // ✅ Base path is "/Challenges"
public class ChallengeController {
    private final ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping // ✅ Corrected: Now mapped to "/Challenges"
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    @PostMapping // ✅ Corrected: Now mapped to "/Challenges"
    public ResponseEntity<String> addChallenge(@RequestBody Challenge newChallenge) {
        boolean isChallengeAdded = challengeService.addChallenge(newChallenge);
        return isChallengeAdded ? ResponseEntity.ok("Challenge added successfully")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Challenge not added successfully");
    }

    @GetMapping("/{month}") // ✅ Corrected: Now mapped to "/Challenges/{month}"
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenge(month);
        return (challenge != null) ? ResponseEntity.ok(challenge)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}") // ✅ Corrected: Now mapped to "/Challenges/{id}"
    public ResponseEntity<String> updateChallenge(@PathVariable long id, @RequestBody Challenge updatedChallenge) {
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
        return isChallengeUpdated ? ResponseEntity.ok("Challenge updated successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Challenge not found");
    }

    @DeleteMapping("/{id}") // ✅ Corrected: Now mapped to "/Challenges/{id}"
    public ResponseEntity<String> deleteChallenge(@PathVariable long id) {
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        return isChallengeDeleted ? ResponseEntity.ok("Challenge deleted successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Challenge not found");
    }
}
