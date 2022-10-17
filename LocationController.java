package com.locationWebi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationWebi.Entity.Location;
import com.locationWebi.Service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping("/show")
	public String showpage() {
		return"create_location";
	}
	
	@RequestMapping("saveLocation")
    public String saveLocation(Location location, ModelMap model) {
		model.addAttribute("msg","record is saved!!");
		locationService.saveLocation(location);
		
    	return"create_location";
    }
	
	@RequestMapping("/listAll")
	  public String listAll(ModelMap model) {
		 List<Location> location=locationService.getAllLocation();
		 model.addAttribute("location",location);
		 return"search_result";		  
	  }
	
	@RequestMapping("/delete")
	public String deleteLocation(@RequestParam("id") long id,ModelMap model) {
			locationService.deleteLocationById(id);
	List<Location> location = locationService.getAllLocation();
	model.addAttribute("location",location);
		return"search_result";
		
	}
	@RequestMapping("update")
     public String updateDataLocation(@RequestParam("id") long id,ModelMap model) {
    	Location location= locationService.getLocationById(id);
    	model.addAttribute("location",location );
    	 return"update_location";
    	 
     }
	@RequestMapping("/updateData")
	public String UpdateLocation(Location location, ModelMap model) {
			model.addAttribute("msg","Record is updated");
			locationService.saveLocation(location);
		return"update_location";
	}
}
