package com.example.securebydesign.competition1;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;

/**
 * 
 * Design a class that contains 1 field to be used for storing customer’s complaint on online shopping website?
 *
 */
public class CustomerComplaint {
    private static final int MIN_LENGTH_complaint=0;
    private static final int MAX_LENGTH_complaint=2147483646;
    private String complaint;
    public CustomerComplaint(String complaint){

        validateComplaint(complaint);
        this.complaint= StringEscapeUtils.escapeHtml4(complaint);

    }


    private void validateComplaint(String complaint){
            Validate.exclusiveBetween(MIN_LENGTH_complaint,MAX_LENGTH_complaint,complaint.length());
            Validate.notNull(complaint);
    }
}
