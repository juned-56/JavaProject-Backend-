package com.prc.ss.service;

import java.util.Optional;

import com.prc.ss.model.Address;

public interface AddressService {

	public Address addAddress(Address adrs);
	
	public Address UpdateAddress(Address ardss);
	
	public Optional<Address> getAddressById(int id);
	
	public Iterable<Address> getAllAddress();
	
	public void deleteAddressById(int id);
}
