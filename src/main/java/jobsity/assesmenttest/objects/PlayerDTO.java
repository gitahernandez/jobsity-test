package jobsity.assesmenttest.objects;
import java.io.Serializable;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class PlayerDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name; 
    
    private String PinFallsText;

    public void setPinFallsText(String PinFallsText) {
        this.PinFallsText = PinFallsText;
    }

    public void setScoreText(String scoreText) {
        this.scoreText = scoreText;
    }

    public String getPinFallsText() {
        return PinFallsText;
    }

    public String getScoreText() {
        return scoreText;
    }
    private String scoreText;
  

    public String getName() {
        return name;
    }
    
    public PlayerDTO(String name) {
        this.name = name;
    }
        	
}