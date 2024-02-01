package com.restapi.restdemo.cntroller;

import com.restapi.restdemo.model.CloudVendor;
import com.restapi.restdemo.response.ResponseHandler;
import com.restapi.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class cloudAPIServices {
    CloudVendorService cloudVendorService;
    public cloudAPIServices(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
    @GetMapping("{vendorID}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorID") String vendorID){
       return ResponseHandler.responseBuilder("Requested vendor details", HttpStatus.OK,  cloudVendorService.getCloudVendor(vendorID));
        //return  cloudVendorService.getCloudVendor(vendorID);
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){

        return  cloudVendorService.getAllCloudVendor();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }
    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
    return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorID}")
    public String deleteCloudVendor(@PathVariable("vendorID") String vendorID){
        cloudVendorService.deleteCloudVendor(vendorID);
        return "Cloud Vendor Deleted Successfully";
    }
}
