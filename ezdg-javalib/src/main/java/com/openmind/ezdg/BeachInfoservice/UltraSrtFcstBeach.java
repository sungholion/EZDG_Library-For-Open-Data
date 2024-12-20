package com.openmind.ezdg.BeachInfoservice;

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

public class UltraSrtFcstBeach {
    private static final String BASE_URL = "https://apis.data.go.kr/1360000/BeachInfoservice/getUltraSrtFcstBeach";
    private StringBuilder queryParams = new StringBuilder();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String[] requiredParams = {
        "serviceKey",
        "base_date",
        "base_time",
        "beach_num",
    };

    public UltraSrtFcstBeach (String serviceKey) {
        queryParams.append("?serviceKey=").append(Encoder.encode(serviceKey));
    }

    /**
    * 한 페이지 결과 수
    */
    public UltraSrtFcstBeach numOfRows(String numOfRows) {
        queryParams.append("&numOfRows=").append(Encoder.encode(numOfRows));
        return this;
    }

    /**
    * 페이지 번호
    */
    public UltraSrtFcstBeach pageNo(String pageNo) {
        queryParams.append("&pageNo=").append(Encoder.encode(pageNo));
        return this;
    }

    /**
    * 응답자료형식
    */
    public UltraSrtFcstBeach dataType(String dataType) {
        queryParams.append("&dataType=").append(Encoder.encode(dataType));
        return this;
    }

    /**
    * 발표일자
    */
    public UltraSrtFcstBeach base_date(String base_date) {
        queryParams.append("&base_date=").append(Encoder.encode(base_date));
        return this;
    }

    /**
    * 발표시각
    */
    public UltraSrtFcstBeach base_time(String base_time) {
        queryParams.append("&base_time=").append(Encoder.encode(base_time));
        return this;
    }

    /**
    * 해변코드
    */
    public UltraSrtFcstBeach beach_num(String beach_num) {
        queryParams.append("&beach_num=").append(Encoder.encode(beach_num));
        return this;
    }

    /**
    * API 호출 및 응답 파싱
    */
    public UltraSrtFcstBeachResponse fetch() {
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

            return objectMapper.readValue(content.toString(), UltraSrtFcstBeachResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청 또는 JSON 파싱 실패", e);
        }
    }
}
