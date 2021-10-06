package com.example.securebydesign.competition1;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

public final class SocialNumber implements Externalizable {

private final char[] nationalNumber;
private boolean isUsed=false;

public SocialNumber(final char[] nationalNumber){
    this.nationalNumber= validateNationalNumber(nationalNumber).clone();
}

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
    throw new UnsupportedOperationException();
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException();

    }

    private char[] validateNationalNumber(final char[] nationalNumber){

        StringEscapeUtils.escapeHtml4(nationalNumber.toString());
        Validate.matchesPattern("[0-9]+",nationalNumber.toString());
        Validate.exclusiveBetween(0,14,nationalNumber.length);
        Validate.notNull(nationalNumber);

        return nationalNumber;
    }

    public synchronized char[] getNationalNumber() throws IllegalAccessException{

    if(isUsed) {
        throw new IllegalAccessException();
    }

    final char[] value=nationalNumber.clone();
        Arrays.fill(nationalNumber,'0');
        isUsed=true;
        return value;


    }
}
