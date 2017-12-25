package dao;

import java.util.List;

import vo.PlaceType;

public interface PlaceTypeMapper {
public void addPlaceType(PlaceType b);
	
	public void modifyPlaceType(PlaceType b);
	
	public void deletePlaceType(PlaceType b);
	
	public PlaceType selectPlaceType(PlaceType b);
	
	public List<PlaceType> queryPlaceType(PlaceType b);
	
	public Integer countPlaceType(PlaceType b);
}
