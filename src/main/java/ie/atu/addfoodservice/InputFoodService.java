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

        if (existingFood.isPresent()) {
            InputFood food = existingFood.get();
            List<String> foodList = food.getFoods();
            if (foodList != null) {
                foodList.add(inputFood.getFoodName());
                food.setFoods(foodList);
            } else {
                List<String> newfoodList = new ArrayList<>();
                newfoodList.add(inputFood.getFoodName());
                food.setFoods(newfoodList);
            }
            return foodRepository.save(food);

        }
        return inputFood;
    }


    public InputFood addRecipe(InputFood inputFood) {
        Optional<InputFood> existingFood = foodRepository.findByUserId(inputFood.getUserId());

        if (existingFood.isPresent()) {
            InputFood food = existingFood.get();
            List<Integer> recipeList = food.getRecipeSaved();
            if (recipeList != null){
                recipeList.add(inputFood.getRecipeId());
                food.setRecipeSaved(recipeList);
            }
            else {
                List<Integer> newrecipeList = new ArrayList<>();
                newrecipeList.add(inputFood.getRecipeId());
                food.setRecipeSaved(newrecipeList);
            }
            return foodRepository.save(food);
        }
        return inputFood;
    }




//    public InputFood addRecipe(InputFood inputFood) {
//        Optional<InputFood> existingFood = foodRepository.findByUserId(inputFood.getUserId());
//        if (existingFood.isPresent()) {
//            InputFood userFood = existingFood.get();
//            System.out.println(foodRepository.findByUserId(inputFood.getUserId()));
//            userFood.setRecipeId(inputFood.getRecipeId());
//            List<Integer> favRecipes = userFood.getRecipeSaved();
//            favRecipes.add(inputFood.getRecipeId());
//            userFood.setRecipeSaved(favRecipes);
//            foodRepository.save(userFood);
//
//        }
//        return inputFood;
//    }

//    public InputFood addRecipe(InputFood inputFood) {
//        Optional<InputFood> existingFood = foodRepository.findByUserId(inputFood.getUserId());
//        if (existingFood.isPresent()) {
//            InputFood food = existingFood.get();
//            List<Integer> favRecipes = food.getRecipeSaved();
//            if (favRecipes != null) {
//                favRecipes.add(inputFood.getRecipeId());
//                inputFood.setRecipeSaved(favRecipes);
//            } else {
//                List<Integer> newFavList = new ArrayList<>();
//                newFavList.add(food.getRecipeId());
//                inputFood.setRecipeSaved(newFavList);
//                return foodRepository.save(inputFood);
//            }
//            return foodRepository.save(inputFood);
//        }
//        return null;
//    }
}
