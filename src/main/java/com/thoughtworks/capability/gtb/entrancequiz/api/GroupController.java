package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@Validated
public class GroupController {
    public List<String> studentList = Arrays.asList("成吉思汗", "鲁班七号", "太乙真人", "钟无艳",
            "花木兰", "雅典娜", "芈月", "白起", "刘禅", "庄周", "马超", "刘备",
            "哪吒", "大乔", "蔡文姬");

    @GetMapping("/group")
    public ResponseEntity groupStudent(){
        Collections.shuffle(studentList);
        Iterator ite = studentList.iterator();
        int length = studentList.size()/6;
        int left = studentList.size()%6;
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        List list4 = new ArrayList();
        List list5 = new ArrayList();
        List list6 = new ArrayList();

        list1.add(studentList.subList(0*length,1*length-1));
        list2.add(studentList.subList(1*length,2*length-1));
        list3.add(studentList.subList(2*length,3*length-1));
        list4.add(studentList.subList(3*length,4*length-1));
        list5.add(studentList.subList(4*length,5*length-1));
        list6.add(studentList.subList(5*length,6*length-1));

        List result = new ArrayList();
        result.add(list1);
        result.add(list2);
        result.add(list3);
        result.add(list4);
        result.add(list5);
        result.add(list6);
        return ResponseEntity.ok(result);


    }
}
