package com.io.nest.service;

import com.io.nest.exception.DeviceNotFoundException;
import com.io.nest.model.DeviceDetail;


public interface DeviceInfoService {

	public DeviceDetail addDetail(DeviceDetail detail);

	public DeviceDetail getDetail(long dId) throws DeviceNotFoundException;

	public int getActiveDevices()throws DeviceNotFoundException;

	public int getInActiveDevices() throws DeviceNotFoundException;

	public int getIssueDevices() throws DeviceNotFoundException;

	public Object getDevices() throws DeviceNotFoundException;
	public Object getDevicesList() throws DeviceNotFoundException;

	
}
