# Winter is Leaving And SPRING is Coming
> 겨울은 떠나고, 봄이 오고 있다.

- 요우의 본격 Java Spring Boot 1주일 삽질기ㅅ(Git)
- 이젠 스프링을 한번쯤은 해봐야할 때

## Enviorment
  - Yowu
    - Java는 대학교 때 배운게 다임.
    - Spring은 토비의 스프링 앞쪽만 읽고 이클립스 STS 써서 Hello World 찍어본 적 있음.
    - 학부생 때 Servlet과 JSP로 웹 프로젝트를 해본 적은 있음
    - 그 외 자바 지식 전무
  - OS
    - Ubuntu 17.10 (on Windows VirtualBox VM)
    - Windows 10 x64
  - Java
    - java version "1.8.0_151"
    - Java(TM) SE Runtime Environment (build 1.8.0_151-b12)
    - Java HotSpot(TM) 64-Bit Server VM (build 25.151-b12, mixed mode)
  - IDE
    - IntelliJ IDEA Ultimate
  - Spring Boot: 1.5.9

## What I’ll build
  - RDBMS와 연결된 간단한 REST API Service

## Keywords
  - Spring
  - Gradle
  - junit
  - mocking
  - java 8
    - stream
    - lambda
  - JPA or MyBatis

## Logs
  - 착수 1일차 (2017. 12. 23, 토)
    - IntelliJ 를 설치함
    - http://blog.saltfactory.net/creating-springboot-project-in-intellij/ 를 참고하여 인텔리J에서 스프링 부트 데모 프로젝트를 생성해봄.
      - `openjdk-9-dbg:amd64` `openjdk-9-jdk-headless:amd64` `openjdk-9-jdk:amd64` `openjdk-9-jre-headless:amd64` `openjdk-9-jre:amd64` 를 설치하고 프로젝트를 생성하려 했지만 can not find JDK classes 에러가 발생.
      - openjdk를 8로 바꾸니 프로젝트 생성 성공
    - 프로젝트 빌드가 안된다. 아직은 뭐가 뭔지 잘 모르겠음. 고통
    - Gradle이 도는데 `Cause: the trustAnchors parameter must be non-empty` 에러가 발생. 일단은 패스
      - gradle 빌드 삽질을 계속 하다가 결국 이게 문제라는 것을 깨달음.
      - 해당 에러는 https (SSL) 접속시 인증서가 유효하지 않아서 발생하는 에러
      - `jre/lib/security/cacerts` 를 까보니 존재하기는 함
      - openjdk 사용시 유독 발생률이 높다고 함. 인증서 문제 해결은 너무 딥할 것 같으니 오라클 java로 재설치
      - 오라클 자바 쓰니 바로 해결됨...
      - 프로젝트 자바 버전 변경
        - File - Project Structure
      - 재부팅 하니 다시 같은 문제가 발생
        - `jre/lib/security/cacerts`가 다른 파일로 심볼릭 걸려있고, 기존 파일이 `cacerts.original`로 변경되어 있음. 우선 다시 원상복구 시키니 문제가 사라졌지만 원인은 좀더 찾아봐야 할듯
    - 인텔리J의 build를 실행시키는게 아니라 gradle의 build 명령어를 실행시켜야하는 것이 었음.
    - 빌드와 실행 성공
    - **1일차 성과: 6시간만에 환경 구축과 빌드, 실행 성공**
  - 착수 2일차 (2017. 12. 26, 화)
    - 24, 25일 크리스마스로 인한 휴무
    - 오늘은 웹 서비스 띄우기, DB 설계, 연동이 목표
    - Controller, Repository, MySQL JPA 등 해봄
    - 고민
      - Sequelize 처럼 class로 DB Schema를 관리할 수 있을 것 같은데, 어떻게 DDL을 잘 정의할 수 있을까..
      - 패키지 구조는? Contrller, Repository, Domain, Service로 나누면 될까?
    - **2일차 성과: 일단 DB를 붙이기는 했다**
  - 착수 3일차 (2017. 12. 27, 수)
    - 오늘은 도메인 구현, 컨트롤러와 레포지터리, 서비스 기능 구현이 목표
    - 그리고 어떻게 하면 쌔끈하게 만들 수 있을지.
    - 계속 우분투 VM에서 개발 진행하면 속터져 죽을 것 같아서, Host OS인 Windows로 이전.
    - 이슈
      - 오류: 기본 클래스 org.gradle.wrapper.GradleWrapperMain을(를) 찾거나 로드할 수 없습니다.
        - 윈도우로 개발환경 바꾸고 발생. gradle 배치파일을 받은 후 강제 `gradle wrap` 명령어 실행
        - http://androidhuman.com/537
      - 하.. 개발환경을 우분투에서 윈도우로 바꿨을 뿐인데..
      ```
      org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name '
      userController': Unsatisfied dependency expressed through field 'userRepository'; nested exceptio
      n is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'user
      Repository': Invocation of init method failed; nested exception is java.lang.IllegalArgumentExcep
      tion: Not a managed type: class com.timeline.domain.User
      ```
        - 원인은 Domain 클래스애 @Entity 어노테이션을 선언하지 않고 레포지터리 인터페이스에서 끌어다 쓸려고 했다.
      - RequestBody JSON이 잘 안받아짐
        - 그냥 내가 Node.js를 너무 오래써서 불편하다고 생각하는 것 같다.
        - 마치 온몸이 포박당한 기분이다.
        - Node.js 사용 때 처럼 Data를 자유롭게 RequestBody로 받아오고 핸들링 하고 싶은데, 쉽지 않다. 분명히 방법이 있을 거 같은데..
        - https://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/#json-to-java-object
      - JPA DDL 작동 시 Column Type DATETIME이 잘 안됨.
      - JPA 로 데이터 가져올 때 id가 아닌 다른 column 키로 가져오는데서 삽질
        - @Query 어노테이션을 사용한 Native Query를 시도했으나 잘 되지 않음
        - 돌고 돌아서 그냥 인터페이스에서 `Iterable<Post> findByUserId(Long userId);` 하면 되는걸 깨달음
      - 자잘한 이슈
        - windows java path 문제
    - **3일차 성과: 컨트롤러, 레포지터리 작성**
  - 착수 4~5일차 (2017. 12. 28~29, 목~금)
    - 4일차 목표: 기능적 요구사항 개발 완료. 대용량 트래픽 처리 방법 Research
    - 이슈
      - MySQL Timestamp CURRENT_TIMESTAMP
        - @Column 어노테이션 columnDefinition으로 CURRENT_TIMESTAMP 를 사용하긴 했지만 실제 데이터 생성은 데이터베이스 시점이므로 Entity 객체의 Date는 null 임.
        - 긴급 처방으로 DB에서 해당 객체를 다시 불러왔지만 그래도 createdAt이 갱신되지 않음. null임.. 왤까..
      - 설계에서 문제점 발견 싹 밀고 다시 시작
      - @Column 어노테이션의 name이 작동하지 않음
        - application.properties에 아래 구문 추가
        ```
        spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
        spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
        ```
        https://stackoverflow.com/questions/25283198/spring-boot-jpa-column-name-annotation-ignored
      - @RequestBody로 JSON을 받는 가장 간단한 방법
        - `@RequestBody Map<String, Object> body`
  - 착수 6일차 (2017. 12. 30, 토)
    - 6일차 목표: 마무리, REPORT.md 작성
    - 이슈
      - comment 객체 호출 수 도메인 순환 참조 발생 (Comment -> Post -> Comment -> Post)
      - Comment에서 Post 내부 내용을 알 필요는 없으니 @OneToOne 관계를 해제하고 postId만 가지게 함.


## Notes
- Java Annotations
  - http://jdm.kr/blog/216
  - 소스코드의 메타데이터
  - 컴파일이나 런타임 단계에서 해석
  - 클래스 , 필드 , 메서드 같은 프로그램 요소에 다양한 종류의 정보를 주는 방법
  - 학부생 때 했던 웹 프로젝트의 web.xml 노가다를 줄일 수 있는 것 같다.
  - @RestController
    - https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
  - @RequestMapping
    - https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html
    - Express.js의 Router와 비슷한 친구
  - @RequestParam
    - https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html
    - request params와 method의 params를 바인딩 해줌
  - @SpringBootApplication
    - 많은 설정을 추가해주는 편리한 친구
  - @Autowired
    - https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
    - 아직 잘 모르겠다. 자동으로 setter, getter 설정? Auto Data Binding?
- JPA
  - http://jdm.kr/blog/121
  - https://www.slideshare.net/ssusere4d67c/jpa-53004111
  - Example: https://spring.io/guides/gs/accessing-data-mysql/
  - DDL Auto: http://cpdev.tistory.com/25
  - Datetime Column 관련 : http://homoefficio.github.io/2016/11/19/Spring-Data-JPA-%EC%97%90%EC%84%9C-Java8-Date-Time-JSR-310-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0/

## 기타 참고자료
- Using @RequestMapping with Dynamic URIs: https://springframework.guru/spring-requestmapping-annotation/
- JPA Query Method : https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/
- Spring Boot REST API Example: http://websystique.com/spring-boot/spring-boot-rest-api-example/
- LINE 소셜 네트워크 서비스의 아키텍처: http://d2.naver.com/helloworld/809802
- 소셜 네트워크 서비스의 아키텍처에 대하여: http://d2.naver.com/helloworld/551588
- @UniqueConstraint annotation in Java: https://stackoverflow.com/questions/3126769/uniqueconstraint-annotation-in-java
- Setting a JPA timestamp column to be generated by the database?: https://stackoverflow.com/questions/811845/setting-a-jpa-timestamp-column-to-be-generated-by-the-database
- Why is my Spring @Autowired field null?:  https://stackoverflow.com/questions/19896870/why-is-my-spring-autowired-field-null
- [Spring - @Autowired, @Service, @Repository 구조]: https://m.blog.naver.com/PostView.nhn?blogId=scw0531&logNo=220988401816&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
