package com.lms.api.service;

import com.lms.api.domain.Enquiry;
import com.lms.api.domain.EnquiryDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryApi {

    private final EnquiryDataAdapter enquiryDataAdapter;

    @Autowired
    public EnquiryApi(EnquiryDataAdapter enquiryDataAdapter){
        this.enquiryDataAdapter = enquiryDataAdapter;
    }

    public List<Enquiry> getAllEnquiries(){
        return enquiryDataAdapter.getAll();
    }

    public Enquiry addEnquiry(Enquiry enquiry){
        enquiry = enquiryDataAdapter.Save(enquiry);
        return enquiry;
    }

    public void delete(String enquiryid){
        enquiryDataAdapter.delete(enquiryid);
    }
}
