package com.io.nest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deviceId;
	private String deviceName;
	private String ipAddress;
	private Date lastModified;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	private String authType;
}
