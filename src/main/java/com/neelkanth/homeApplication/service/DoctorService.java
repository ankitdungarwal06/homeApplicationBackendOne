package com.neelkanth.homeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelkanth.homeApplication.model.DoctorInfo;
import com.neelkanth.homeApplication.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<DoctorInfo> getAll() {
		return doctorRepository.findAll();
	}

	public DoctorInfo fetchById(Long id) {
		Optional<DoctorInfo> response = doctorRepository.findById(id);
		if (response.isPresent()) {
			return response.get();
		} else {
			return new DoctorInfo();
		}
	}

	public List<DoctorInfo> fetchByName(String name) {
		List<DoctorInfo> response = doctorRepository.findByfirstName(name);
		return response;
	}

	public DoctorInfo save(DoctorInfo doctorObject) {
		return doctorRepository.save(doctorObject);
	}

	public void removeRecord(DoctorInfo doctorObject) {
		doctorRepository.delete(doctorObject);
	}

	public List<DoctorInfo> fetchBySpeciality(String speciality) {
		return doctorRepository.findByspecialiti(speciality);
	}

	public DoctorInfo modify(DoctorInfo object) {
		DoctorInfo resFromDb = fetchById(object.getId());
//		if (Objects.nonNull(object.getAddressChamber()) && !"".equalsIgnoreCase(object.getAddressChamber())) {
//			
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}
//		if (Objects.nonNull() && !"".equalsIgnoreCase()) {
//
//		}

		return doctorRepository.save(object);
	}

	public Void remove(Long id) {
		doctorRepository.delete(fetchById(id));
		Void d = null;
		return d;
	}
}
