package toy.five.triprecord.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.five.triprecord.domain.user.dto.request.UserCreateRequest;
import toy.five.triprecord.domain.user.dto.request.UserGetRequest;
import toy.five.triprecord.domain.user.dto.request.UserPatchRequest;
import toy.five.triprecord.domain.user.dto.request.UserUpdateReqeust;
import toy.five.triprecord.domain.user.dto.response.UserCreateResponse;
import toy.five.triprecord.domain.user.dto.response.UserGetResponse;
import toy.five.triprecord.domain.user.dto.response.UserPatchResponse;
import toy.five.triprecord.domain.user.dto.response.UserUpdateResponse;
import toy.five.triprecord.domain.user.service.UserService;
import toy.five.triprecord.global.common.StatusCode;
import toy.five.triprecord.global.exception.ApiResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse> getUser(@Valid @RequestBody UserGetRequest userGetRequest) {

        UserGetResponse userGetResponse = userService.getUserInfo(userGetRequest.getEmail());

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(String.valueOf(StatusCode.SUCCESS))
                        .code(HttpStatus.OK.value())
                        .data(userGetResponse)
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        UserCreateResponse savedUser = userService.createUser(userCreateRequest);
        return ResponseEntity.ok(ApiResponse.builder()
                .status(String.valueOf(StatusCode.SUCCESS))
                .code(HttpStatus.OK.value())
                .data(savedUser)
                .build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserUpdateReqeust userUpdateReqeust) {
        UserUpdateResponse updatedUser = userService.updateUser(userUpdateReqeust);
        return ResponseEntity.ok(ApiResponse.builder()
                .status(String.valueOf(StatusCode.SUCCESS))
                .code(HttpStatus.OK.value())
                .data(updatedUser)
                .build());

    }

    @PatchMapping
    public ResponseEntity<ApiResponse> patchUser(@Valid @RequestBody UserPatchRequest userPatchRequest) {

        UserPatchResponse userPatchResponse = userService.patchUser(userPatchRequest);

        return ResponseEntity.ok(ApiResponse.builder()
                .status(String.valueOf(StatusCode.SUCCESS))
                .code(HttpStatus.OK.value())
                .data(userPatchResponse)
                .build());
    }





}
