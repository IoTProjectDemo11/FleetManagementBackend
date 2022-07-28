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
import com.io.nest.model.Cluster;
import com.io.nest.model.DeviceDetail;
import com.io.nest.service.ClusterService;


@RestController
@RequestMapping("/Cluster")
@CrossOrigin("*")

public class ClusterController {
	@Autowired
	private ClusterService clusterSerice;
	
	//adding cluster id and cluster name to the table Cluster
	@PostMapping("/clusterInfo")
	public Cluster postCluster(@RequestBody Cluster c ) {
		return clusterSerice.addCluster(c);
	}
	
	//adding device details corresponding to cluster id to the table DeviceDetail
	@PostMapping("/{cid}")
	public DeviceDetail postMobile(@RequestBody DeviceDetail ddetail,@PathVariable(value = "cid") String cId ) {
		return clusterSerice.insertCluster(ddetail, cId);
	}
	
	//checking the status of devices in cluster, if all devices in a cluster are active =>GREEN, else=> RED
	@GetMapping("/CheckCluster/{cId}")
	public ResponseEntity<?> getClusterStatus(@PathVariable(value = "cId")String cid) throws ClusterNotFoundException {
		return new ResponseEntity<>(clusterSerice.getClusterStatus(cid),HttpStatus.OK);
	}
	
	//get the list of clusters
	@GetMapping("/cluster")
	public  ResponseEntity<?> getCluster() throws ClusterNotFoundException {
		return new ResponseEntity<>(clusterSerice.getCluster(),HttpStatus.OK);
	}
	
	//get list of devices corresponding to the cluster id
	@GetMapping("cluster:devices/{clusterId}")
	public  ResponseEntity<?> getDevices(@PathVariable(value ="clusterId") String cId) throws ClusterNotFoundException {
		return new ResponseEntity<>(clusterSerice.getDevicesCorrespongClusterId(cId),HttpStatus.OK);
	} 
	
	
}
