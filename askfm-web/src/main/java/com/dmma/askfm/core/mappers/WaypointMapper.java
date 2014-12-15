/*package com.dmma.boat.core.mappers;

import java.util.ArrayList;
import java.util.List;

import com.dmma.boat.db.entities.Waypoint;
import com.dmma.boat.dto.web.dto.shared.entities.WaypointDTO;

*//**
 * @author <a href="mailto:dmitrijs.marcenkovs@gmail.com">Dmitrijs Marcenkovs</a>
 *//*
public class WaypointMapper{ 

	public static WaypointDTO toDTO(Waypoint source){
		if(source == null) 
			return null;
		WaypointDTO target = new WaypointDTO();
		target.setId(source.getId());
		target.setRouteId(source.getRouteId());
		target.setLatitude(source.getLatitude());
		target.setLongitude(source.getLongitude());
		target.setVisitOrder(source.getVisitOrder());
		
		return target;
	}

	public static ArrayList<WaypointDTO> toDTOs(List<Waypoint> entities){
		if(entities == null) 
			return null;
		ArrayList<WaypointDTO> retVal = new ArrayList<WaypointDTO>(entities.size());
		for(Waypoint entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static Waypoint toEntity(WaypointDTO source, Waypoint target, Long routeID){
		if(target==null){
			target = new Waypoint();
		}
		target.setId(        source.getId());
		target.setRouteId(routeID);
		target.setName("WP"+source.getVisitOrder());
		target.setLatitude(source.getLatitude());
		target.setLongitude(source.getLongitude());
		target.setVisitOrder(source.getVisitOrder());
		return target;
	}
}
*/