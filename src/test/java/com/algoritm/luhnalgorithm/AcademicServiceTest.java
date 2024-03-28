package com.algoritm.luhnalgorithm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AcademicServiceTest {

    @Autowired
    private AcademicService academicService;

    private List<List<Integer>> conditionList = new ArrayList<>();

    //Test1
    private List<Integer> condition11 = Arrays.asList(1,0);
    private List<Integer> condition12 = Arrays.asList(2,0);
    private List<Integer> condition13 = Arrays.asList(3, 1, 2);

    //Test2
    private List<Integer> condition21 = Arrays.asList(0, 1, 2);
    private List<Integer> condition22 = Arrays.asList(1, 3);
    private List<Integer> condition23 = Arrays.asList(2, 3);
    private List<Integer> condition24 = Arrays.asList(3, 4, 5);
    private List<Integer> condition25 = Arrays.asList(4, 6);
    private List<Integer> condition26 = Arrays.asList(5, 6);

    //Test3
    private List<Integer> condition31 = Arrays.asList(4,0,2);
    private List<Integer> condition32 = Arrays.asList(0,1,6);
    private List<Integer> condition33 = Arrays.asList(2,3,7);
    private List<Integer> condition34 = Arrays.asList(1,5);
    private List<Integer> condition35 = Arrays.asList(6,5);
    private List<Integer> condition36 = Arrays.asList(3,5);
    private List<Integer> condition37 = Arrays.asList(7,5);



    @Test
    void academicTest1() {
        conditionList.add(condition11);
        conditionList.add(condition12);
        conditionList.add(condition13);
        System.out.println("-------> " + academicService.findSchedule(4, conditionList));
    }

    @Test
    void academicTest2() {
        conditionList.add(condition21);
        conditionList.add(condition22);
        conditionList.add(condition23);
        conditionList.add(condition24);
        conditionList.add(condition25);
        conditionList.add(condition26);
        System.out.println("-------> " + academicService.findSchedule(7, conditionList));
    }

    @Test
    void academicTest3() {
        conditionList.add(condition31);
        conditionList.add(condition32);
        conditionList.add(condition33);
        conditionList.add(condition34);
        conditionList.add(condition35);
        conditionList.add(condition36);
        conditionList.add(condition37);
        System.out.println("-------> " + academicService.findSchedule(8, conditionList));
    }
}
