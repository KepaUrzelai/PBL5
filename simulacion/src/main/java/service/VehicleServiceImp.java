package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import clases.Vehicle;
import vehicles.dao.DaoVehiclesItem;

@Service
public class VehicleServiceImp implements VehicleService{
	
	@Autowired
	private DaoVehiclesItem vehiclesDao;

	@Transactional
	@Override
	public boolean add(Vehicle vehicle) {
		return vehiclesDao.add(vehicle);
	}

}
