package com.ksign.access.restService.verify;


import com.ksign.access.restService.exception.ServiceException;

/**
 * Created by mkh on 2017-03-03.
 */
public interface Verify {
    public void doVerify() throws ServiceException;
}
