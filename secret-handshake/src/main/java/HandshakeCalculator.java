import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HandshakeCalculator {
    private final List<Signal> actions = new ArrayList<>();

    public List<Signal> calculateHandshake(int number) {
        if ((0x01 & number) != 0) 
            actions.add(Signal.WINK);
        if ((0x02 & number) != 0) 
            actions.add(Signal.DOUBLE_BLINK) ;
        if ((0x04 & number) != 0) 
            actions.add(Signal.CLOSE_YOUR_EYES);
        if ((0x08 & number) != 0) 
            actions.add(Signal.JUMP);
        if ((0x10 & number) != 0) 
            Collections.reverse(actions);
        return actions;
    }
}
