package ie.atu.addfoodservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputFoodController {
    private final InputFoodService inputfoodService;

    public InputFoodController(InputFoodService inputfoodService) {
        this.inputfoodService = inputfoodService;
    }



   @PostMapping("food/addNewFood")
    public ResponseEntity<InputFood> addFood(@RequestBody InputFood inputFood) {
        InputFood addedFood = inputfoodService.addFood(inputFood);
        return ResponseEntity.ok(addedFood);
    }



    @PostMapping("food/addNewRecipeId")
    public ResponseEntity<InputFood> addRecipeId(@RequestBody InputFood inputFood) {
        InputFood addedFood = inputfoodService.addRecipe(inputFood);
        return ResponseEntity.ok(addedFood);
    }

}
