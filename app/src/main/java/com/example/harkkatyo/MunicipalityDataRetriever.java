package com.example.harkkatyo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;

public class MunicipalityDataRetriever {

    public void getData(String municipality) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode areas = null;

        try {
            areas = objectMapper.readTree(new URL("https://statfin.stat.fi/PxWeb/api/v1/en/StatFin/synt/statfin_synt_pxt_12dy.px"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        for (JsonNode node : areas.get("variables").get(1).get("values")) {
            values.add(node.asText());
        }
    }
}
