package StackEx;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack newsFeed = new Stack();
        newsFeed.push("Morning News");
        newsFeed.push("Afternoon News");
        newsFeed.push("Evening News");


        String breakingNews = (String) newsFeed.pop();
        System.out.println(breakingNews);
    }

}
