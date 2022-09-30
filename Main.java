public class Main 
{
    public static void main(String[] args) 
    {
        GuessingGame g = new GuessingGame("Does it have four legs?", "Fish", "Dog");
        System.out.println("Please type 'yes' or 'no' for your yes/no questions.");
        g.play();
    }
}
