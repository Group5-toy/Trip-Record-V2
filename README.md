# 💡 Topic

- **여행 여정을 기록과 관리하는 SNS 서비스**
- 회원이 서비스를 로그인하여 자신의 정보 관리 및 자신의 여행에 대한 정보와 여정들에 대한 정보를 작성할 수 있으며 다른 회원이 작성한 여행글을 조회 및 댓글,좋아요를 달 수 있는 서비스




# 📝 Summary

여행에 대한 정보를 나누는 SNS들처럼 회원으로 가입을 하게 되면 다른 사람들이 작성한 여행글을 볼 수 있으며 여행글에 대해 댓글과 좋아요 표시를 남길 수 있다.
또한, 자신이 다녀온 여행에 대한 정보와 여정들에 대한 정보를 작성할  수 있으며 회원 자신만의 정보를 조회,수정을 할 수 있도록 하는 SNS 서비스이다.




# ⭐️ Key Function

- 회원
    - 사람들이 자신의 아이디를 만들어 로그인할 수 있다.
    - 로그인 시간에 만료 시간을 두어 일정 시간이 지나면 서비스 사용을 위해 재로그인을 해야 한다.
    - 아이디와,비밀번호를 통하여 인증을 진행하며 일치하지 않을 경우 서비스 사용을 할 수 없다.
    - 자신의 정보를 조회 및 수정을 할 수 있다.
- 여행
    - 여행글을 등록할 수 있다.
    - 여행글들을 검색할 수 있다.
    - 여행을 조회하면서 여정들을 조회할 수 있다.
    - 여행글을 일부분 또는 전부를 수정할 수 있다.
    - 다른 사람의 여행글에 댓글 및 좋아요를 남길 수 있다.
- 여정
    - 여행에 여정을 등록할 수 있다.
    - 여행의 여정들을 조회할 수 있다.
    - 여정의 정보를 수정할 수 있다.   



# 🛠 Tech Stack

`JAVA`,`Spring Boot`,`Spring Security`,`Docker`,`MySQL`, `Github`,`Git`,`Slack`



# ⚙️ Architecture

`Domain Design Architecture`




# 🧑🏻‍💻 Team

- 백엔드 개발자 4명




# 🤚🏻 Part

- 서원빈 - 댓글 API 개발 및 Kakao Map API를 이용한 여정 위치정보 강화
- 박건우 - 회원 API개발 및 시큐리티 적용 
- 박준모 - 회원 API개발 및 시큐리티 적용 
- 장성수 - 여행 검색 및 좋아요 구현




# 🙋🏻‍♂️ Question

프로젝트간 질문거리나 코드리뷰를 받고 싶은 부분들에 대한 내용입니다.

- 시큐리티를 적용해봄으로써 많은 내부 로직 코드들이 스프링 자체적으로 처리를 해주는 것들이 많아 흐름을 따라가기가 어려웠는데 해당 부분들도 구현을 해봤으면 동작흐름을 전부 알고 있어야 하는게 맞을까요?
- accessToken,refreshToken으로 jwt를 통한 인증 시간을 두었는데 서버에서 accessToken 시간이 만료되면 예외를 던지고 가상의 프론트가 있다 생각하여 그 예외를 받으면 다시 refreshToken값을 넣어서 만료기간을 확인하는 식으로 진행중인데 실무에서는 어떻게 쓰이고 있나요?




# 🗣️ 추가사항

- ‘기획안’ 폴더에 해당 프로젝트의 기획안, API명세서, 시스템 아키텍쳐 자료가 들어있습니다.
- ‘구동 모습’ 폴더에도 구동장면 스크린샷들이 들어있습니다.

# 📷 Screenshot

## User
### createUser
![유저 도메인_createUser](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/3b34f0ec-cee1-4bf0-860b-39888640cf94)
### entryAccessToken
![유저 도메인_entryAccessToken](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/0a1e6a21-8f54-4fe0-abb6-b6d57a20f03d)
### getUser
![유저 도메인_getUser](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/7f6a635d-b1d5-4320-bcd2-986fb2923ff3)
### loginUser
![유저 도메인_loginUser](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/ca1d9063-cef2-4046-a106-3e8c5bb3e5bc)
### patchUser
![유저 도메인_patchUser](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/2cfcf695-dacc-4a0c-86d2-6137d86c6c05)
### updateUser
![유저 도메인_updateUser](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/aa95b84d-6b46-485c-8b5d-e8b1e5f27a63)

## Trip
### trips-post
![trip_trips-post](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/fe216138-eecd-4362-863c-63c613b21a70)
### trips-all
![trip_trips-all](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/bbb26e7e-1ed2-4a23-acb0-8eec7efe11a0)
### trips-myAll(get)
![trip_trips-myAll(get)](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/43823092-339b-4df1-81c5-d0629e15b1c8)
### trps-search(get)
![trip_trps-search(get)](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/6c8cb143-f471-46d3-ae65-a9ca0aa4f509)

## Journey
### createJourney
![여정도메인_createJourney](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/af36205e-9b55-46e2-962c-549b6f8895e7)
### getAllJourneysByTrip
![여정도메인_getAllJourneysByTrip](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/362ed889-b083-4565-ac71-bd4ad71248cc)
### updateLodgmentJourney
![여정도메인_updateLodgmentJourney](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/e8cf4565-af9a-4072-af06-ca8329edf0c7)
### updateMoveJourney
![여정도메인_updateMoveJourney](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/af923120-72b4-4e1d-8a65-2fb869deb86d)
### updateVisitJourney
![여정도메인_updateVisitJourney](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/a9fd25b4-027f-4acd-bb35-60445e1ce235)

## Comment
### POST
![Comment_POST](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/3cc04c84-e153-45c3-b48a-e0a0bd5350fd)
### GET
![Comment_GET](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/c26c1bf7-b534-42a7-a343-436e2eecf675)
### PUT
![Comment_PUT](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/841ebce4-7478-41c9-942e-8c2b1e320f6b)
### DELETE
![Comment_DELETE](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/1bc7b6e5-2842-4e85-967d-9e4612a36977)

## Wish
### wishes(post)
![wish_wishes(post)png](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/c5a3d46f-b4de-4b54-ae10-03b51c477e61)
### wishes(delete)
![wish_wishes(delete)](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project3/assets/97028441/1ea4c1c0-0586-4d47-b72c-4a3875b119cc)








