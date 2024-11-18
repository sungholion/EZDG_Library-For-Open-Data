package com.openmind.ezdg.TourStnInfoService1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TourStnVilageFcst {
    private static final String BASE_URL = "https://apis.data.go.kr/1360000/TourStnInfoService1/getTourStnVilageFcst1";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "ServiceKey",
        "pageNo",
        "numOfRows",
        "CURRENT_DATE",
        "HOUR",
        "COURSE_ID",
    };

    public TourStnVilageFcst (String serviceKey) {
        queryParams.append("?ServiceKey=").append(encode(serviceKey));
    }

    /**
    * 페이지번호
    */
    public TourStnVilageFcst pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(encode(pageNo));
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public TourStnVilageFcst numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(encode(numOfRows));
        return this;
    }

    /**
    * 요청자료형식(XML/JSON)
    */
    public TourStnVilageFcst dataType(String dataType) {
        queryParams.append("&dataType=").append(encode(dataType));
        return this;
    }

    /**
    * 2016-12-01 01시부터 조회
    */
    public TourStnVilageFcst CURRENT_DATE(String CURRENT_DATE) {
        queryParams.append("&CURRENT_DATE=").append(encode(CURRENT_DATE));
        return this;
    }

    /**
    * CURRENT_DATE부터 24시간 후까지의 자료 호출
    */
    public TourStnVilageFcst HOUR(String HOUR) {
        queryParams.append("&HOUR=").append(encode(HOUR));
        return this;
    }

    /**
    * 관광 코스ID
    */
    public TourStnVilageFcst COURSE_ID(String COURSE_ID) {
        queryParams.append("&COURSE_ID=").append(encode(COURSE_ID));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public TourStnVilageFcstResponse fetch() {
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

            return objectMapper.readValue(content.toString(), TourStnVilageFcstResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }


    private String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            throw new RuntimeException("Encoding error", e);
        }
    }
}
