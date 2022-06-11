package github.beeclimb.spot.admin.education.controller;

import github.beeclimb.spot.common.util.api.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jun.ma
 * @date 2022/6/10 22:44:00
 */
@RestController
@RequestMapping("/temp/user")
public class TempLoginController {

    @PostMapping("/login")
    public Response<Map<String, String>> login() {
        Map<String, String> m = new HashMap<>(1);
        m.put("token", "token");
        return Response.success(m);
    }

    @GetMapping("/info")
    public Response<Map<String, String>> getInfo() {
        Map<String, String> m = new HashMap<>(1);
        m.put("name", "admin");
        m.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Response.success(m);
    }
}
