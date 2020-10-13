package com.thoughtworks.capability.gtb.entrancequiz.api;

import javafx.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@Validated
public class GroupController {
    public String[] student = new String[]{"成吉思汗", "鲁班七号", "太乙真人", "钟无艳",
            "花木兰", "雅典娜", "芈月", "白起", "刘禅", "庄周", "马超", "刘备",
            "哪吒", "大乔", "蔡文姬"};
    public List<String> studentList = Arrays.asList(student);

    @GetMapping("/student")
    public ResponseEntity getStudent(){
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/group")
    public ResponseEntity groupStudent(){
        Collections.shuffle(studentList);
        Iterator ite = studentList.iterator();
        int length = studentList.size()/6;
        int left = studentList.size()%6;
        List list = new ArrayList();
        int index = 0;
        for(int i=0;i<6;i++){
            if(index<left){
                list.add(studentList.subList(i*(length+1),(i+1)*(length+1)));
                index++;
            }else {
                list.add(studentList.subList(i*length+left,(i+1)*length+left));
            }
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/addStudent")
    public ResponseEntity addNewStudent(@RequestBody Pair<String,String> newStudent){
        String newName = newStudent.getValue();
        studentList.add(newName);
        return ResponseEntity.ok(studentList);

    }


}
