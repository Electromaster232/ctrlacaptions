package me.djelectro.ctrlaencoder.tui;

import java.lang.reflect.Method;
import java.util.*;

public class Menu {
    private String question = "";
    private Map<Integer, String> answerChoices = new HashMap<>();
    protected static ArrayList<Menu> menuHistory = new ArrayList<>();
    private String extraText = "";
    private String menuName;


    public Menu(String menuName1, String question1, Map<Integer, String> answerChoices1){
        //menuHistory = menuHistory1;
        question = question1;
        answerChoices = answerChoices1;
        menuHistory.add(this);
        menuName = "=========== " + menuName1 + " ===========\n";
    }

    public void setExtra(String extraText){
        this.extraText = extraText;
    }


    protected void updateQuestion(String newQuestion){question = newQuestion;}

    protected String getQuestion(){return question;}

    protected void updateAnswers(Map<Integer, String> newMap){answerChoices = newMap;}
    protected Map<Integer, String> getAnswerChoices(){return answerChoices;}

    public void print(){
        int consoleSize = ConsoleUtil.getTerminalHeight();
        ConsoleUtil.clearConsole();

        String finalMenuString = menuName + question + "\n\n" + extraText;
        System.out.println(finalMenuString);

        consoleSize -= (finalMenuString.length() / ConsoleUtil.getTerminalWidth()) + 2;
        consoleSize -= finalMenuString.chars().filter(ch -> ch == '\n').count();

        StringBuilder answerString = new StringBuilder();
        answerChoices.forEach((a, n) -> {
            answerString.append("(").append(a).append(") ").append(n).append("  ");});

        consoleSize -= (answerString.length() / ConsoleUtil.getTerminalWidth());

        while(consoleSize != 0){System.out.print("\n"); consoleSize--;}
        System.out.print(answerString);

        try {
            Scanner s1 = new Scanner(System.in);
            int choice = Integer.parseInt(s1.nextLine());
            doAnswer(choice);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error encountered. Reloading menu");
            print();
        }
    }

    // Override me!
    protected void doAnswer(int choice){System.out.println("Choice was " + choice + " Value was " + answerChoices.get(choice));}

    protected void goBack(){
        Menu toGoBack = menuHistory.get(menuHistory.size() - 2);
        menuHistory.add(toGoBack);
        toGoBack.print();
    }

    protected static Method getClassMethod(Class classLookup, String method){
        try {
            return classLookup.getMethod(method);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}