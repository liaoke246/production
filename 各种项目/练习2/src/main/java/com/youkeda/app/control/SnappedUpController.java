package com.youkeda.app.control;

import com.youkeda.app.model.Result;
import com.youkeda.app.service.SnappedUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SnappedUpController {
    @Autowired
    private SnappedUpService snappedUpService;

    /**
     * 抢购
     * 抢购成功返回true
     * @return Result
     */
    @GetMapping("/snappedUp")
    @ResponseBody
    public Result<Boolean> snappedUp(@RequestParam("id") Long id) {
        return snappedUpService.snappedUp(id);
    }
}
