package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarsDAO;
import web.models.Car;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private final CarsDAO carsDAO;

    @Autowired
    public CarServiceImpl(CarsDAO carsDAO) {
        this.carsDAO = carsDAO;
    }

    @Override
    public List<Car> getCars(int count) {
        return carsDAO.getCars(count);
    }
}
