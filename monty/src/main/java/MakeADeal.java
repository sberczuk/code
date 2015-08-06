/**
 * Created by sberczuk on 3/10/14.
 */
public class MakeADeal {

    int selected;
   private  int prize; // 0 indexed
   private int numDoors;

    public MakeADeal(){
        numDoors = 100;
        prize = 2;

    }


    public int chooseDoor(){
        double numDoorsAsDouble = numDoors;
        double doorAsDouble = Math.random() * numDoorsAsDouble;
        int pick = Double.valueOf(Math.floor(doorAsDouble)).intValue();
        return pick;
    }

    public int openDoor(int currSelected){
        for(int i = 0; i< numDoors; i++){
            if(i != currSelected && i != prize){
                return i;
            }
        }
        System.out.println("BAD DOOR");
        return 0;
    }
    public int changeChoice(int original, int openDoor){

        int newChoice = original;
        while (newChoice != original && newChoice != openDoor){
            newChoice=chooseDoor();
        }
        return newChoice;
    }

    public static void main(String[] args) {
        MakeADeal makeADeal = new MakeADeal();
        int success = 0;
        int tries = 1000000;
        // raw results
        for (int i = 0; i < tries; i++){
            int choice = makeADeal.chooseDoor();
            if(choice == makeADeal.getPrize()){
                success++;
            }
        }
        System.out.println(Double.valueOf(success)/tries);

        // switch v not
        int origSuccess = 0;
        for (int i = 0; i < tries; i++){
            int choice = makeADeal.chooseDoor();
            if(choice == makeADeal.getPrize()){
                origSuccess++;
            }
            int openDoor = makeADeal.openDoor(choice);
            int newChoice = makeADeal.changeChoice(choice, openDoor);

            if(choice == makeADeal.getPrize()){
                success++;
            }
        }
        System.out.println(Double.valueOf(success)/tries);
        System.out.println(Double.valueOf(origSuccess)/tries);

    }

    public int getPrize() {
        return prize;
    }
    public int getNumDoors(){
        return numDoors;
    }
}
