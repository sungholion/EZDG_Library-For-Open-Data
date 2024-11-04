import MainDescription from "@/components/main/maindescription";
import DataDescription from "@/components/main/datadescription";
import Languages from "@/components/main/languages";
import Feature from "@/components/main/feature";

export default function Home() {
  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32">
      {/* 라이브러리 설명 */}
      <MainDescription />
      {/* 제공 데이터 종류들 */}
      <DataDescription />
      {/* 지원 언어 */}
      <Languages />
      {/* 특징 설명 */}
      <Feature
        title="손쉬운 데이터 활용"
        description="EZDG를 사용하면 공공데이터를 쉽게 활용할 수 있습니다. 복잡한 데이터 구조를 단순화하여 개발자가 필요한 정보에 빠르게 접근할 수 있습니다."
        image="/Feature1.png"
      />
      <Feature
        title="API 변환 자동화"
        description="파일 형태로 제공되는 공공데이터 RESTful API 형태로 자동 변환합니다. CSV를 다양한 형식의 데이터를 손쉽게 API 엔드포인트로 제공받아 즉시 사용할 수 있습니다."
        image="/Feature2.png"
      />
    </div>
  );
}