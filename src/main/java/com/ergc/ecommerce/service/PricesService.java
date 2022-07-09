package com.ergc.ecommerce.service;

import com.ergc.ecommerce.exception.InternalExceptions;
import com.ergc.ecommerce.model.Price;
import com.ergc.ecommerce.repository.PricesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PricesService {

    @Autowired
    PricesRepository pricesRepository;

    private static final Logger logger = LoggerFactory.getLogger(PricesService.class);
    public Price getPrice(LocalDateTime applicationDate, int productId, int brandId) {
        logger.debug("getPrice method reached");
        return pricesRepository.getPrice(applicationDate, productId, brandId);
    }
}
