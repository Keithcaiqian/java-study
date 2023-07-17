package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

//@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成jwt
     * */
    @Test
    public void testGenJwt(){

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "daitoue")  //签名算法
                .setClaims(claims) //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置有效期为1h
                .compact();

        System.out.println(jwt);
    }

    /**
     * 解析jwt
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("daitoue")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4OTYwMDc2Nn0.VN5n8vlj36b9gnzNfzNzN0wTiwcGPa_wmdCOym_AUHQ")
                .getBody();
        System.out.println(claims);
    }
}
