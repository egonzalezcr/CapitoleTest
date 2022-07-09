package com.ergc.ecommerce.repository;

import com.ergc.ecommerce.exception.InternalExceptions;
import com.ergc.ecommerce.model.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PricesRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final Logger logger = LoggerFactory.getLogger(PricesRepository.class);

    public Price getPrice(LocalDateTime applicationDate, int productId, int brandId) {

        String query = "SELECT * FROM PRICES WHERE START_DATE <= :applicationDate " +
                "AND END_DATE >= :applicationDate " +
                "AND PRODUCT_ID = :productId " +
                "AND BRAND_ID = :brandId " +
                "ORDER BY PRIORITY DESC";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        MapSqlParameterSource sqlParameters = new MapSqlParameterSource();
        sqlParameters.addValue("applicationDate", applicationDate.format(formatter));
        sqlParameters.addValue("productId", productId);
        sqlParameters.addValue("brandId", brandId);

        List<Price> prices = template.query(query, sqlParameters, rs -> {
            final List<Price> resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(new Price(rs.getInt("ID"),
                        rs.getInt("BRAND_ID"), rs.getDate("START_DATE"), rs.getDate("END_DATE"),
                        rs.getInt("PRICE_LIST"), rs.getInt("PRODUCT_ID"), rs.getInt("PRIORITY"),
                        rs.getFloat("PRICE"), rs.getString("CURR")));
            }
            return resultList;
        });

        if (prices == null || prices.isEmpty()) {
            logger.debug("Price not found");
            throw new InternalExceptions("Price not found");
        }

        return prices.get(0);
    }
}
