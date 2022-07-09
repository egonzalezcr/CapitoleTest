package com.ergc.ecommerce.service;

import com.ergc.ecommerce.exception.InternalExceptions;
import com.ergc.ecommerce.model.Price;
import com.ergc.ecommerce.repository.PricesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @InjectMocks
    PricesService service;

    @Mock
    PricesRepository pricesRepository;


    @Test
    void getPriceTestOneOk() throws ParseException {
        Price priceMock = new Price();
        priceMock.setBrandId(1);
        priceMock.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 00:00:00"));
        priceMock.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59"));
        priceMock.setPriceList(1);
        priceMock.setProductId(35455);
        priceMock.setPriority(0);
        priceMock.setPrice(Float.valueOf("35.50"));
        priceMock.setCurr("EUR");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(pricesRepository.getPrice(applicationDate, productId, brandId)).thenReturn(priceMock);

        Price response = service.getPrice(applicationDate, productId, brandId);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.getPriceList());
        Assertions.assertEquals(productId, response.getProductId());
        Assertions.assertEquals(brandId, response.getBrandId());
        Assertions.assertEquals(0, response.getPriority());
        Assertions.assertEquals(Float.valueOf("35.50"), response.getPrice());
    }

    @Test
    void getPriceTestTwoOK() throws ParseException {
        Price priceMock = new Price();
        priceMock.setBrandId(1);
        priceMock.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 15:00:00"));
        priceMock.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 18:30:00"));
        priceMock.setPriceList(2);
        priceMock.setProductId(35455);
        priceMock.setPriority(1);
        priceMock.setPrice(Float.valueOf("25.45"));
        priceMock.setCurr("EUR");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 16:00:00", formatter);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(pricesRepository.getPrice(applicationDate, productId, brandId)).thenReturn(priceMock);

        Price response = service.getPrice(applicationDate, productId, brandId);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.getPriceList());
        Assertions.assertEquals(productId, response.getProductId());
        Assertions.assertEquals(brandId, response.getBrandId());
        Assertions.assertEquals(1, response.getPriority());
        Assertions.assertEquals(Float.valueOf("25.45"), response.getPrice());
    }

    @Test
    void getPriceTestThreeOK() throws ParseException {
        Price priceMock = new Price();
        priceMock.setBrandId(1);
        priceMock.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 00:00:00"));
        priceMock.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59"));
        priceMock.setPriceList(1);
        priceMock.setProductId(35455);
        priceMock.setPriority(0);
        priceMock.setPrice(Float.valueOf("35.50"));
        priceMock.setCurr("EUR");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 21:00:00", formatter);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(pricesRepository.getPrice(applicationDate, productId, brandId)).thenReturn(priceMock);

        Price response = service.getPrice(applicationDate, productId, brandId);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.getPriceList());
        Assertions.assertEquals(productId, response.getProductId());
        Assertions.assertEquals(brandId, response.getBrandId());
        Assertions.assertEquals(0, response.getPriority());
        Assertions.assertEquals(Float.valueOf("35.50"), response.getPrice());
    }

    @Test
    void getPriceTestFourOK() throws ParseException {
        Price priceMock = new Price();
        priceMock.setBrandId(1);
        priceMock.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 00:00:00"));
        priceMock.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 11:00:00"));
        priceMock.setPriceList(3);
        priceMock.setProductId(35455);
        priceMock.setPriority(1);
        priceMock.setPrice(Float.valueOf("30.05"));
        priceMock.setCurr("EUR");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(pricesRepository.getPrice(applicationDate, productId, brandId)).thenReturn(priceMock);

        Price response = service.getPrice(applicationDate, productId, brandId);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(3, response.getPriceList());
        Assertions.assertEquals(productId, response.getProductId());
        Assertions.assertEquals(brandId, response.getBrandId());
        Assertions.assertEquals(1, response.getPriority());
        Assertions.assertEquals(Float.valueOf("30.05"), response.getPrice());
    }

    @Test
    void getPriceTestFiveOK() throws ParseException {
        Price priceMock = new Price();
        priceMock.setBrandId(1);
        priceMock.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 16:00:00"));
        priceMock.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59"));
        priceMock.setPriceList(4);
        priceMock.setProductId(35455);
        priceMock.setPriority(1);
        priceMock.setPrice(Float.valueOf("38.95"));
        priceMock.setCurr("EUR");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        int productId = 35455;
        int brandId = 1;

        Mockito.when(pricesRepository.getPrice(applicationDate, productId, brandId)).thenReturn(priceMock);

        Price response = service.getPrice(applicationDate, productId, brandId);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(4, response.getPriceList());
        Assertions.assertEquals(productId, response.getProductId());
        Assertions.assertEquals(brandId, response.getBrandId());
        Assertions.assertEquals(1, response.getPriority());
        Assertions.assertEquals(Float.valueOf("38.95"), response.getPrice());
    }

    @Test
    void getPriceException() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        int productId = 55468;
        int brandId = 1;
        Mockito.when(pricesRepository.getPrice(applicationDate, productId, brandId)).thenThrow(new InternalExceptions("Price not found"));

        InternalExceptions exception = Assertions.assertThrows(InternalExceptions.class, () -> {
            service.getPrice(applicationDate, productId, brandId);
        }, "Price not found");

        Assertions.assertEquals("Price not found", exception.getMessage());
    }

}

