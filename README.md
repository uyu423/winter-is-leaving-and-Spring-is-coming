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
    - 아직 잘 모르겠다. 자동으로 setter, getter 설정?
- JPA
  - http://jdm.kr/blog/121
  - https://www.slideshare.net/ssusere4d67c/jpa-53004111
  - Example: https://spring.io/guides/gs/accessing-data-mysql/
  - DDL Auto: http://cpdev.tistory.com/25
  - Datetime Column 관련 : http://homoefficio.github.io/2016/11/19/Spring-Data-JPA-%EC%97%90%EC%84%9C-Java8-Date-Time-JSR-310-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0/

## 기타 참고자료
