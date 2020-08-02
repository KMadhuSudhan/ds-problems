package ds.problems.system.design;

import java.util.Stack;

//https://leetcode.com/problems/design-browser-history/
public class BrowserHistory {

    Stack<String> history;
    Stack<String> farward;
    String current;
    public BrowserHistory(String homepage) {
        history = new Stack();
        farward = new Stack();
        current = homepage;
    }

    public void visit(String url) {
        history.push(current);
        current = url;
        farward.removeAllElements();
    }

    public String back(int steps) {
        while(steps>0 && !history.isEmpty()) {
            farward.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        while(steps>0 && !farward.isEmpty()) {
            history.push(current);
            current = farward.pop();
            steps--;
        }
        return current;
    }
}
