package dao;

import java.util.List;

import vo.Place;

public interface PlaceMapper {
	public void addPlace(Place b);
	public void modifyPlace(Place b);
	
	public void deletePlace(Place b);
	
	public Place selectPlace(Place b);
	
	public List<Place> queryPlace(Place b);
	
	public Integer countPlace(Place b);
}
