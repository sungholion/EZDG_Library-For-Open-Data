// TODO: 통신 연결 시 파라미터 변경 필요
import { DataItem } from "@/types/data";

export const DATA_ITEMS: DataItem[] = [
  {
    title: "한국 관광지 정보",
    badge: "Tourism API 1.0",
    description: "국내 관광지 정보 통합 제공 서비스",
    content:
      "전국의 관광지, 문화시설, 축제/행사, 여행코스, 숙박, 음식점 등 다양한 관광 콘텐츠 정보를 제공합니다. 지역별, 카테고리별 검색이 가능하며, 다국어 지원과 위치기반 검색 기능을 통해 맞춤형 여행 정보 서비스 개발에 활용할 수 있습니다.",
    image: {
      src: "/Tourism.jpg",
      alt: "한국관광공사 이미지",
    },
  },
  {
    title: "부동산 실거래가 정보",
    badge: "Realestate API 1.0",
    description: "전국 부동산 실거래가 정보 서비스",
    content:
      "아파트, 단독/다가구, 오피스텔 등 전국 부동산의 실제 거래 정보를 제공합니다. 지역별, 기간별 실거래 내역 조회가 가능하며, 면적, 층수, 거래 금액 등 상세 정보를 통해 정확한 부동산 시세 분석이 가능합니다.",
    image: {
      src: "/Realestate.jpg",
      alt: "국토교통부 이미지",
    },
  },
  {
    title: "날씨 정보",
    badge: "Weather API 1.0",
    description: "기상청 단기/중기 예보 서비스",
    content:
      "전국 단기예보(3일) 및 중기예보(10일)에 대한 상세 날씨 정보를 제공합니다. 기온, 강수량, 습도, 풍향/풍속 등의 기상 데이터를 실시간으로 확인할 수 있으며, 동네예보 API를 통해 상세한 지역별 날씨 정보를 활용할 수 있습니다.",
    image: {
      src: "/Weather.png",
      alt: "기상청 이미지",
    },
  },
];