package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class FileUpload {


    @RequestMapping(value = "/up",method = RequestMethod.POST)
    public String uplloadFile(MultipartFile file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if(file!=null){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        }

        return  stringBuilder.toString();
    }
}
