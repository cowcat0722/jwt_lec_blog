package shop.mtcoding.blog._core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import shop.mtcoding.blog.user.SessionUser;
import shop.mtcoding.blog.user.User;

import java.util.Date;

public class JwtUtil {

    // 토큰 생성
    public static String create(User user) {

        String jwt = JWT.create()
                .withSubject("blog")
                .withExpiresAt(new Date(System.currentTimeMillis() + + 1000*60*60))
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .sign(Algorithm.HMAC512("metacoding")); // 환경변수로 넣어줘야 안전하다

        return jwt;
    }

    public static SessionUser verify(String jwt) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("metacoding")).build().verify(jwt);
        // 검증을 통과하면 값들을 가져올 수 있다.
        int id = decodedJWT.getClaim("id").asInt();
        String username = decodedJWT.getClaim("username").asString();
        // 검증하고 나서 세션에 저장을 함
        return SessionUser.builder()
                .id(id)
                .username(username)
                .build();
    }
}
