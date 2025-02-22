package Three.LostAndFound.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "items")
public class Item {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private String imageUrl;
    private ItemType type; // LOST or FOUND
    private ItemStatus status = ItemStatus.PENDING;

    @DBRef
    private User user;
}

enum ItemStatus { PENDING, MATCHED, RETURNED }