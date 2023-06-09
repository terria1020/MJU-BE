# MJU-BE
명지대 데이터베이스 설계 Backend 프로젝트

*** Markdown MIGRATION FROM Notion: https://terria1020.notion.site/2022-2-ac4daa95aa9b489e866c0c5592253d74?pvs=4 *** 

## 프로젝트 정보

프로젝트 수행 자료

[데이터베이스설계_프로젝트.pdf](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dc4c34bf-8c5c-4443-b3ff-d490e863b430/%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%E1%84%87%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%E1%84%89%E1%85%A5%E1%86%AF%E1%84%80%E1%85%A8_%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3.pdf)

### 관련 공지

[관련 공지](https://www.notion.so/0a6bf7cb916d4e51a0e246a1a1981890?pvs=21)

### 프로젝트 일정

![0F2BCB3C-06B9-4035-B193-5BBF2E8E4A9A.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d487c00b-cd26-47ad-b5d5-5bfbae89b91e/0F2BCB3C-06B9-4035-B193-5BBF2E8E4A9A.jpeg)

## 프로젝트 분석 보고

### 요구사항정의서

공유 문서:

https://mju-my.sharepoint.com/:x:/g/personal/jaehan1346_mju_ac_kr/ESem0_1NoPpJoc1sTOImricBEC-0DGeaTK1FvK45eHEsIA?e=ZjKhDi

## 프로젝트 설계 보고

### 관련 엔티티 모음

관련 엔티티:

- 직원
    - 마케팅
    - 경영관리 (= 경영진)
    - 연구개발
    - 개발자
- 부서 정보
- 프로젝트
- 프로젝트평가
    - 고객 평가
    - PM 평가
    - 동료 평가

### 데이터베이스 설계서 작성

https://mju-my.sharepoint.com/:x:/g/personal/jaehan1346_mju_ac_kr/EXM25ICfzkFDr4qTNXV0ySIBfofBWqZh-WeQ8vxdC2wXew?e=J4bYGx

각자 맡은 데이터베이스 테이블 설계 작성 후, 파일 취합

### 11월 7일 설계보고 발표

11월 7일에 ER 다이어그램만 가지고 데모 시나리오가 있다는 가정 하에 발표를 한다

발표 시 우리가 그린 ER 다이어그램에서 어디가 어디의 ER에 접근을 하는 지 설명해야 한다

ER 다이어그램과 ER다이어그램에 기반하여 데모 시나리오를 발표

약 5분간 발표, 시나리오에 기반한 내용이 충실해야 하는것이 중요하다

## 프로젝트 구축 보고

https://mju-my.sharepoint.com/:x:/g/personal/jaehan1346_mju_ac_kr/EafXOsLDhSZMnRZcyagEJ10BwI9TOzWTUzH6rj5UYwUh1A?e=wWulKx

각자 맡은 CRUD 매트릭스 작성 후 파일 취합

## 최종보고서 제출 및 프로젝트 시연

### 임무 분담

[임무분담](https://www.notion.so/ca47102951e24f77b5794ae44c139bca?pvs=21)

### 최종 보고서

공유 문서:

https://mju-my.sharepoint.com/:w:/g/personal/jaehan1346_mju_ac_kr/EXKxsN4qd5hCtTPbz6Q1vfEBdd-NJQtJ8hm-ruedbfoUtw?e=ZU7HJP

### 아키텍처

![IMG_0097.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2d22e8ae-a763-4cb9-a909-6a1afe4c6490/IMG_0097.jpeg)

### Github Repository

https://github.com/MJU-DB-ENGINEERING/MJU-BE

## 프로젝트 총정리

### 협업 과정

1. 보고서 및 설계 시 회의를 거쳐 필요한 엔티티 식별, 데이터베이스 테이블 설계서 작성
2. Front-End 및 Back-End 개발 범위를 식별 후 협업 과정에서의 빠른 진행 및 더 적은 충돌 상황을 위해 개발 분야 별 레포지토리를 분리
3. 설계 된 데이터베이스를 기반으로 한 스프링 부트 프로젝트 생성, 하이버네이트 구현체인 JPA를 사용한 엔티티 매핑, API 작성 등 개발 진행
4. 기능 또는 작은 단위 별로 커밋 후 PR, 코드리뷰 후 코드 병합 진행

### 프로젝트 회고

설계 과목인 데이터베이스 설계 과목 팀 프로젝트를 진행하며 처음 느꼈던 것은 엔티티 간 관계 식별이 많이 어렵고, 정규화 하기 어려웠다는 것입니다. 요구사항에서 어떤 데이터가 필요한지, 그 데이터를 어떤 테이블로 옮겨야 하는지, 엔티티 간 관계는 어떻게 되는지 식별하는 게 정말 오래 걸렸습니다.

스프링 부트를 사용한 API 서버 작성에 대해서는 기본적인 CRUD 정도의 난이도이기 때문에 그렇게 코드를 작성하기 어렵다고 느끼지는 않았지만, 협업 과정에서 어떤 API가 필요한지, 의미 있는 이름으로 RESTful API URL을 구성하는 것이 얼마나 어려운지 알게 되었습니다.

백엔드에서 설계한 CRUD API가 막상 프론트엔드가 사용하기 어렵거나 프론트엔드에서 알 수 없는 데이터로 반환되어 새로운 API를 작성해 주어야 하는 등 첫 설계가 얼마나 중요한지, 팀원 간 커뮤니케이션이 생각보다 자주 이루어져야 하는지 깨닫게 되었습니다.

요구사항에 대한 누락사항은 다른 팀원이 버그로 식별 후 이슈화 후 내가 브랜치화 해서 Pull Request를 남기고 수정사항을 병합하였는데, 이슈화로 기록 해 둔 것이 무엇을 했는지 확인하기 쉽다는 점을 느껴 이슈화가 얼마나 중요한 것인지 알게 되었습니다. 버그 패치 브랜치는 직접 핵심 브랜치에 병합되었는데, Git-Flow 전략이 트러블 슈팅, 코드 병합에서의 더 적은 충돌을 위한 정책으로써 얼마나 중요한 것인지도 깨닫게 되었습니다.

커밋에 대해 커밋의 종류를 부여하고 커밋 내용을 더 자세히 썼다면 더욱 작업 내역을 확인하기 쉬울 것이라고 생각합니다. 내가 뭘 했는지 확인하고 커밋을 기반으로 다른 사람이 작성한 코드를 읽는 데 도움이 된다고 생각하니 커밋을 더 자세히, 더 자주, 더 명확히 작성하는 것이 협업에 있어서 중요한 일이라는 것을 깨닫고 추후에 팀 프로젝트를 진행할 때 적용시킬 수 있다면 좋았을 것이라고 생각합니다.
