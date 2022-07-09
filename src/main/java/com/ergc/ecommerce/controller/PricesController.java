package com.ergc.ecommerce.controller;

import com.ergc.ecommerce.exception.InternalExceptions;
import com.ergc.ecommerce.model.Price;
import com.ergc.ecommerce.service.PricesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class PricesController {

    @Autowired
    private PricesService service;

    private static final Logger logger = LoggerFactory.getLogger(PricesController.class);

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity prices(@RequestParam
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate,
                                 @RequestParam int productId,
                                 @RequestParam int brandId) {

        try {

            Price response = service.getPrice(applicationDate, productId, brandId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);

        } catch (InternalExceptions nfe) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
