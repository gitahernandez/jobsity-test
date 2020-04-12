package jobsity.assesmenttest.objects;

import java.io.Serializable;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class InputDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String playerName;
    private int pinsfall;

    public void setPinsfall(int pinsfall) {
        this.pinsfall = pinsfall;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPinsfall() {
        return pinsfall;
    }
   
  
}
