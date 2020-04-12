package jobsity.assesmenttest.objects;

import java.io.Serializable;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class FrameDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int number;
    private PlayerDTO playerDTO;
    private RollDTO firstRollDTO;
    private RollDTO secondRollDTO;
    private int score;
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

    public FrameDTO(int number, PlayerDTO playerDTO, int pinsFall) {
        this.number = number;
        this.playerDTO = playerDTO;
      
        
        String firstRollType, secondRollType;
   
        if (pinsFall == 10) {
            firstRollType = "STRIKE";
            secondRollType = "NONEED";
          
        } else {
            firstRollType = "NORMAL";
            secondRollType = "PENDING";
        
        }
        
        this.PinFallsText = "";
        this.scoreText = "";
        this.firstRollDTO = new RollDTO(pinsFall, firstRollType);
        this.secondRollDTO = new RollDTO(0, secondRollType);


    }

    public FrameDTO(int number, PlayerDTO playerDTO, RollDTO firstRollDTO, RollDTO secondRollDTO) {
        this.number = number;
        this.playerDTO = playerDTO;

        this.firstRollDTO = firstRollDTO;
        this.secondRollDTO = secondRollDTO;

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPlayerDTO(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }

    public void setFirstRollDTO(RollDTO firstRollDTO) {
        this.firstRollDTO = firstRollDTO;
    }

    public void setSecondRollDTO(RollDTO secondRollDTO) {
        this.secondRollDTO = secondRollDTO;
    }

    public int getNumber() {
        return number;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }

    public RollDTO getFirstRollDTO() {
        return firstRollDTO;
    }

    public RollDTO getSecondRollDTO() {
        return secondRollDTO;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
