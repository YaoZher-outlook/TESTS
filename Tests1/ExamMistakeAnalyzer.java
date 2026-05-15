package Tests;

import java.util.*;
import java.util.stream.Collectors;

// 学生类
class Student {
    private String name;
    private Map<String, Integer> subjectMistakes;
    
    public Student(String name) {
        this.name = name;
        this.subjectMistakes = new HashMap<>();
    }
    
    public void addMistake(String subject, int count) {
        subjectMistakes.put(subject, subjectMistakes.getOrDefault(subject, 0) + count);
    }
    
    public void addMistakes(String data) {
        String[] parts = data.split(",");
        for (String part : parts) {
            String[] keyValue = part.split(":");
            if (keyValue.length == 2) {
                String subject = keyValue[0].trim();
                int count = Integer.parseInt(keyValue[1].trim());
                addMistake(subject, count);
            }
        }
    }
    
    public Map<String, Integer> getSortedMistakes() {
        return subjectMistakes.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    
    public String getName() {
        return name;
    }
    
    public Map<String, Integer> getSubjectMistakes() {
        return subjectMistakes;
    }
    
    @Override
    public String toString() {
        return name + "的错题统计: " + subjectMistakes;
    }
}

// 错题管理系统
class MistakeManager {
    private Map<String, Student> students;
    
    public MistakeManager() {
        this.students = new HashMap<>();
    }
    
    // 添加学生错题数据
    public void addStudentMistakes(String studentName, String data) {
        Student student = students.getOrDefault(studentName, new Student(studentName));
        student.addMistakes(data);
        students.put(studentName, student);
    }
    
    // 获取学生错题统计（按数量降序排序）
    public Map<String, Integer> getStudentMistakes(String studentName) {
        Student student = students.get(studentName);
        if (student != null) {
            return student.getSortedMistakes();
        }
        return new HashMap<>();
    }
    
    // 获取所有学生信息
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    
    // 获取指定学生的错题最多的科目
    public String getWorstSubject(String studentName) {
        Map<String, Integer> mistakes = getStudentMistakes(studentName);
        if (!mistakes.isEmpty()) {
            return mistakes.entrySet().iterator().next().getKey();
        }
        return "暂无数据";
    }
}