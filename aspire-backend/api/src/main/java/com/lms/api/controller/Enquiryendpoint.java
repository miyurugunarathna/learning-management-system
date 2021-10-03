package com.lms.api.controller;

import com.lms.api.domain.Enquiry;
import com.lms.api.domain.Notice;
import com.lms.api.dto.EnquiryDto;
import com.lms.api.service.EnquiryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enquiries")
public class Enquiryendpoint {
    private EnquiryApi enquiryApi;

    @Autowired
    public Enquiryendpoint(EnquiryApi enquiryApi) {
        this.enquiryApi = enquiryApi;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enquiry addEnquiry(@RequestBody EnquiryDto enquiryDto){
        Enquiry enquiry = new Enquiry();
        enquiry.setName(enquiryDto.getName());
        enquiry.setEmail(enquiryDto.getEmail());
        enquiry.setMessage(enquiryDto.getMessage());
        return enquiryApi.addEnquiry(enquiry);

    }
    @GetMapping
    public List<Enquiry> getEnquiries(){
        return enquiryApi.getAllEnquiries();
    }

    @DeleteMapping("/{enquiryid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String enquiryid ){
        enquiryApi.delete(enquiryid);

    }
}
