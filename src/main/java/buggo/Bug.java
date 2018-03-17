package buggo;
//Created by Sean C. on 2/13/2018

/**
 * Bug Class, has methods up() and getPosition()
 */
public class Bug {
    private int pos = 0;

    /**
     * Increments Bug Object's position by 10 each time.  Resets to 0 at 100.
     */
    public void up(){
        pos += 10;
        if(pos == 100){
            pos = 0;
        }
    }

    /**
     * @return position as a string.
     */
    public String getPosition(){
        return String.valueOf(pos);
    }
}
