package com.io.nest.service.impl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.nest.exception.ClusterNotFoundException;
import com.io.nest.model.Cluster;
import com.io.nest.model.DeviceDetail;
import com.io.nest.model.Status;
import com.io.nest.repository.ClusterRepository;
import com.io.nest.repository.DeviceRepository;
import com.io.nest.service.ClusterService;



@Service
public class ClusterServiceImpl implements ClusterService{
	
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Override
	public Cluster addCluster(Cluster c) {
		
		return clusterRepository.save(c);
	}

	@Override
	public DeviceDetail insertCluster(DeviceDetail ddetail, String cId) {
		Cluster c = clusterRepository.getClusterById(cId);
		c.getDeviceDetail().add(ddetail);
		DeviceDetail dd = deviceRepository.save(ddetail);
		return dd;
	}

	@Override
	public String getClusterStatus(String cid) throws ClusterNotFoundException {
		Cluster c= clusterRepository.getClusterById(cid);
		List<DeviceDetail> d = c.getDeviceDetail();
		
		int flag = 0;
		String a = "GREEN";
		String b = "RED";
		for(DeviceDetail dd: d) {
			if(dd.getStatus() !=Status.ACTIVE) {
				flag = 1;
				break;
			}
		}
		if(flag==0) {
			return a;
		}
		return b;
	}

	@Override
	public List<String> getCluster() throws ClusterNotFoundException {
		List<Cluster> cluster = clusterRepository.findAll();
		List<String> s = new ArrayList<>();
		int i =0;
		for(Cluster c: cluster) {
			 s.add(c.getClusterId());
			
		
		}
		return s;
		
		
	}

	@Override
	public Object getDevicesCorrespongClusterId(String cId) throws ClusterNotFoundException {
		Cluster c= clusterRepository.getClusterById(cId);
		List<DeviceDetail> d = c.getDeviceDetail();
		List<Long> l = new ArrayList<>();
		for(DeviceDetail dd: d) {
			l.add(dd.getDeviceId());
		}
		return l;
	}
	
	@Override
	public List<DeviceDetail> getDeviceDetail(String cId) {
		int size =5;
		int page =5;
		Pageable pagable = PageRequest.of(page,size);
		Cluster c= clusterRepository.getClusterById(cId);
		
		List<DeviceDetail> d = c.getDeviceDetail();
		return d;
	}
}
