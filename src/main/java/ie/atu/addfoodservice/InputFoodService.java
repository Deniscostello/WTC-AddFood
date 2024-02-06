package ie.atu.addfoodservice;

import org.springframework.stereotype.Service;

@Service
public class InputFoodService {
    private final FoodRepository foodRepository;

    public InputFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public InputFood addFood(InputFood inputFood) {
        System.out.println(inputFood);
        return foodRepository.save(inputFood);
    }
}
