package toy.five.triprecord.global.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import toy.five.triprecord.domain.user.dto.request.UserLoginRequest;
import toy.five.triprecord.global.exception.BaseException;
import toy.five.triprecord.global.exception.ErrorCode;
import toy.five.triprecord.global.security.entity.RefreshToken;
import toy.five.triprecord.global.security.repository.TokenRepository;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;

    private int accessTokenExpMinutes = 10;
    private int refreshTokenExpMinutes = 100;

    // 비밀키 설정
    private static final String SECRET_KEY = "SGWw9ffMeji1wWQub1WYx5VmIxEPg3uDDn3j0KTVQstPzqnR+HyCFIn0OAqTm5DJOymrtMNAmx0K5RPTxuMqPdDuUhDr+fu8ahKXnyny+Ll7IoOUtbQfGg3F/oJtKJRE4XLXz7BRMIIVDjTk+YJMYLojy/naao+Dt0otNWRkyneN2X4mbEcJrf2ad0Bf6iwdi5ZofAjLcW5lf1eD9gjGtFZ/sfHSEM1aZttAFuSSEReShyqOqIF1L971+2xdQw3rY2WA78fjxCMSUwQpQFdK9/bDf3706foywkWfta8lGoVA7y4rwE0uWMoMN+VpjbWBZ+RyysO0nFu8Rrivnb8XD31e12axFpdeh0tr2fbodFU=";


    public void authenticate(UserLoginRequest userLoginRequest) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginRequest.getEmail());
            if (!passwordEncoder.matches(userLoginRequest.getPassword(), userDetails.getPassword())) {
                throw new BaseException(ErrorCode.USER_NO_APPROVE_ERROR);
            }
        } catch (UsernameNotFoundException e) {
            throw new BaseException(ErrorCode.USER_CAN_NOT_FIND_EMAIL);
        }

    }
    /**
    public void authenticate(UserLoginRequest userLoginRequest) {
       try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           userLoginRequest.getEmail(),
                           userLoginRequest.getPassword()
                   )
           );
       }catch (AuthenticationException e) {
          throw new BaseException(ErrorCode.USER_NO_APPROVE_ERROR);
      }
    }
     **/

    public List<String> generateToken(UserLoginRequest userLoginRequest) {
        System.out.println("테스트2");
        // 로그인 요청에 대한 인증을 수행합니다.
        // 이 부분은 사용자의 아이디와 비밀번호를 확인하는 로직으로 구현해야 합니다.
        authenticate(userLoginRequest);

        String accessToken = generateAccessTokens(userLoginRequest);
        String refreshToken = generateRefreshTokens(userLoginRequest);

        return Arrays.asList(accessToken,refreshToken);
    }

    // Claim들 과 userdrtail로 토큰 생성하는 메서드
    public String generateAccessTokens(UserLoginRequest userLoginRequest) {
        System.out.println("테스트3");
        // 액세스 토큰 생성
        String accessToken = Jwts.builder()
                .setSubject(userLoginRequest.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpMinutes * 60 * 1000))  // 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();

        // 리프레시 토큰 생성

        return accessToken;
    }

    public String generateRefreshTokens(UserLoginRequest userLoginRequest) {
        System.out.println("테스트4");
        String refreshToken = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpMinutes * 60 * 1000))  // 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();

        return refreshToken;

    }




    public String accessTokenCheck(String token) {
        Claims accessClaims = extractAllClaims(token);
        //억세스 토큰만 만료됐을때
        if (accessClaims.getExpiration().before(new Date())) {
            String email = accessClaims.getSubject();
            RefreshToken refreshToken = tokenRepository.findByEmail(email)
                    .orElseThrow(() -> new BaseException(ErrorCode.USER_NO_EXIST));

            Claims refreshClaims = Jwts.parser()
                    .parseClaimsJws(refreshToken.getToken()).getBody();
            Date expirationDate = refreshClaims.getExpiration();

            //리프레쉬랑 억세스 둘 다 만료됐을때 -> 프론트에서 REFRESH_TOKEN_EXPIRED가 발생하면 로그인 login호출해라고 하는거
            if (expirationDate.before(new Date())) {
                throw new BaseException(ErrorCode.REFRESH_TOKEN_EXPIRED);
            }
            else {
                //억세스토큰만 만료됐을때 -> 프론트에서 ACCESS_TOKEN_EXPIRED가 발생하면 억세스 토큰만 재발급하는 api 호출하라고 하는 거
                throw new BaseException(ErrorCode.ACCESS_TOKEN_EXPIRED);
            }
        }
        // 억세스토큰의 유효기간이 만료되지 않았을 때
        else {
            // 토큰을 그대로 반환하여 현재 세션을 계속 유지
            return token;
        }
    }
  /**
    public String accessTokenCheck(String token) {
        Claims accessClaims = extractAllClaims(token);

        if (accessClaims.getExpiration().before(new Date())) {
            String email = accessClaims.getSubject();
            RefreshToken refreshToken = tokenRepository.findByEmail(email)
                    .orElseThrow(() -> new BaseException(ErrorCode.USER_NO_EXIST));
        } else{
            String email = accessClaims.getSubject();
            RefreshToken refreshToken = tokenRepository.findByEmail(email)
                    .orElseThrow(() -> new BaseException(ErrorCode.USER_NO_EXIST));

            Claims refrestClaims = Jwts.parser()
                    .parseClaimsJws(refreshToken.getToken()).getBody();
            Date expirationDate = refrestClaims.getExpiration();

            //리프레쉬랑 억세스 둘 다 만료됐을때
            if (expirationDate.before(new Date())) {
                throw new BaseException(ErrorCode.ALL_TOKEN_EXPIRED);
            }
            else {
                //억세스토큰만 만료됐을떄
                throw new BaseException(ErrorCode.REFRESH_TOKEN_EXPIRED);
            }

        }
    }
   **/

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // 토큰안의 Claims 추출 메서드
    private Claims extractAllClaims(String token) {

        return Jwts
                // JWT 토큰을 파싱(담긴 정보 분석)하기 위한 JwtParserBuilder 객체를 생성
                .parserBuilder()
                // JWT 토큰 파싱에 사용할 서명 키를 설정
                .setSigningKey(getSignInKey())
                // JwtParser 객체를 생성
                .build()
                // JwtParser 객체와 매개변수로 넣은 토큰을 비교하여 실제 검증작업
                // 검증된다면 Jws<Claims> 객체 반환, 검증되지 않는다면 JwtException 발생
                .parseClaimsJws(token)
                // 객체에서 Claims를 추출, DB사용안하고 이 내용으로 다른 로직 구현
                .getBody();
    }

    private Key getSignInKey() {
        // 비밀키를 BASE64로 디코딩하여 바이트 배열로
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        // 디코딩된 바이트 배열을 이용해 HMAC-SHA 알고리즘에 사용될 Key 객체 생성
        // 실제 JWT토큰을 만드는데 사용되는 알고리즘에 키 값을 넣어 세팅하는 것이다.
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
