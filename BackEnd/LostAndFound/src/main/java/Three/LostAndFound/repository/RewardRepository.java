package Three.LostAndFound.repository;

import Three.LostAndFound.model.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends MongoRepository<Reward,String > {

}