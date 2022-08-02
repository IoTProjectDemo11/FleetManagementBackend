package com.io.nest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.nest.exception.DeviceNotFoundException;
import com.io.nest.model.Cluster;
import com.io.nest.model.DeviceDetail;
import com.io.nest.model.Status;
import com.io.nest.repository.ClusterRepository;
import com.io.nest.repository.DeviceRepository;
import com.io.nest.service.DeviceInfoService;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Override
	public DeviceDetail addDetail(DeviceDetail ddetail) {
		return deviceRepository.save(ddetail);
	}

	@Override
	public DeviceDetail getDetail(long dId) throws DeviceNotFoundException{
		if(!deviceRepository.existsById(dId)) {
			throw new DeviceNotFoundException("Device with that Id does not exists");
		}
		return deviceRepository.findById(dId).get();
	}

	@Override
	public int getActiveDevices() throws DeviceNotFoundException{
		List<DeviceDetail> ddetail = deviceRepository.findAll();
		int count = 0;
		for(DeviceDetail d: ddetail) {
			if(d.getStatus()==Status.ACTIVE) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getInActiveDevices() throws DeviceNotFoundException{
		List<DeviceDetail> ddetail = deviceRepository.findAll();
		int count = 0;
		for(DeviceDetail d: ddetail) {
			if(d.getStatus()==Status.INACTIVE) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getIssueDevices() throws DeviceNotFoundException {
		List<DeviceDetail> ddetail = deviceRepository.findAll();
		int count = 0;
		for(DeviceDetail d: ddetail) {
			if(d.getStatus()==Status.ISSUES) {
				count++;
			}
		}
		return count;
	}

	@Override
	public List<Long> getDevices() throws DeviceNotFoundException {
		List<DeviceDetail> dd = deviceRepository.findAll();
		List<Long> s = new ArrayList<>();
		int i =0;
		for(DeviceDetail d: dd) {
			 s.add(d.getDeviceId());	
		
		}
		return s;
	}
	
	@Override
	public Object getDevicesList() throws DeviceNotFoundException {
		List<DeviceDetail> dd = deviceRepository.findAll();
//		List<Long> s = new ArrayList<>();
//		int i =0;
//		for(DeviceDetail d: dd) {
//			s.add
//		}
		return dd;
	}


	
}
