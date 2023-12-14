import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BowlingGame {
    private int score = 0;
    private int frame = 1;
    private List<Integer> frameRolls = new ArrayList<>();
    private List<Integer> pending = new ArrayList<>();

    private final static String ERR_NEGATIVE = 
        "Negative roll is invalid";
    private final static String ERR_PINS_OUT_OF_RANGE = 
        "Pin count exceeds pins on the lane";
    private final static String ERR_ROLL_AFTER_END = 
        "Cannot roll after game is over";
    private final static String ERR_SCORE_BEFORE_END =
        "Score cannot be taken until the end of the game";

    void roll(int pins) {
        if (gameOver()) throw new IllegalStateException(ERR_ROLL_AFTER_END);
        if (pins < 0) throw new IllegalStateException(ERR_NEGATIVE);
        if (pinsStanding(pins)) throw new IllegalStateException(ERR_PINS_OUT_OF_RANGE);
        addRoll(pins);
        updateFrame(pins);
    }

    int score() {
        if (!gameOver()) throw new IllegalStateException(ERR_SCORE_BEFORE_END);
        return score;
    }

    private boolean gameOver() {
        return frame > 10;
    }

    private boolean tenthFrame() {
        return frame == 10;
    }

    private boolean pinsStanding(int roll) {
        if (roll > 10) return true;
        if (frameRolls.isEmpty()) return false;
        if (tenthFrame()) return pinsStandingTenth(roll);
        return frameRolls.get(0) + roll > 10;
    }

    private boolean pinsStandingTenth(int roll) {
        List<Integer> notStrikes = frameRolls.stream()
                                             .filter(x -> x < 10)
                                             .collect(Collectors.toList());
        if (notStrikes.isEmpty()) return false;
        if (notStrikes.size() == 1) return notStrikes.get(0) + roll > 10;
        return notStrikes.stream().mapToInt(Integer::intValue).sum() != 10;
    }

    private void updateFrame(int roll) {
        if (tenthFrame()) {
            frameRolls.add(roll);
            int sumFrameRolls = 
                frameRolls.stream().mapToInt(Integer::intValue).sum();
            if ((frameRolls.size() == 2 && sumFrameRolls < 10) || 
                frameRolls.size() == 3) 
                    frame++;
        }
        else {
            if (roll == 10) {
                frame++;
                pending.add(2);
            }
            else if (frameRolls.isEmpty()) {
                frameRolls.add(roll);
            }
            else {
                if (frameRolls.get(0) + roll == 10) 
                    pending.add(1);
                frame++;
                frameRolls = new ArrayList<>();
            }

        }
    }

    private void addRoll(int pins) {
        score += pins;
        pending = pending.stream().peek(x -> score += pins)
                         .map(x -> x - 1).filter(x -> x > 0)
                         .collect(Collectors.toList());
    }
}