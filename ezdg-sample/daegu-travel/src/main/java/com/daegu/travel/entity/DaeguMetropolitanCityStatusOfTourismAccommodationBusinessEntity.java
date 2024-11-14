package com.daegu.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document(collection = "daegu_metropolitan_city_status_of_tourism_accommodation_business")
public class DaeguMetropolitanCityStatusOfTourismAccommodationBusinessEntity {

    @Id
    private String id;

    private int number;  // number 필드
    private String industryClassification;  // industryClassification
    private int guestMistakeStandard;  // guestMistakeStard
    private int guestMistakeCount;  // guestMistakeCount
    private String phoneNumber;  // phoneNumber
    private int guestMistakeOneRoom;  // guestMistakeOneRoom
    private int guestMistakeDeluxe;  // guestMistakeDeluxe
    private String location;  // location
    private String region;  // region
    private int guestMistakeSuite;  // guestMistakeSuite
    private String guestMistakeOther;  // guestMistakeOther
    private String hotelName;  // hotelName
}