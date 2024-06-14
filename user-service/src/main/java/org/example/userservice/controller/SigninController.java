package org.example.userservice.controller;

import lombok.AllArgsConstructor;
import org.example.userservice.mapper.SignMapper;
import org.example.userservice.po.User;
import org.example.userservice.response.MSresponse;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/signin")
public class SigninController {
    private final SignMapper signMapper;

    @CrossOrigin(origins = {"*","http://localhost:8082"})
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public MSresponse signin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        MSresponse response = new MSresponse();
        User user = null;
        if(username == null || password == null || username.length() == 0 || password.length() == 0) {
            response.setCode(400);
            response.setMessage("Invalid input");
            response.setResult(null);
        } else {
            String realPwd = signMapper.findPwdByName(username);
            if(realPwd == null || !realPwd.equals(password)) {
                response.setCode(400);
                response.setMessage("Invalid username or password");
                response.setResult(null);
            } else {
                response.setCode(200);
                response.setMessage("OK");
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
            }
        }
        response.setResult(user);
        return response;
    }
}
