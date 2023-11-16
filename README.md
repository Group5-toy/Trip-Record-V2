# 💡 Topic

- **여행 여정을 기록과 관리하는 SNS 서비스**
- 사용자가 여행 기록과 여행에 따른 여정을 기록할 수 있게 하는 서비스




# 📝 Summary

실제 많은 사람들은 여행을 다녀올 때 한 곳만을 다녀오지 않고 여러 개의 장소를 다녀오며 포스팅을 한다. 이런 점을 본따 사용자가 한 개의 여행을 기록하고 한 개의 여행 안에 여러 개의 장소를 기록할 수 있으며 JSON,CSV 형태로 기록을 남겨 JSON,CSV 파일을 통해 여행 전체를 조회하거나 특정 여행에서  다녀온 장소 여정들을 조회할 수 있도록 하는 서비스이다.




# ⭐️ Key Function

- 여행 기록
    - 사람들이 자신의 여행을 기록할 수 있다.
    - 하나의 여행 안에는 여러 개의 여정을 기록할 수 있다.
- 여정 기록
    - 여행 ID를 통하여 해당하는 여행 속에서 다녀온 장소들을 여정으로 기록할 수 있다.
- 여행 조회
    - 작성한 여행들을 조회해올 수 있다.
- 여정 조회
    - 하나의 여행에서 다녀온 여정들을 조회하고 싶을때 여행 ID를 통하여 조회해올 수 있다.



 

# 🛠 Tech Stack

`JAVA`, `Github`



# ⚙️ Architecture

`MVC`




# 🧑🏻‍💻 Team

- 백엔드 개발자 4명




# 🤚🏻 Part

- 서원빈 - View 구현
- 박건우 - Model 구현
- 박준모 - DTO,Entity 구현
- 장성수 - Controller 구현




# 🤔 Learned

- JSONParser의 동작 원리를 알고, 자바에서의 JSON,CSV 파일을 통한 읽고 쓰기를 알게 되었다.
- 인터페이스의 다형성을 통하여 효과적인 클래스 구성을 할 수 있게 되었다.
- MVC 구조를 고려한 구현으로 각 역할들이 분리되어 있어 코드의 구성을 논리적으로 유지하고 관리할 수 있게 되었다.




# 🙋🏻‍♂️ Question

프로젝트간 질문거리나 코드리뷰를 받고 싶은 부분들에 대한 내용입니다.

- 중복되는 로직들을 최대한 모듈화 시켜서 리팩토링을 진행하고 싶은데 중복되는 코드들 로직이 짧다면 어떻게 리팩토링을 하는게 좋을까요?
- Util 클래스 생성에 대해서는 의견이 사람마다 다른 것 같은데, 만약 한 클래스에서만 쓰이는 로직이더라도 별도의 Util 클래스로 만드는 방식이 괜찮나요? 보편적으로 추구하는 방식이 궁금합니다.




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








