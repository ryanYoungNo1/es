package com.es.esdemo.controller;



import com.es.esdemo.domain.Person;
import com.es.esdemo.service.EsService;
import com.es.esdemo.util.FileUtil;
import com.es.esdemo.util.ParseDocUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/es")
public class EsController {

    private static final Logger log = Logger.getLogger(EsController.class.getName());


    @Autowired
    private EsService esService;
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String getPerson(@RequestParam String id){
        /*String mobile = params.get("mobile").toString();
        String nickname = params.get("nickname").toString();*/
        Optional<Person> person = esService.findUserByMobileContainingOrNicknameContaining(id);
        Person destPerson = person.get();
        StringBuffer buffer = new StringBuffer();
        buffer.append(destPerson.getId()).append(destPerson.getMobile()).append(destPerson.getNickname()).append(destPerson.getPassword());
        //String s = person.toString();
        return buffer.toString();

    }

    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public List<Person> getPerson(@RequestParam String mobile, @RequestParam String nickname){
        /*String mobile = params.get("mobile").toString();
        String nickname = params.get("nickname").toString();*/
        List<Person> list = esService.findUserByMobileAndNicknameContaining(mobile, nickname);
        return list;

    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addPerson(){
        Person person = new Person();
        person.setId("1");
        person.setMobile("15291843298");
        person.setNickname("ryan");
        person.setPassword("000028");
        esService.save(person);
        return "success";
    }


    @RequestMapping(value = "/filesUpload",method = RequestMethod.GET)
    //requestParam要写才知道是前台的那个数组
    public String filesUpload(HttpServletRequest request) throws Exception {
        List<String> list = new ArrayList<String>();
        //FileInputStream fileInputStream = new FileInputStream(new File("D://test.doc"));
        File file = new File("D://test.doc");
        //list = FileUtil.saveFile(request, file, list);
        String text = ParseDocUtil.getTextFromWord(file);
        //写着测试，删了就可以
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println("集合里面的数据" + list.get(i));
        }*/
        return text;//跳转的页面
    }



}
