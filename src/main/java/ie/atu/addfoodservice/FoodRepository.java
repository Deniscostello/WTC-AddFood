package ie.atu.addfoodservice;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends MongoRepository<InputFood, String> {
    Optional<InputFood> findByUserId(String userId);
}
