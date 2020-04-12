package jobsity.assesmenttest.interfaces;

import java.util.ArrayList;
import java.util.stream.Stream;

import jobsity.assesmenttest.objects.BoardDTO;
import jobsity.assesmenttest.objects.FrameDTO;
import jobsity.assesmenttest.objects.PlayerDTO;

/**
 *
 * @author andresfelipehernandezrocha
 */
public interface Scoring {
    
    public void printScore(ArrayList<PlayerDTO> playerDTOList);
    
    public boolean validateInput(Stream<String> stream);
    
    public BoardDTO convertInputInGameInformation(Stream<String> stream);
    
    public ArrayList<PlayerDTO> calculateScoreByPlayer(ArrayList<PlayerDTO> playerDTOList, ArrayList<FrameDTO> frameDTOList);
}
