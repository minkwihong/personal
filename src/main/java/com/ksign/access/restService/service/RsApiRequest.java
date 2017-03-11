package com.ksign.access.restService.service;


import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.ServiceException;

/**
 * Created by mkh on 2017-03-02.
 */
public interface RsApiRequest {

    public void requestParamValidation() throws RequestParamException;

    public void validationService() throws ServiceException;

    public void postValidationService() throws ServiceException;

    public void executeService();

    public void destory();

    public String getApiResult();

}
