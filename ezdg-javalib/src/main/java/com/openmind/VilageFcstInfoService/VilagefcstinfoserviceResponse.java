package com.openmind.VilageFcstInfoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VilagefcstinfoserviceResponse {
private Response response;

@Getter
@Setter
public static class Response {
private Header header;
private Body body;
}

@Getter
@Setter
public static class Header {
            private Integer resultCode;
            private String resultMsg;
}

@Getter
@Setter
public static class Body {
private String dataType;
private Items items;
private String pageNo;
private String numOfRows;
private String totalCount;
}

@Getter
@Setter
public static class Items {
private List<Item> item;
    }

    @Getter
    @Setter
    public static class Item {
                private String baseDate;
                private String baseTime;
                private Integer nx;
                private Integer ny;
                private String category;
                private String obsrValue;

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
                sb.append("BaseDate: ").append(this.getBaseDate()).append("\n");
                sb.append("BaseTime: ").append(this.getBaseTime()).append("\n");
                sb.append("Nx: ").append(this.getNx()).append("\n");
                sb.append("Ny: ").append(this.getNy()).append("\n");
                sb.append("Category: ").append(this.getCategory()).append("\n");
                sb.append("ObsrValue: ").append(this.getObsrValue()).append("\n");
    sb.append("-----------------------\n");
    return sb.toString();
    }
    }

    @Override
    public String toString() {
    ObjectMapper mapper = new ObjectMapper();
    try {
    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (JsonProcessingException e) {
    e.printStackTrace();
    return super.toString();
    }
    }
    }