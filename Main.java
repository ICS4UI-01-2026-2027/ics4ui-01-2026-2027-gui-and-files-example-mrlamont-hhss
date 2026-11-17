public class Main{
  public static void main(String[] args){
    Map map = new Map("pics.txt");
    MainScreen screen = new MainScreen();

    Controller c = new Controller(map, screen);

    screen.addActionListener(c);
  }
}
