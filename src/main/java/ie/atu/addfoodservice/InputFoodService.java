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

//    public InputFood addFood(InputFood inputFood) {
//        Optional<InputFood> existingFood = foodRepository.findByUserId(inputFood.getUserId());
//        System.out.println(existingFood);
//
//        if(existingFood.isPresent()){
//            InputFood food = existingFood.get();
//            List<String> foodList = food.getFoods();
//            if (foodList!= null) {
//                foodList.add(inputFood.getFoodName());
//                inputFood.setFoods(foodList);
//            }
//            else {
//                List<String> newfoodList = new ArrayList<>();
//                String firstFood = food.getFoodName();
//                newfoodList.add(firstFood);
//                newfoodList.add(inputFood.getFoodName());
//                inputFood.setFoods(newfoodList);
//            }
//        }
//
//        return foodRepository.save(inputFood);
//    }

    public InputFood addFood(InputFood inputFood) {
        InputFood user = foodRepository.findByUserId(inputFood.getUserId());
        System.out.println(foodRepository.findByUserId(inputFood.getUserId()));
        user.setFoodName(inputFood.getFoodName());
        List<String> userFoods = user.getFoods();
        userFoods.add(inputFood.getFoodName());
        user.setFoods(userFoods);
        foodRepository.save(user);
        return inputFood;
    }


    public InputFood addRecipe(InputFood inputFood) {
        InputFood userFood = foodRepository.findByUserId(inputFood.getUserId());
        System.out.println(foodRepository.findByUserId(inputFood.getUserId()));
        userFood.setRecipeId(inputFood.getRecipeId());
        List<Integer> favRecipes = userFood.getRecipeSaved();
        favRecipes.add(inputFood.getRecipeId());
        userFood.setRecipeSaved(favRecipes);
        foodRepository.save(userFood);
        return inputFood;
    }
}
