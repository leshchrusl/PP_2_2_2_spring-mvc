package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CarsDAOImpl implements CarsDAO {

    private final List<Car> cars = new ArrayList<>(Arrays.asList(
                            new Car(1, "Лада", "Гранта"),
                            new Car(2, "Ford","Focus"),
                            new Car(3, "Kia", "Rio"),
                            new Car(4, "Reno", "Logan"),
                            new Car(5, "Volkswagen ", "Golf")
    ));

    @Override
    public List<Car> getCars(int count) {

        if (count >= 0 && count < 5) {
            return this.cars.stream().limit(count).toList();
        }

        return cars;
    };

}
