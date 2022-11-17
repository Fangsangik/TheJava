package org.example.ByteCode;

public class Moim {
    public int maxNumberOfAttendes;

    public int numberOfEnrollment;

    public boolean isEnrollmentFull(){
        if(maxNumberOfAttendes==0){
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendes){
            return false;
        }

        return true;
    }
}


