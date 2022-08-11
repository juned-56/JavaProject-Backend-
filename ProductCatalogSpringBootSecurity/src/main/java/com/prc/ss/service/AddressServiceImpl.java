package com.prc.ss.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prc.ss.model.Address;
import com.prc.ss.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address addAddress(Address adrs) {
		return addressRepository.save(adrs);
	}

	@Override
	public Address UpdateAddress(Address adrss) {
		return addressRepository.save(adrss);
	}

	@Override
	public Optional<Address> getAddressById(int id) {
		return addressRepository.findById(id);
	}

	@Override
	public Iterable<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public void deleteAddressById(int id) {
		addressRepository.deleteById(id);
	}

}
