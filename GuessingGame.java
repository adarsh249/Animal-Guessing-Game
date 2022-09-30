import TreePackage.DecisionTreeInterface;
import TreePackage.DecisionTree;
import java.util.Scanner;

public class GuessingGame
{
    private DecisionTreeInterface<String> tree;
    private Scanner in;

    public GuessingGame(String question, String noAnswer, String yesAnswer)
    {
        DecisionTree<String> no = new DecisionTree<>(noAnswer);
        DecisionTree<String> yes = new DecisionTree<>(yesAnswer);
        tree = new DecisionTree<>(question, no, yes);
        in = new Scanner(System.in);
    }

    public void play()
    {
        if(tree.isAnswer())
        {
            System.out.println("My guess is " + tree.getCurrentData() + ", Am I right?");
            String res = in.nextLine();
            if(res.toUpperCase().equals("YES"))
                System.out.println("I win!");
            if(res.toUpperCase().equals("NO"))
                learn();
            
            System.out.println("Play again?");
            res = in.nextLine();
            if(res.toUpperCase().equals("YES"))
            {
                tree.resetCurrentNode();
                play();
            }
            else
                return;
        }
        else
        {
            System.out.println(tree.getCurrentData());
            String ans = in.nextLine();
            if(ans.toUpperCase().equals("YES"))
            {
                tree.advanceToYes();            
                play();
            }  
            else if(ans.toUpperCase().equals("NO"))
            {
                tree.advanceToNo();
                play();
            }
        }


        
            
    }

    public void learn()
    {
        String no = tree.getCurrentData();
        System.out.println("I give up; what were you thinking of?");
        String yes = in.nextLine();
        System.out.println("Give me a question whose answer is yes for " + yes + " and no for " + no);
        String question = in.nextLine();
        tree.setCurrentData(question);
        tree.setResponses(no, yes);
    }
}
