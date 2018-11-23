/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.ArrayList;

public class CourseScores {
    private ArrayList<Integer> scores;
    private int[] gradeDistribution = new int[6];
    
    public CourseScores() {
        this.scores = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++) {
            this.gradeDistribution[i] = 0;
        }
    }
    
    public void addScore(int score) {
        this.scores.add(score);
        this.gradeDistribution[scoreToGrade(score)]++;
    }
    
    public int scoreToGrade(int score) {
        if(score < 30) {
            return 0;
        }
        if(score < 35) {
            return 1;
        }
        if(score < 40) {
            return 2;
        }
        if(score < 45) {
            return 3;
        }
        if(score < 50) {
            return 4;
        }
        return 5;
    }
    
    public double acceptancePercentage() {
        int totalAccepted = 0;
        for(int i = 1; i < 6; i++) {
            totalAccepted += this.gradeDistribution[i];
        }
        return (double)totalAccepted / this.scores.size() * 100;
    }
    
    public void printGradeLevel(int gradeLevel) {
        System.out.print(gradeLevel + ": ");
        for(int i = 0; i < this.gradeDistribution[gradeLevel]; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
    
    public void print() {
        System.out.println("Grade distribution:");
        for(int i = 5; i >= 0; i--) {
            this.printGradeLevel(i);
        }
        System.out.println("Acceptance percentage: " + this.acceptancePercentage());
    }
}
