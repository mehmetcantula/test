package com.algoritm.luhnalgorithm;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AcademicService {

    public List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
        List<Integer> schedule = new ArrayList<>();
        Map<Integer, List<Integer>> prerequisitesMap = getConditions(numCourses, prerequisites);

        // Ders sayısını takip etmek için bir değişken oluştur
        int remainingCourses = numCourses;

        // Ders sayısı sıfır olana kadar döngüyü tekrarla
        while (remainingCourses > 0) {
            boolean addedCourse = false;
            // Her ders için, ön koşulu olmayan en küçük indekse sahip dersi bul
            for (int i = 0; i < numCourses; i++) {
                if (prerequisitesMap.get(i) != null && prerequisitesMap.get(i).isEmpty()) {
                    schedule.add(i);
                    remainingCourses--;

                    // Eklenen dersin ön koşullarını prerequisitesMap'ten kaldır
                    prerequisitesMap.remove(i);

                    // Eklenen dersi içeren ön koşulları da prerequisitesMap'ten kaldır
                    for (Map.Entry<Integer, List<Integer>> entry : prerequisitesMap.entrySet()) {
                        entry.getValue().remove(Integer.valueOf(i));
                    }

                    addedCourse = true;
                    break;
                }
            }
            // Eğer herhangi bir dersin ön koşulu yoksa ve ders sayısı sıfır değilse, döngüyü sonlandır
            if (!addedCourse) {
                break;
            }
        }

        // Ders sayısı sıfır olmadığı halde döngü sona ererse, geçersiz bir durum söz konusudur, boş bir liste döndürülür
        if (remainingCourses > 0) {
            return new ArrayList<>();
        }

        return schedule;
    }


    private Map<Integer, List<Integer>> getConditions(int dersSayisi, List<List<Integer>> prerequisites){

        Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();

        for (int i = 0; i < dersSayisi; i++) {
            prerequisiteMap.put(i, new ArrayList<>());
        }

        for (List<Integer> prerequisite : prerequisites) {
            int ders = prerequisite.get(0);

            for (int i = 1; i < prerequisite.size(); i++) {
                prerequisiteMap.get(ders).add(prerequisite.get(i));
            }
        }

        return prerequisiteMap;
    }
}