package org.example;


import junit.framework.Assert;

import org.example.ByteCode.Moim;
import org.testng.annotations.Test;


public class MoimTest {
    @Test
    public void isFull(){
        Moim moim = new Moim();
        moim.maxNumberOfAttendes = 100;
        moim.numberOfEnrollment = 10;
        Assert.assertFalse(moim.isEnrollmentFull());
    }
}
