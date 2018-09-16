import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class HandshakeCalculator {

    private final List<Signal> actions = new ArrayList<>();

    public List<Signal> calculateHandshake(int number) {

        if ((0b00001 & number) != 0) actions.add(Signal.WINK);
        if ((0b00010 & number) != 0) actions.add(Signal.DOUBLE_BLINK) ;
        if ((0b00100 & number) != 0) actions.add(Signal.CLOSE_YOUR_EYES);
        if ((0b01000 & number) != 0) actions.add(Signal.JUMP);
        if ((0b10000 & number) != 0) Collections.reverse(actions);
        
        return actions;
    }
}
