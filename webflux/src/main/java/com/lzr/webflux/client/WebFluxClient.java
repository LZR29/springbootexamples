package com.lzr.webflux.client;

import com.lzr.webflux.bean.User;
import com.lzr.webflux.vo.UserVo;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**webflux客户端
 * @author linzerong
 * @create 2019-06-04 9:41
 */
public class WebFluxClient {
    public static void main(String[] args) {
        WebClient client = WebClient.create("http://localhost:8080/user");
        insert(client);
    }
    private static void insert(WebClient client){
        Mono<UserVo> userVoMono = client.get()
                .uri("/insert/{user}",  "10-zr-0-note")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToMono(UserVo.class);
        UserVo user = userVoMono.block();
        System.out.println(user.getId()+user.getUserName()+user.getNote()+"!!!!!!");
    }
}
