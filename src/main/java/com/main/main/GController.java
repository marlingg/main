package com.main.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    String[] monday = new String[] { "Михайло Пилипчук", "Владислав Турбан", "Максим Сич" };
    String[] tuesday = new String[] { "Марія Рага", "Вероніка Томанець", "Дана Середа" };
    String[] wednesday = new String[] { "Назар Романець", "Ілля Поліщук", "Богдан Замрій" };
    String[] thursday = new String[] { "Віталій Амельчинко", "Юрій Голдасевич", "Анна Люба" };
    String[] friday = new String[] { "Вікторія Дашкевич", "Максим Слободян", "Роман Лисий" };

    @PostMapping("/CleanMehanik")
    public String procesText(@RequestParam("name") String name, Model CleanModel) {
        switch (name) {
            case "Міша Пилипчук":
            case "Пилипчук Міша":
            case "Пилипчук Михайло":
            case "Михайло Пилипчук":
                CleanModel.addAttribute("ClearDay0", monday[0]);
                CleanModel.addAttribute("ClearDay1", monday[1]);
                CleanModel.addAttribute("ClearDay2", monday[2]);
                break;
            default:
                return "main";
        }
        return "main";
    }

    @PostMapping("/MarksMehanik")
    public String procesText(@RequestParam("mark1") String mark1,
            @RequestParam("mark2") String mark2,
            @RequestParam("mark3") String mark3,
            @RequestParam("mark4") String mark4,
            @RequestParam("mark5") String mark5,
            Model MarkModel) {
        int marks1 = Integer.parseInt(mark1);
        int marks2 = Integer.parseInt(mark2);
        int marks3 = Integer.parseInt(mark3);
        int marks4 = Integer.parseInt(mark4);
        int marks5 = Integer.parseInt(mark5);

        int[] marks = new int[] { marks1, marks2, marks3, marks4, marks5 };

        int zeromarks = 5;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == 0) {
                zeromarks -= 1;
            }
        }

        int mark;
        if (marks[0] != 0 && marks[1] != 0 && marks[3] != 0 && marks[4] != 0 && marks[5] != 0) {

            mark = (marks[0] + marks[1] + marks[2] + marks[3] + marks[4]) / 5;
            MarkModel.addAttribute("mark", mark);

        } else if (zeromarks >= 1) {

            mark = (marks[0] + marks[1] + marks[2] + marks[3] + marks[4]) / zeromarks;
            MarkModel.addAttribute("mark", mark);

        }

        return "main";
    }

}
