package Three.LostAndFound.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
        @Id
        private String id;
        private String email;
        private String password;
        private String role = "ROLE_USER";
}