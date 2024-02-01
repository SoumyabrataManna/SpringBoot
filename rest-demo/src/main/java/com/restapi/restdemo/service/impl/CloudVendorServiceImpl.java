package com.restapi.restdemo.service.impl;

import com.restapi.restdemo.exception.CloudVendorNotFoundException;
import com.restapi.restdemo.model.CloudVendor;
import com.restapi.restdemo.repository.cloudVendorRepository;
import com.restapi.restdemo.response.ResponseHandler;
import com.restapi.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    cloudVendorRepository CloudVendorRepository;
    public CloudVendorServiceImpl(cloudVendorRepository cloudVendorRepository) {
        CloudVendorRepository = cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        CloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        CloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        CloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {

        if(CloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud vendor does not exists");
        return CloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return  CloudVendorRepository.findAll();
    }
}
