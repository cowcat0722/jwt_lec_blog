package shop.mtcoding.blog._core.utils;

import org.junit.jupiter.api.Test;
import shop.mtcoding.blog.user.User;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    @Test
    public void create_test() {
        // given
        User user = User.builder()
                .id(1)
                .username("ssar")
                .build();
        // when
        String jwt = JwtUtil.create(user);
        System.out.println("create_test : " + jwt);
        // then

    }

    @Test
    public void verify_test() {
        // given
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJibG9nIiwiaWQiOjEsImV4cCI6MTcxMjAzMDAyNCwidXNlcm5hbWUiOiJzc2FyIn0.Q3H0MVqmom5rVOkrx32K6lE9-D5MOiLrSqWXx4UIIKMV1Bsh6Q5yv-ZzW6RoNt3UzmOldv5mg1lCB2Xl8T-kdg";

        // when
        JwtUtil.verify(jwt);
        // then

    }
}