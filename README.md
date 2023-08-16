안녕하세요. 마켓잇 과제 테스트 제출드립니다!

과제의 요청에 따라 다음 4가지 api를 제공드립니다.

1. 주문 접수처리 post api

   : /orders  

2. 주문 완료처리 put api

   : /orders/complete/{orderId}

3. 단일 주문조회 get api

   : /orders/{orderId}

4. 주문 목록조회 post api

   : /orders/list/{userName}

5개 정도의 주문 테스트 케이스가 실행시 저장됩니다.  
테스트 케이스는 "resources/h2/data.sql" 파일에서 수정 가능합니다.  
해당 데이터는 <http://localhost:80/h2-console> 에서 조회, 수정 가능합니다.
id : marketit  
pass : 1234
로그인이 안되시면 JDBC URL : "jdbc:h2:mem:~/test" 이렇게 설정하신 후 접속 부탁드립니다!

body구조체 설명과 테스트는 스웨거를 통해 공유드립니다.  
<http://localhost:80/swagger-ui/index.html#>

우선 "/orders/list/all" 통해 전체 orders_id를 확인하신 후,
다른 api 테스트 해보시는걸 추천 드립니다 :)

<img width="1148" alt="스크린샷 2023-08-16 오후 12 58 30" src="https://github.com/gwon7210/marketit/assets/52650061/d3215260-e482-4b48-b052-7b5fd9573253">


잘 부탁드립니다. 감사드립니다!

ERD  
<img width="1148" alt="스크린샷 2023-08-16 오후 12 58 30" src="https://github.com/gwon7210/marketit/assets/52650061/7b84a7f6-d1fd-49ef-95a7-71838e808d0d">


java ver : 1.8  
spring boot ver: 2.7.15  
in-memory db : h2 
