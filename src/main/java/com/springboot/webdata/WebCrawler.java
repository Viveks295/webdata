package com.springboot.webdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebCrawler {
    static String customerJson = "{\n" +
            "  \"id\": 123,\n" +
            "  \"name\": \"Jovan Lee\",\n" +
            "  \"email\": \"jovan@example.com\",\n" +
            "  \"phone\": \"+49 176 14890478\",\n" +
            "  \"age\": 32,\n" +
            "  \"projects\": [\n" +
            "    \"Remote Job Board\",\n" +
            "    \"Data Migration\"\n" +
            "  ],\n" +
            "  \"address\": {\n" +
            "    \"street\": \"Yorckstr. 75\",\n" +
            "    \"city\": \"Berlin\",\n" +
            "    \"zipcode\": 10965,\n" +
            "    \"country\": \"Germany\"\n" +
            "  },\n" +
            "  \"paymentMethods\": [\n" +
            "    \"PayPal\",\n" +
            "    \"Stripe\"\n" +
            "  ],\n" +
            "  \"profileInfo\": {\n" +
            "    \"gender\": \"Male\",\n" +
            "    \"married\": \"Yes\",\n" +
            "    \"source\": \"LinkedIn\"\n" +
            "  }\n" +
            "}";
    public static void crawl() {
        final String url = "https://www.basketball-reference.com/allstar/NBA-allstar-career-stats.html";

        try {
            final Document document = Jsoup.connect(url).get();
            for (Element row:document.select("table.sortable.stats_table.now_sortable")) {
            //for (Element row:document.select("table.career-stats")) {
                System.out.println(row.outerHtml());
                /*if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {

                }*/
            }
        } catch (Exception ex) {

        }
    }
    public static String jsonMapper() {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to customer object
        try {
            Customer customer = objectMapper.readValue(customerJson, Customer.class);
            System.out.println(customer);
            //configure objectMapper for pretty input
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            //write customerObj object to customer2.json file
            return objectMapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
