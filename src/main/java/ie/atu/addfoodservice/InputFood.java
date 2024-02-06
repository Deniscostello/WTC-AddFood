package ie.atu.addfoodservice;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "inputFood")
public class InputFood {
    @NotBlank(message = "Food Id cannot not blank")
    private int foodId;

    @NotBlank(message = "Food Image cannot be blank")
    private String foodImage;
}






