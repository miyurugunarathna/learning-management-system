package com.lms.api.domain;

import java.util.List;

public interface EnquiryDataAdapter {
    Enquiry Save(Enquiry enquiry);
    List<Enquiry> getAll();
    void delete(String enquiryid);
}
