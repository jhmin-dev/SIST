---
hide_toc: true
---

# [SIST](https://github.com/jhmin-dev/SIST)

매일 수업 들으며 정리한 노트 모음

## Spring

### 1. 스프링 기초 [2월 23일](0223.md#1-스프링-기초)

#### 1-1 스프링 프레임워크란 [2월 23일](0223.md#1-1-스프링-프레임워크란)

- 소프트웨어 프레임워크

#### 1-2 스프링 프레임워크 특징 [2월 23일](0223.md#1-2-스프링-프레임워크-특징)

#### 1-3 스프링 프레임워크 설치 [2월 23일](0223.md#1-3-스프링-프레임워크-설치)

- Maven

### 2. 스프링 DI와 객체 관리 [2월 23일](0223.md#2-스프링-DI와-객체-관리) [2월 24일](0224.md#2-스프링-DI와-객체-관리)

#### 2-1 DI란 [2월 23일](0223.md#2-1-DI란)

#### 2-2 Bean 객체 설정 및 컨테이너를 통한 Bean 객체 사용 [2월 23일](0223.md#2-2-Bean-객체-설정-및-컨테이너를-통한-Bean-객체-사용)

#### 2-3 의존 관계 설정 [2월 23일](0223.md#2-3-의존-관계-설정) [2월 24일](0224.md#2-3-의존-관계-설정)

- 2-3-1 생성자 방식
- 2-3-2 프로퍼티 설정 방식
- 2-3-3 XML 네임스페이스를 이용한 프로퍼티 설정
- 2-3-6 콜렉션 타입 프로퍼티 설정
	+ List 타입과 배열
	+ Map 타입
	+ Set 타입
	+ Properties 타입
- 의존 관계 자동 설정

#### 2-5 어노테이션 기반 설정 [2월 24일](0224.md#2-5-어노테이션-기반-설정)

- `@Required`
- `@Resource`
- `@Autowired`
- `@Qualifier`

#### 2-6 어노테이션을 이용한 자동 스캔 [2월 24일](0224.md#2-6-어노테이션을-이용한-자동-스캔)

#### 2-7 자바 코드 기반 설정 [2월 24일](0224.md#2-7-자바-코드-기반-설정)

### 3. 스프링 AOP [2월 24일](0224.md#3-스프링-AOP) [2월 25일](0225.md#3-스프링-AOP)

#### 3-1 AOP 소개 [2월 24일](0224.md#3-1-AOP-소개)

- 3-1-1 AOP 용어
- 3-1-4 구현 가능한 Advice 종류

#### 3-2 XML 스키마를 이용한 AOP 설정 [2월 24일](0224.md#3-2-XML-스키마를-이용한-AOP-설정)

#### 3-3 `@Aspect` 어노테이션을 이용한 AOP [2월 25일](0225.md#3-3-Aspect-어노테이션을-이용한-AOP)

### 4. 스프링 MVC [2월 25일](0225.md#4-스프링-MVC) [3월 2일](0302.md#4-스프링-MVC) [3월 3일](0303.md#4-스프링-MVC)

#### 스프링 MVC의 구성 요소 [2월 25일](0225.md#스프링-MVC의-구성-요소)

#### 4-1 스프링 MVC 설정 [2월 25일](0225.md#4-1-스프링-MVC-설정) [3월 2일](0302.md#4-1-스프링-MVC-설정)

- 4-1-1 DispatcherServlet 설정 및 스프링 컨텍스트 설정
- 4-1-2 컨트롤러 구현 및 설정 추가
- 4-1-3 `servlet-context.xml` 설정
- 4-1-4 뷰 코드 구현
- `@RequestParam`
- `@GetMapping`, `@PostMapping`, `@ModelAttribute`
- `@CookieValue`

#### 4-4 메시지 처리 [3월 2일](0302.md#4-4-메시지-처리)

#### 4-3 Validator 인터페이스를 이용한 유효성 검증 [3월 2일](0302.md#4-3-Validator-인터페이스를-이용한-유효성-검증)

#### 4-2 주요 `<form>` 관련 커스텀 태그 [3월 2일](0302.md#4-2-주요-form-관련-커스텀-태그)

#### 4-5 파일 업로드 처리 [3월 2일](0302.md#4-5-파일-업로드-처리)

#### 로그인 처리 [3월 2일](0302.md#로그인-처리)

#### 국제화 처리 [3월 2일](0302.md#국제화-처리) [3월 3일](0303.md#국제화-처리)

#### 파일 다운로드 처리 [3월 3일](0303.md#파일-다운로드-처리)

#### 어노테이션을 이용한 유효성 검증 [3월 3일](0303.md#어노테이션을-이용한-유효성-검증)

#### JSON 문자열 처리 [3월 3일](0303.md#JSON-문자열-처리)

#### REST API [3월 3일](0303.md#REST-API)

### 5. JDBC [3월 3일](0303.md#5-JDBC) [3월 4일](0304.md#5-JDBC)

#### 5-1 커넥션 풀을 이용한 DataSource 설정 [3월 3일](0303.md#5-1-커넥션-풀을-이용한-DataSource)

#### 5-2 JdbcTemplate 클래스를 이용한 JDBC 프로그래밍 [3월 3일](0303.md#5-2-JdbcTemplate-클래스를-이용한-JDBC-프로그래밍) [3월 4일](0304.md#5-2-JdbcTemplate-클래스를-이용한-JDBC-프로그래밍)

- 5-2-1 JdbcTemplate bean 설정
- Controller
- View
- VO
- Validator
- 5-2-2 DAO 클래스에서의 JdbcTemplate 객체 사용
- Service
- Util

<!-- 
#### 5-3 NamedParameterJdbcTemplate 클래스를 이용한 JDBC 프로그래밍

- 5-3-1 NamedParameterJdbcTemplate bean 설정
- 5-3-2 DAO 클래스에서의 NamedParameterJdbcTemplate 객체 사용
 -->

### 6. 로깅 처리 [3월 4일](0304.md#6-로깅-처리)

<!-- 
#### 6-1 로깅 서비스 관련 중요 컴포넌트
 -->

#### 6-2 로그 레벨 [3월 4일](0304.md#6-2-로그-레벨)

### 7. 트랜잭션 [3월 4일](0304.md#7-트랜잭션)

<!-- 
#### 7-1 트랜잭션에서 지켜야 할 ACID 특성
 -->

#### 7-2 JDBC 기반 트랜잭션 관리자 설정 [3월 4일](0304.md#7-2-JDBC-기반-트랜잭션-관리자-설정)

- 7-2-1 bean 설정
<!-- - 7-2-2 TransactionTemplate을 이용한 트랜잭션 처리 -->

#### 7-3 선언적 트랜잭션 처리 [3월 4일](0304.md#7-3-선언적-트랜잭션-처리)

- 7-3-1 bean 설정

<!-- 
- 7-3-2 `<tx:method>` 태그의 속성
- 트랜잭션 전파
- 트랜잭션 격리 수준
- 트랜잭션 제한 시간
- 읽기 전용 트랜잭션
- 트랜잭션 롤백 예외
- 트랜잭션 커밋 예외
 -->

#### 7-4 어노테이션 기반 트랜잭션 처리 [3월 4일](0304.md#7-4-어노테이션-기반-트랜잭션-처리)

- bean 설정
- 7-4-1 메서드에 직접 명시

<!-- 
- 7-4-2 `@Transactional` 어노테이션의 주요 속성
- 7-4-3 `<tx:annotation-driven>` 태그의 속성
 -->

### 8. MyBatis [3월 4일](0304.md#8-MyBatis) [3월 7일](0307.md#8-MyBatis)

#### SQL Session [3월 4일](0304.md#SQL-Session) [3월 7일](0307.md#SQL-Session)

- 프로젝트 생성 및 설정
- VO
- MyBatis 설정
- DAO
- Service
- Controller
- View
- Util

#### Annotation [3월 7일](0307.md#Annotation)

- 프로젝트 생성 및 설정
- DAO
- Service

### 9. Apache Tiles [3월 7일](0307.md#9-Apache-Tiles)

#### Template [3월 7일](0307.md#Template)

#### Definition [3월 7일](0307.md#Definition)

#### Controller [3월 7일](0307.md#Controller)

#### Views [3월 7일](0307.md#Views)

### 10. `springPage` [3월 7일](0307.md#10-springPage) [3월 8일](0308.md#10-springPage) [3월 10일](0310.md#10-springPage) [3월 11일](0311.md#10-springPage) [3월 14일](0314.md#10-springPage) [3월 15일](0315.md#10-springPage)

#### 프로젝트 설정 [3월 7일](0307.md#프로젝트-설정) [3월 8일](0308.md#프로젝트-설정) [3월 10일](0310.md#프로젝트-설정) [3월 11일](0311.md#프로젝트-설정) [3월 14일](0314.md#프로젝트-설정)

- XML
- CSS
- Tiles
	+ Template
	+ Definition
- SQL
- Properties
- JavaScript
- CKEditor

#### Util [3월 8일](0308.md#Util) [3월 11일](0311.md#Util) [3월 14일](0314.md#Util)

#### Interceptor [3월 8일](0308.md#Interceptor) [3월 11일](0311.md#Interceptor) [3월 14일](0314.md#Interceptor)

#### View [3월 10일](0310.md#View) [3월 11일](0311.md#View)

#### Main [3월 7일](0307.md#Main) [3월 8일](0308.md#Main) [3월 14일](0314.md#Main)

- JSP
- Controller

#### Member [3월 8일](0308.md#Member) [3월 10일](0310.md#Member) [3월 11일](0311.md#Member)

- JSP
- Controller
- VO
- DAO
- Service

#### Board [3월 11일](0311.md#Board) [3월 14일](0314.md#Board) [3월 15일](0315.md#Board)

- VO
- DAO
- Service
- Controller
- JSP

## Spring Boot

- 프로젝트 생성 [3월 16일](0316.md#프로젝트-생성)
- 프로젝트 구조 [3월 16일](0316.md#프로젝트-구조)
- 프로젝트 설정 [3월 16일](0316.md#프로젝트-설정) [3월 17일](0317.md#프로젝트-설정)
- VO [3월 17일](0317.md#VO)
- DAO [3월 17일](0317.md#DAO)
- Service [3월 17일](0317.md#Service)
- Controller [3월 17일](0317.md#Controller)

## UML

- Class Diagram [3월 16일](0316.md#Class-Diagram)
- Usecase Diagram [3월 16일](0316.md#Usecase-Diagram)
- Sequence Diagram [3월 16일](0316.md#Sequence-Diagram)

## 소프트웨어 프로젝트 관리

1. 웹 사이트 개발 프로젝트 진행 절차 [3월 16일](0316.md#1-웹-사이트-개발-프로젝트-진행-절차)