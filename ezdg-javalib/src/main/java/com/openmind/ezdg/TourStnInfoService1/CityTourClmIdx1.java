package com.openmind.ezdg.TourStnInfoService1;

import com.openmind.ezdg.common.Encoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class CityTourClmIdx1 {
    private static final String BASE_URL = "https://apis.data.go.kr/1360000/TourStnInfoService1/getCityTourClmIdx1";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "ServiceKey",
        "pageNo",
        "numOfRows",
        "CURRENT_DATE",
        "DAY",
    };

    public CityTourClmIdx1 (String serviceKey) {
        queryParams.append("?ServiceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public CityTourClmIdx1 pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public CityTourClmIdx1 numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 요청자료형식(XML/JSON)
    */
    public CityTourClmIdx1 dataType(String dataType) {
        queryParams.append("&dataType=").append(Encoder.encode(dataType));
        return this;
    }

    /**
    * 2018-12-31 00시부터 조회
    */
    public CityTourClmIdx1 CURRENT_DATE(String CURRENT_DATE) {
        queryParams.append("&CURRENT_DATE=").append(Encoder.encode(CURRENT_DATE));
        return this;
    }

    /**
    * CURRENT_DATE부터 입력값까지의 자료 호출
    */
    public CityTourClmIdx1 DAY(String DAY) {
        queryParams.append("&DAY=").append(Encoder.encode(DAY));
        return this;
    }

    /**
    * 시군구 아이디
    */
    public CityTourClmIdx1 CITY_AREA_ID(String CITY_AREA_ID) {
        queryParams.append("&CITY_AREA_ID=").append(Encoder.encode(CITY_AREA_ID));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public CityTourClmIdx1Response fetch() {
        String queryParamStr = queryParams.toString();
        List<String> exceptedParams = new ArrayList<>();
        for (String requiredParam : requiredParams) {
            if(!queryParamStr.contains(requiredParam)) {
                exceptedParams.add(requiredParam);
            }
        }
        if(exceptedParams.size() > 0) {
            throw new RuntimeException(exceptedParams.toString() + " 파라미터는 필수입니다.");
        }
        try {
            URL url = new URL(BASE_URL + queryParams.toString());
            System.out.println("Generated URL: " + url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            return objectMapper.readValue(content.toString(), CityTourClmIdx1Response.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
