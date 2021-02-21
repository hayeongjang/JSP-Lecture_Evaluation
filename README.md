# JSP-Lecture_Evaluation
## 프로젝트 핵심
1. 유튜브 강의를 통해 클론코드 형식으로 제작하였다.
2. 개발 셋팅, 코드 오류 해결 능력, 프론트/ 백엔드 영역을 배우기 위해 진행하였다.
3. 웹 서버 개발의 전반적인 과정을 알 수 있는 시간이었다!!
## 개발도구
1. 웹 브라우저 : Chrome
2. 개발환경 : Eclipse
3. 데이터베이스 : MySQL
4. 웹 컨테이너 : Tomcat
5. 프레임워크 : bootstrap
6. 라이브러리 : jQuery, Popper, Mail, Activation

## 개발과정
* 데이터베이스 구축
  * 데이터베이스 생성 ( LectureEvaluation)
  * 평가 테이블 ( Evaluation Table)
  * 회원 테이블 ( User Table)
  * 추천 테이블 ( Like Table)

* 데이터 모델링
   
   * DAO - 데이터베이스와 실질적으로 통신
   * DTO - 데이터베이스 테이블과 거의 1:1 대응되어 개별 데이터 원소를 보관하기 위해 사용
   

![데이터모델링](https://user-images.githubusercontent.com/77962884/108624692-c9ce1580-7489-11eb-9ce4-ef1662161a29.PNG)
  
* 회원가입 및 이메일 전송

![ut](https://user-images.githubusercontent.com/77962884/108625197-ea4b9f00-748c-11eb-9941-3157d625a9f9.PNG)

![111](https://user-images.githubusercontent.com/77962884/108625474-7f02cc80-748e-11eb-866d-01aa859e61c4.PNG)

* 로그인 및 로그아웃 구현


* 평가등록 및 신고 구현

![333](https://user-images.githubusercontent.com/77962884/108630860-643e5100-74aa-11eb-8d09-e166d55070ab.PNG)

* 추천 및 삭제 기능 구현

![444](https://user-images.githubusercontent.com/77962884/108630994-15dd8200-74ab-11eb-8c2a-f74cff22c588.PNG)

* XSS 시큐어 코딩
  * 게시글이 등록될 때 모든 꺾쇠가 치환되어서 자바스크립트 구문 삽입이 어려워진다.
  * .replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>") 추가
  
## 세부기능 설명

1. 로그인 하기

로그인을 해야 강의평가 진행 가능하다.

![로그인](https://user-images.githubusercontent.com/77962884/108631127-dbc0b000-74ab-11eb-9ad1-228e21cf3fa6.PNG)

2. 회원가입 하기

회원가입을 위한 정보 입력하기

![3](https://user-images.githubusercontent.com/77962884/108631163-ec712600-74ab-11eb-9ea2-ad63bc62090d.PNG)

데이터베이스에서 회원가입 된 정보를 확인할 수 있다.

![5](https://user-images.githubusercontent.com/77962884/108631167-ed09bc80-74ab-11eb-9f9d-a07887e89150.PNG)
![4](https://user-images.githubusercontent.com/77962884/108631165-ec712600-74ab-11eb-9150-532d359f6ec6.PNG)

입력한 메일에 들어가 인증이 완료되면 index 페이지로 이동한다.

![6](https://user-images.githubusercontent.com/77962884/108631169-ed09bc80-74ab-11eb-8f68-22c1dda4662b.PNG)
![7](https://user-images.githubusercontent.com/77962884/108631172-eda25300-74ab-11eb-8fa8-e6e6fc087138.PNG)

인증 메일은 재전송이 가능하다.

![8](https://user-images.githubusercontent.com/77962884/108631174-eda25300-74ab-11eb-88bf-7198c8f8c1fa.PNG)

데이터베이스에서 사용자 정보를 확인하면 'userEmailChecked' 속성 값이 1로 바뀐 것을 확인할 수 있다.

![9](https://user-images.githubusercontent.com/77962884/108631176-ee3ae980-74ab-11eb-8cd0-db8ce0138c86.PNG)

3. 평가등록

![10](https://user-images.githubusercontent.com/77962884/108631178-ee3ae980-74ab-11eb-969a-465710e7b367.PNG)

평가등록이 완료된 화면
 
![11](https://user-images.githubusercontent.com/77962884/108631140-e8450880-74ab-11eb-8c9e-51d087a1ff9c.PNG)

4. 신고하기

관리자에게 신고가 접수된 것을 확인할 수 있다.

![12](https://user-images.githubusercontent.com/77962884/108631144-e9763580-74ab-11eb-8f89-df1bfdd4d225.PNG)
![13](https://user-images.githubusercontent.com/77962884/108631147-e9763580-74ab-11eb-80eb-446a9b8c1190.PNG)

5. 추천 및 삭제하기

추천은 한 번만 가능하다.

![14](https://user-images.githubusercontent.com/77962884/108631149-ea0ecc00-74ab-11eb-8dcd-bfde67957ebc.PNG)
![15](https://user-images.githubusercontent.com/77962884/108631152-eaa76280-74ab-11eb-9f33-f7864af1b849.PNG)

자신이 등록한 글만 삭제 가능하다.

![16](https://user-images.githubusercontent.com/77962884/108631154-eaa76280-74ab-11eb-83ee-053cf525b61d.PNG)
![17](https://user-images.githubusercontent.com/77962884/108631156-eb3ff900-74ab-11eb-965b-5b39a55077e8.PNG)

6. 평가 검색 및 최신/추천순 출력

특정 키워드 입력 후 검색하면 관련 글만 출력되며 최신/추천순으로 출력 가능하다.

![18](https://user-images.githubusercontent.com/77962884/108631157-eb3ff900-74ab-11eb-80bf-9be37bce00a1.png)

## 마치며

![footer](https://user-images.githubusercontent.com/77962884/108631889-8be3e800-74af-11eb-921f-a9846e75a8b6.PNG)






