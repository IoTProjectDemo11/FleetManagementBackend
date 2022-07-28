package com.io.nest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.nest.exception.ClusterNotFoundException;
import com.io.nest.exception.DeviceNotFoundException;
import com.io.nest.model.DeviceDetail;
import com.io.nest.service.DeviceInfoService;

@RestController
@RequestMapping("/DeviceInformation")
@CrossOrigin("*")
public class DeviceInfoController {
	
	@Autowired
	private DeviceInfoService deviceInfoSerice;
	
	@PostMapping("/addInfo")
	public DeviceDetail postDetail(@RequestBody DeviceDetail ddetail )  {
		return deviceInfoSerice.addDetail(ddetail);
	}
	
	// getting device details corresponding to device id
	@GetMapping("/{id}")
	public ResponseEntity<?> getDetails(@PathVariable(value = "id") long dId) throws DeviceNotFoundException{
        
        return new ResponseEntity<>(deviceInfoSerice.getDetail(dId),HttpStatus.OK);
	}
	
	// total number of active devices
	@GetMapping("/active")
	public ResponseEntity<?> getActiveDevices() throws DeviceNotFoundException{
		return new ResponseEntity<>(deviceInfoSerice.getActiveDevices(),HttpStatus.OK);
	}
	
	//total number of inactive devices
	@GetMapping("/inactive")
	public ResponseEntity<?> getInActiveDevices() throws DeviceNotFoundException{
		return new ResponseEntity<>(deviceInfoSerice.getInActiveDevices(),HttpStatus.OK);
	}
	
	//total number of inactive devices
	@GetMapping("/issue")
	public ResponseEntity<?> getIssueDevices() throws DeviceNotFoundException{
		return new ResponseEntity<>(deviceInfoSerice.getIssueDevices(),HttpStatus.OK);
	}
	
	//get the list of clusters
	@GetMapping("/devices")
	public  ResponseEntity<?> getDevices() throws ClusterNotFoundException, DeviceNotFoundException {
		return new ResponseEntity<>(deviceInfoSerice.getDevices(),HttpStatus.OK);
	}
	
	
	
	
	

}
