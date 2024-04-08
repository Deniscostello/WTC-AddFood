package ie.atu.addfoodservice;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usersFood")
public class InputFood {
    @NotBlank(message = "Food name cannot not blank")
    private String foodName;

    private List<String> foods;

    @NotBlank(message = "Food Image cannot be blank")
    private String image;

    @Id
    private String userId;
}






