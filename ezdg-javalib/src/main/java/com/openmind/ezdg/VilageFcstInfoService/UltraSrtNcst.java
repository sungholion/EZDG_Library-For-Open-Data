package com.openmind.ezdg.VilageFcstInfoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UltraSrtNcst {
    private static final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "pageNo",
        "numOfRows",
        "base_date",
        "base_time",
        "nx",
        "ny",
    };

    public UltraSrtNcst (String serviceKey) {
        queryParams.append("ServiceKey=").append(serviceKey);
    }

    /**
    * 페이지번호
    */
    public UltraSrtNcst pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(pageNo);
        return this;
    }

    /**
    * 한 페이지 결과 수
    */
    public UltraSrtNcst numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(numOfRows);
        return this;
    }

    /**
    * 요청자료형식(XML/JSON) Default: XML
    */
    public UltraSrtNcst dataType(String dataType) {
        queryParams.append("&dataType=").append(dataType);
        return this;
    }

    /**
    * ‘21년 6월 28일 발표
    */
    public UltraSrtNcst base_date(String base_date) {
        queryParams.append("&base_date=").append(base_date);
        return this;
    }

    /**
    * 06시 발표(정시단위)
    */
    public UltraSrtNcst base_time(String base_time) {
        queryParams.append("&base_time=").append(base_time);
        return this;
    }

    /**
    * 예보지점의 X 좌표값
    */
    public UltraSrtNcst nx(String nx) {
        queryParams.append("&nx=").append(nx);
        return this;
    }

    /**
    * 예보지점의 Y 좌표값
    */
    public UltraSrtNcst ny(String ny) {
        queryParams.append("&ny=").append(ny);
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public UltraSrtNcstResponse fetch() {
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

            return objectMapper.readValue(content.toString(), UltraSrtNcstResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
