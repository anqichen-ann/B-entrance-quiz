package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@Validated
// GTB: 不符合三层架构，缺少Service层来处理业务逻辑
// GTB: 不符合三层架构，缺少Repository层来保存数据
public class GroupController {
    public String[] student = new String[]{"成吉思汗", "鲁班七号", "太乙真人", "钟无艳",
            "花木兰", "雅典娜", "芈月", "白起", "刘禅", "庄周", "马超", "刘备",
            "哪吒", "大乔", "蔡文姬"};
    // GTB: 命名问题，studentNameList更表意
    public List<String> studentList = Arrays.asList(student);

    // GTB: 违反Restful实践, url不合理
    @GetMapping("/student")
    // GTB: ResponseEntity应该使用泛型
    // GTB: 该API应该返回Student对象的List，且按ID升序排列
    public ResponseEntity getStudent(){
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/group")
    // GTB: 应该创建专门的对象来表示Group
    public ResponseEntity groupStudent(){
        Collections.shuffle(studentList);
        // GTB：无用的变量
        Iterator ite = studentList.iterator();
        // GTB：Magic Number
        // GTB: 代码风格问题，很多该添加空格的地方没有加空格
        int length = studentList.size()/6;
        int left = studentList.size()%6;
        List list = new ArrayList();
        int index = 0;
        for(int i=0;i<6;i++){
            if(index<left){
                // GTB: 代码可读性低
                list.add(studentList.subList(i*(length+1),(i+1)*(length+1)));
                index++;
            }else {
                list.add(studentList.subList(i*length+left,(i+1)*length+left));
            }
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/addStudent")
    public ResponseEntity addNewStudent(@RequestBody Student newStudent){

        return ResponseEntity.ok(studentList);

    }


}
