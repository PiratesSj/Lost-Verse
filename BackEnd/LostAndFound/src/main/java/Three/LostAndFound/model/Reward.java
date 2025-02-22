package Three.LostAndFound.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rewards")
public class Reward {
        @Id
        private String id;
        private int points;

        @DBRef
        private Item item;

        @DBRef
        private User user;
}