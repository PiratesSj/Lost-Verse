package Three.LostAndFound.repository;

import Three.LostAndFound.model.Item;
import Three.LostAndFound.model.ItemType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item,String > {
    List<Item> findByType(String type);
    List<Item> findByLocationContaining(String location);
}