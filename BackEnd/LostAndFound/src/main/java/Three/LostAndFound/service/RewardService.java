package Three.LostAndFound.service;

import Three.LostAndFound.model.Reward;
import Three.LostAndFound.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RewardService{
    @Autowired
    private RewardRepository rewardRepository;

    // CREATE
    public Reward createReward(Reward reward) {
        return rewardRepository.save(reward);
    }

    // READ (ALL)
    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    // READ (BY ID)
    public Optional<Reward> getRewardById(String id) {
        return rewardRepository.findById(id);
    }

    // UPDATE
    public Reward updateReward(String id, Reward updatedReward) {
        return rewardRepository.findById(id)
                .map(reward -> {
                    reward.setPoints(updatedReward.getPoints());
                    return rewardRepository.save(reward);
                })
                .orElseThrow(() -> new RuntimeException("Reward not found with id: " + id));
    }

    // DELETE
    public void deleteReward(String id) {
        rewardRepository.deleteById(id);
    }
}