package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.MyConfig;
import org.example.pojo.Student;
import org.example.pojo.StudentLombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController // 相当于是 @Controller +  @ResponseBody
@RequestMapping("stu") //子路由
@Slf4j
public class StuController {
    // request url: http://localhost:8090/stu/888/get?id=1001&name=imooc
    @GetMapping("{stuId}/get")
    public String getStu(@PathVariable("stuId") String stuId,
                         @RequestParam Integer id,
                         @RequestParam String name) {
        /**
         * @RequestParam: 用于获得 url 中的请求参数，如果参数变量名保持一致， 该注解可以省略
         */
        log.info("stuId=" + stuId); // stuId=888
        log.info("Id=" + id); // Id=1001
        log.info("name=" + name); // name=imooc
        return "query Stu";
    }

    /**
     * 在 POSTMAN 里设置：
     * Body: raw JSON format
     * {
     *     "stuId": 1001,
     *     "stuName": "imooc",
     *     "age": 18
     * }
     *
     * Header:
     * Key    Value
     * token  dasfsafsafsafasfasf
     *
     * Cookies
     * clientId=123456; Path=/; Expires=Sun, 26 Nov 2023 02:21:06 GMT;
     *
     *
     * @param map
     * @param token
     * @param clientId
     * @param request
     * @return
     */
    @PostMapping("create")
    public String createStu(@RequestBody Map<String, Object> map,
                            @RequestHeader("token") String token,
                            @CookieValue("clientId") String clientId,
                            HttpServletRequest request) {
        log.info("map=" + map.toString()); // map={stuId=1001, stuName=imooc, age=18}
        log.info("token=" + token); // token=dasfsafsafsafasfasf
        log.info("clientId=" + clientId); // clientId=123456


        String headerToken = request.getHeader("token");
        log.info("headerToken=" + headerToken); // token=dasfsafsafsafasfasf

        return "create Stu";
    }

    @PutMapping("update")
    public String updateStu() {
        return "update Stu";
    }

    @DeleteMapping("delete")
    public String deleteStu() {
        return "delete Stu";
    }


}
