package com.io.nest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.io.nest.model.DeviceDetail;


@Repository
public interface DeviceRepository  extends JpaRepository<DeviceDetail, Long>{
	@Query("SELECT d  FROM DeviceDetail d")
	List<DeviceDetail> findAll(List<DeviceDetail> d);

}
