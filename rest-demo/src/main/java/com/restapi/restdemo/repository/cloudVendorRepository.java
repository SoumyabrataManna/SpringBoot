package com.restapi.restdemo.repository;

import com.restapi.restdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cloudVendorRepository extends JpaRepository <CloudVendor, String>{

}
