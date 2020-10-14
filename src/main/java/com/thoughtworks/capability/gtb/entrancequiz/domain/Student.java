package com.thoughtworks.capability.gtb.entrancequiz.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    // GTB: 变量不符合命名规范
    private int ID;
}
