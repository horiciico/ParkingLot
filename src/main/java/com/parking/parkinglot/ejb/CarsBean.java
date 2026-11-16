package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDTO;
import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {

    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDTO> findAllCars()
    {
        LOG.info("findAllCars");
        try
            {
                TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
                List<Car> cars = typedQuery.getResultList();
                return copyCarsToDto(cars);
            }
        catch(Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<CarDTO> copyCarsToDto(List<Car> cars)
    {
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            String ownerName;
            if(car.getOwner()!=null)
                ownerName=car.getOwner().getUsername();
            else ownerName=null;

            carDTOs.add(new CarDTO(car.getParkingSpot(), ownerName, car.getId(), car.getLicensePlate()));
        }
        return carDTOs;
    }
}
