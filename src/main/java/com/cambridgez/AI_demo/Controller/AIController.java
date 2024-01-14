package com.cambridgez.AI_demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import utils.AIUtiles;

import java.io.IOException;

@RestController
public class AIController {

    @RequestMapping(value = "/PicToWord",method = RequestMethod.POST)// http://localhost:8080/PicToWord
    public String PicToWord(@RequestParam("file") MultipartFile file) throws IOException {
//        System.out.println(file.getOriginalFilename());
        String res = AIUtiles.picToWord(file);
        return res;
    }
}
