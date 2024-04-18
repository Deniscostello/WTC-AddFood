package ie.atu.addfoodservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InputFoodService {
    private final FoodRepository foodRepository;

    public InputFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public InputFood addFood(InputFood inputFood) {
        Optional<InputFood> existingFood = foodRepository.findByUserId(inputFood.getUserId());

        if(existingFood.isPresent()){
            InputFood food = existingFood.get();
            List<String> foodList = food.getFoods();
            foodList.add(inputFood.getFoodName());
            return foodRepository.save(food);
        }
        else {
            List<String> newfoodList = new ArrayList<>();
            newfoodList.add(inputFood.getFoodName());
            inputFood.setFoods(newfoodList);
            return foodRepository.save(inputFood);
        }
    }


    public InputFood addRecipe(InputFood inputFood) {
        Optional<InputFood> existingFood = foodRepository.findByUserId(inputFood.getUserId());
        if (existingFood.isPresent()) {
            InputFood userFood = existingFood.get();
            System.out.println(foodRepository.findByUserId(inputFood.getUserId()));
            userFood.setRecipeId(inputFood.getRecipeId());
            List<Integer> favRecipes = userFood.getRecipeSaved();
            favRecipes.add(inputFood.getRecipeId());
            userFood.setRecipeSaved(favRecipes);
            foodRepository.save(userFood);

        }
        return inputFood;
    }
}
