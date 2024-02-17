# 🕵️ Mafia in SNS Game (MSG)

<img src="./src/msg.png" width="100%" height="70%">

<p align="center">
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vuedotjs&logoColor=white">
  <img src="https://img.shields.io/badge/npm-CB3837?style=for-the-badge&logo=npm&logoColor=white">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/java-437291?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white"> 
  <img src="https://img.shields.io/badge/mongodb-47A248?style=for-the-badge&logo=mongodb&logoColor=white">
  <img src="https://img.shields.io/badge/amazons3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">
  <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">
  <img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white">
  <img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
  <img src="https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=white">
  <img src="https://img.shields.io/badge/openai-412991?style=for-the-badge&logo=openai&logoColor=white">
</p>

<br/><br/>

## 📆 기간

### 2024. 12. 28. ~ 2024. 02 .16.

<br/><br/>

## 🔎 코드

### [1. Frontend](https://lab.ssafy.com/s10-webmobile2-sub2/S10P12D109/-/blob/fe/dev/README.md?ref_type=heads)

### [2. Backend](https://lab.ssafy.com/s10-webmobile2-sub2/S10P12D109/-/tree/be/dev?ref_type=heads)

<br/><br/>

## 📌 배경

오늘날 대부분 사람들이 SNS를 즐기고 있습니다.  
그러나 최근 지나친 자기과시와 인플루언서 및 기업들의 홍보로 도배되는 경우가 많습니다.  
기존 SNS에 거부감이 있는 사람들이 편안하고 재밌게 소통하길 바라며 Mafia in SNS Group (이하 MSG)를 기획했습니다.

<br/><br/>

## 📌 개요

MSG는 사진을 기반으로 일상을 공유하는 일반적인 SNS를 그대로 즐길 수 있습니다.  
여기에 더불어 리얼 타임으로 진행되는 마피아 게임에도 참여가 가능 합니다.

게임에 참여하면 매일 주어지는 미션으로 일상 사진을 업로드하면서 자연스럽게 서로의 일상을 공유하게 됩니다.  
같은 시간에 모여야 된다는 부담감을 줄이고, 각자의 여유 시간을 활용하여 게임에 참여할 수 있습니다.  
게임이 진행되면서 서로의 사진을 보고 추측하고 소통함으로써 친밀한 관계가 형성 됩니다.  
일상의 지루함을 해소함과 더불어 새로운 관계를 자연스레 형성한다는 점에서 기존 SNS에 아쉬움을 느꼈던 사람들에게 신선함을 가져다줄 수 있습니다.

<br/><br/>

## 🖇 아키텍처

<img src="./src/architecture.png" width="100%" height="70%">

<br/><br/>

## 💡 주요 기능

### 1. SNS

### 1.1. 피드

- 피드를 작성하고 수정하거나 삭제할 수 있습니다.
- 피드에 댓글을 작성할 수 있습니다.
- 댓글에 답글을 작성할 수 있습니다.
- 피드와 댓글, 답글에 대해 '좋아요'를 누를 수 있습니다.
- 부적절한 피드를 신고할 수 있습니다.

### 1.2. 채팅

- 유저 간 실시간 채팅이 가능합니다.
- 기존 대화 내역을 불러올 수 있습니다.

### 1.3. 프로필

- 프로필 사진과 닉네임을 설정 및 변경할 수 있습니다.
- 자기소개를 작성할 수 있습니다.
- 마이페이지에서 게임 승률 그래프를 확인할 수 있습니다.

### 1.4. 팔로우

- 유저 간 팔로우가 가능합니다.
- 피드 조회 시 팔로우 목록에 기반하여 우선 순위를 정합니다.

### 1.5 알림

- 게임 시작 시 웹소켓을 통해 새로운 알림을 표시합니다.
- 유저 접속 및 종료 시 웹소켓을 통해 새로운 알림을 표시합니다.
- 다른 유저가 내 게시물에 댓글을 달거나 '좋아요'를 누르면 웹소켓을 통해 알림이 옵니다.
- 백그라운드 환경에서 다른 유저가 내 게시물에 댓글을 달거나 '좋아요'를 누르면 푸시 알림이 옵니다.

<br/>

### 2. 마피아 게임

### | 개요

- MSG 게임은 마피아와 시민 두 진영으로 나뉘어 리얼 타임으로 진행됩니다.
- 모든 플레이어는 주어진 미션에 맞는 피드를 업로드하고, 이를 바탕으로 마피아를 유추합니다.
- 마피아와 시민은 유사하지만 서로 다른 미션을 받습니다. 예) 시민 미션: 음료 사진, 마피아 미션: 커피 사진.
- 마피아는 일반 채팅 외에도 마피아들만의 채팅을 이용할 수 있습니다.

### | 인원

- 한 게임당 마피아 2명과 시민 5명, 총 7명의 플레이어가 필요합니다.

### | 참여

- 랜덤으로 게임을 입장하여 다른 유저들과 익명으로 게임을 즐길 수 있습니다.
- 친구 또는 다른 유저들을 초대하여 게임을 즐길 수 있습니다.
- 생성된 방의 초대 코드를 복사하여 공유할 수 있습니다.

### | 시작

- 오후 1시 이전 7명의 플레이어가 모이면 곧바로 게임이 시작됩니다.
- 오후 1시 이후 7명의 플레이어가 모이면 다음날 오전 8시 게임이 시작됩니다.

### | 진행

#### ☀️ 낮 (08시 ~ 20시)

- 새롭게 배정된 미션을 수행합니다.
- 미션을 수행해야 마피아 지목 시민 투표가 가능합니다.
- 미션을 수행하지 않은 유저는 실종 처리되고 게임에 패배한 것으로 간주됩니다.

#### 🌙 밤 (20시 ~ 08시)

- 낮에 진행된 마피아 지목 시민 투표에서 가장 많은 표를 받은 사람이 처형됩니다.
- 마피아들의 투표가 가능합니다.

### | 종료

- 마피아가 모두 처형되면 시민의 승리로 게임이 종료됩니다.
- 시민의 수가 마피아의 수보다 같거나 작으면 마피아의 승리로 게임이 종료됩니다.
- 게임 종료 시 플레이어 정보를 확인할 수 있습니다.
- 게임 종료 시 플레이어 신고가 가능합니다.

### | 직업

#### 😈 마피아

- **마피아**: 밤에 다른 마피아와 함께 시민 1명을 지목하여 죽일 수 있습니다.
- **훼방꾼**: 능력을 사용하면 다음날 모든 시민에게 마피아 미션을 줍니다 (1회 한정).
- **스파이**: 밤에 시민 1명을 지목하여 다음날 지목한 시민의 직업을 알아낼 수 있습니다 (1회 한정).
- **건달**: 밤에 시민 1명을 지목하여 다음날 지목한 시민의 투표권을 압수합니다 (1회 한정).

#### 🙂 시민

- **경찰**: 밤에 마피아로 생각되는 사람을 지목하면 마피아 여부를 확인할 수 있습니다.
- **의사**: 마피아가 지목할 것 같은 시민에게 능력을 사용하여 해당 시민을 살릴 수 있습니다.
- **정치인**: 시민 투표에서 가장 많은 표를 받더라도 살아남을 수 있습니다 (1회 한정).
- **군인**: 마피아 투표에서 지목되더라도 살아남을 수 있습니다 (1회 한정).
- **판사**: 시민 투표 결과와 관계없이 판사가 지목한 사람이 처형됩니다 (1회 한정).
- **미치광이**: 본인의 역할이 경찰인 줄 알고 다른 플레이어를 지목하지만 매번 랜덤한 결과를 제공받습니다.
- **기자**: 밤에 지목한 플레이어의 직업을 알아내 전체에게 공개할 수 있습니다 (1회 한정).
- **불침번**: 밤에 마피아들만의 채팅을 엿볼 수 있습니다.
- **자경단**: 마피아 투표에서 지목되어 죽으면 마피아 중 1명의 정체를 강제로 공개합니다.

<br/><br/>

## 💡 주요 기술

### 1. Frontend

- **Node.js**: v20.10.0
- **Vue.js**: v3.2.13
- **Axios**
- **WebSocket**
- **Visual Studio Code**

### 2. Backend

- **Java**: v17.0.9
- **Spring Boot**: v3.2.1
- **Gradle**: v8.5
- **JWT**
- **WebSocket**
- **STOMP**
- **IntelliJ**

### 3. Storage

- **Redis**: v5.0.7
- **MongoDB**: v7.0.5
- **MariaDB**: v10.3.39
- **AWS S3**

### 4. Infrastructure

- **Docker**: v25.0.1
- **Docker Compose**: v2.24.3
- **Docker Distribution**: v2.8.3
- **NGINX**: v1.25.3
- **Jenkins**: v2.444

### 5. External Service

- **Firebase Cloud Messaging**
- **OpenAI**

<br/><br/>

## 💻 협업 도구

- **GitLab**: 코드 버전 관리 및 이슈 추적, Merge Request를 통한 코드리뷰 지원
- **Notion**: 프로젝트 문서화, 회의록 저장, 작업 순서 정리 및 컨벤션 관리
- **JIRA**: 스프린트 계획, 업무 할당 및 진행 상황 추적, 번다운 차트로 프로젝트 진도 확인
- **Figma**: UI 디자인 목업, 와이어프레임 제작, 디자인 작업 공유
- **Mattermost**: 팀 커뮤니케이션, 현재 작업 상황 공유, 기능 수정 공지
- **Draw.io**: 다이어그램 생성, 프로세스 플로우 및 아키텍처 설계
- **ERDCloud**: 데이터베이스 스키마 디자인, ERD 작성 및 공유

<br/><br/>

## 👪 팀원 소개

### 1. Frontend

<table>
  <tr>
    <td style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <div style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <a href="https://github.com/hyunjiihye"><img src="src/hyunjiihye.jpg" height="150px" alt="현지혜"></a>
      <br/>
      <b><a href="https://github.com/hyunjiihye" style="text-align:center;">현지혜</a></b>
      <br/>
      </div>
      <br/>
      <div style="text-align:center;">기획</div>
      <div style="text-align:center;">UI/UX 설계</div>
      <div style="text-align:center;">화면 구현</div>
    </td>
    <td style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <div style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <a href="https://github.com/suehwanBoo"><img src="src/suehwanBoo.jpg" height="150px" alt="부수환"></a>
      <br/>
      <b><a href="https://github.com/suehwanBoo" style="text-align:center;">부수환</a></b>
      <br/>
      </div>
      <br/>
      <div style="text-align:center;">상태 관리</div>
      <div style="text-align:center;">UI/UX 설계</div>
      <div style="text-align:center;">화면 구현</div>
    </td>
  </tr>
</table>

### 2. Backend

<table>
  <tr>
    <td style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <div style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <a href="https://github.com/LeeChangon"><img src="src/LeeChangon.jpg" height="150px" alt="이창곤"></a>
      <br/>
      <b><a href="https://github.com/LeeChangon" style="text-align:center;">이창곤</a></b>
      <br/>
      </div>
      <br/>
      <div style="text-align:center;">OpenAI API 구현</div>
      <div style="text-align:center;">AWS S3 API 구현</div>
      <div style="text-align:center;">게임 API 구현</div>
    </td>
    <td style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <div style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <a href="https://github.com/yi219"><img src="src/yi219.jpg" height="150px" alt="금예인"></a>
      <br/>
      <b><a href="https://github.com/yi219" style="text-align:center;">금예인</a></b>
      <br/>
      </div>
      <br/>
      <div style="text-align:center;">Scheduler API 구현</div>
      <div style="text-align:center;">STOMP 기반 채팅 구현</div>
      <div style="text-align:center;">FCM 기반 알림 구현</div>
    </td>
    <td style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <div style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <a href="https://github.com/Limkyuhwan"><img src="src/Limkyuhwan.jpg" height="150px" alt="임규환"></a>
      <br/>
      <b><a href="https://github.com/Limkyuhwan" style="text-align:center;">임규환</a></b>
      <br/>
      </div>
      <br/>
      <div style="text-align:center;">기획</div>
      <div style="text-align:center;">유저 API 구현</div>
      <div style="text-align:center;">피드 API 구현</div>
    </td>
    <td style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <div style="border: 1px solid #ccc; padding: 10px; text-align: center;">
      <a href="https://github.com/ubermensch100326"><img src="src/ubermensch100326.jpg" height="150px" alt="최호조"></a>
      <br/>
      <b><a href="https://github.com/ubermensch100326" style="text-align:center;">최호조</a></b>
      <br/>
      </div>
      <br/>
      <div style="text-align:center;">아키텍처 설계</div>
      <div style="text-align:center;">CI/CD</div>
      <div style="text-align:center;">JWT 인증/인가 구현</div>
    </td>

  </tr>
</table>

<br/><br/>

## 📃 프로젝트 산출물

### 1. 기능 명세서

<img src="./src/api_1.png" width="50%" height="70%">
<img src="./src/api_2.png" width="50%" height="70%">
<img src="./src/api_3.png" width="50%" height="70%">
<img src="./src/api_4.png" width="50%" height="70%">
<img src="./src/api_5.png" width="50%" height="70%">

### 2. 와이어 프레임

<img src="./src/MSG_WireFrame_img.JPG" width="50%" height="70%">

### 3. ERD

<img src="./src/MSG_ERD.png" width="50%" height="70%">

<!-- ### 4. 시퀀스 다이어그램 -->

<!-- ### 5. 클래스 다이어그램 -->

<!-- ## 📃 프로젝트 구조 -->

<br/><br/>

<!-- ## 📃 프로젝트 결과물 -->

## 🌏 서비스 화면

### 1. 전체 사이트

라이트 모드와 다크 모드를 적용하여 밤, 낮이 있는 게임의 특성을 살렸습니다.
반응형 웹을 구현하여 모바일과 pc 브라우저 모두 즐길 수 있게 만들었습니다.

<br/>

### 2. 메인 페이지

<div style="display: flex;">
    <img src="./src/MainPage_light.png" width="50%" height="70%">
    <img src="./src/MainPage_dark.png" width="50%" height="70%">
</div>

<br/>

- 로그인 화면으로 이동할 수 있습니다.
  피드를 볼 수 있는 화면입니다.
- 좋아요 수를 보여줍니다.
- 내가 팔로우한 사람들의 피드가 무한 스크롤로 구현되어 계속 볼 수 있습니다.

<br/>

### 3. 피드 상세 페이지

<div style="display: flex;">
    <img src="./src/FeedDetailPage_light.PNG" width="50%" height="70%">
    <img src="./src/FeedDetailPage_dark.PNG" width="50%" height="70%">
</div>

<br/>

- 댓글을 확인하고 작성할 수 있습니다.
- 대댓글 또한 작성 가능합니다.

<br/>

### 4. 게임 페이지

<div style="display: flex;">
    <img src="./src/GamePage_light.png" width="50%" height="70%">
    <img src="./src/GamePage_dark.png" width="50%" height="70%">
</div>

<br/>

- 랜덤 게임이나 초대코드를 이용한 게임 생성이 가능합니다.
- 게임 설명 페이지로 이동할 수 있습니다.
- 내가 참여 중인 게임 방 목록을 확인할 수 있습니다.

<br/>

### 5. 게임 상세 페이지

<div style="display: flex;">
    <img src="./src/RoomDetail_light.png" width="50%" height="70%">
    <img src="./src/RoomDetail_dark.png" width="50%" height="70%">
</div>

<br/>

- 게임을 진행하는 페이지입니다.
- 화면 왼쪽에 피드, 오른쪽에 채팅창이 있습니다.
- 오른쪽 화면에선 투표, 설명, 능력 사용 화면이 있습니다.

<br/>

### 6. 메시지 페이지

<div style="display: flex;">
    <img src="./src/MessagePage_light.png" width="50%" height="70%">
    <img src="./src/MessagePage_dark.png" width="50%" height="70%">
</div>

<br/>

- 개인간 메시지를 주고 받을 수 있습니다.
- 버튼으로 간단히 상대를 추가할 수 있습니다.

<br/>

### 7. 마이 페이지

<div style="display: flex;">
    <img src="./src/MyPage_light.png" width="50%" height="70%">
    <img src="./src/MyPage_dark.png" width="50%" height="70%">
</div>

<br/>

- 나의 팔로워, 팔로잉 수와 목록을 확인할 수 있습니다.
- 내가 올린 피드들을 볼 수 있습니다.
- 내가 했던 '랜덤'게임의 전적 통계를 확인할 수 있습니다.
