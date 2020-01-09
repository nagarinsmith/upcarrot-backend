package com.upcarrot.UpCarrot.Controller;



import com.upcarrot.UpCarrot.Service.BaseService;
import com.upcarrot.UpCarrot.Service.TestService;
import com.upcarrot.UpCarrot.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController<Test> {

    @Autowired
    private TestService testService;

    @Override
    public BaseService<Test> getService() {
        return testService;
    }
}