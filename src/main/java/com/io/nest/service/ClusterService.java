package com.io.nest.service;

import com.io.nest.exception.ClusterNotFoundException;
import com.io.nest.model.Cluster;
import com.io.nest.model.DeviceDetail;

public interface ClusterService {
	
	public Cluster addCluster(Cluster c);

	public DeviceDetail insertCluster(DeviceDetail ddetail, String cId);

	public String getClusterStatus(String cid) throws ClusterNotFoundException;

	public Object getCluster() throws ClusterNotFoundException;

	public Object getDevicesCorrespongClusterId(String cId) throws ClusterNotFoundException;


}
