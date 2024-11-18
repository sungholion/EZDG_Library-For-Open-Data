package com.openmind.ezdg.ArpltnStatsSvc;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class CtprvnMesureSidoLIstResponse {

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
        private String items;
        private String dataTime;
        private String sidoName;
        private String cityName;
        private String cityNameEng;
        private String so2Value;
        private String coValue;
        private String o3Value;
        private String no2Value;
        private String pm10Value;
        private String pm25Value;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Items: ").append(this.getItems()).append("\n");
            sb.append("DataTime: ").append(this.getDataTime()).append("\n");
            sb.append("SidoName: ").append(this.getSidoName()).append("\n");
            sb.append("CityName: ").append(this.getCityName()).append("\n");
            sb.append("CityNameEng: ").append(this.getCityNameEng()).append("\n");
            sb.append("So2Value: ").append(this.getSo2Value()).append("\n");
            sb.append("CoValue: ").append(this.getCoValue()).append("\n");
            sb.append("O3Value: ").append(this.getO3Value()).append("\n");
            sb.append("No2Value: ").append(this.getNo2Value()).append("\n");
            sb.append("Pm10Value: ").append(this.getPm10Value()).append("\n");
            sb.append("Pm25Value: ").append(this.getPm25Value()).append("\n");
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