package jobsity.assesmenttest.objects;

import java.io.Serializable;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class RollDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pinfalls;

    public void setPinfalls(int pinfalls) {
        this.pinfalls = pinfalls;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String type;

    public int getPinfalls() {
        return pinfalls;
    }

    public String getType() {
        return type;
    }

    public RollDTO(int pinfalls, String type) {
        this.pinfalls = pinfalls;
        this.type = type;
    }
}
