package jobsity.assesmenttest.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class BoardDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<FrameDTO> frames;
    private ArrayList<PlayerDTO> players;

    public ArrayList<FrameDTO> getFrames() {
        return frames;
    }

    public ArrayList<PlayerDTO> getPlayers() {
        return players;
    }

    public void setFrames(ArrayList<FrameDTO> frames) {
        this.frames = frames;
    }

    public void setPlayers(ArrayList<PlayerDTO> players) {
        this.players = players;
    }
}
