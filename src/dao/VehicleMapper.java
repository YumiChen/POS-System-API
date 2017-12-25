package dao;

import java.util.List;

import vo.Vehicle;

public interface VehicleMapper {
public void addVehicle(Vehicle b);
	
	public void modifyVehicle(Vehicle b);
	
	public void deleteVehicle(Vehicle b);
	
	public Vehicle selectVehicle(Vehicle b);
	
	public List<Vehicle> queryVehicle(Vehicle b);
	
	public Integer countVehicle(Vehicle b);
}
