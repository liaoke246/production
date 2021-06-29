package com.youkeda.comment.system;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;


@Controller
public class Control {

    @Autowired
    Crawler crawler;

    private static final Logger LOG = LoggerFactory.getLogger(Control.class);

    //---------------------------------------------------------------------------
    @RequestMapping("/pw")
    public String index(Model model){

        return "pw.html";
    }
    //---------------------------------------------------------------------------
    @PostMapping("/pw/check")

    public String check(String flatname, String roomname, Model model){

        String url1 = "http://www.houqinbao.com/hydropower/index.php?m=PayWeChat&c=IndexKd&a=find&schoolcode=13579";
        Map<String,String> formData = new HashMap<>();
        formData.put("flatname" , flatname);
        formData.put("roomname" ,  roomname);

        String content = crawler.PostContent(url1,formData);

        Map contentObj = JSON.parseObject(content, Map.class);
        Map data = (Map)contentObj.get("data");

        String dushu = (String)data.get("dushu").toString();

        model.addAttribute("dushu",dushu);

        Map returnData = new HashMap<>();

        returnData.put("现存度数",dushu);
        return "message";


    }


}
