package com.ubs.opsit.interviews.bean;

import com.ubs.opsit.interviews.util.CharArrayUtils;

import static com.ubs.opsit.interviews.util.Constants.*;


/**
 * Representation of a Berlin clock. The Berlin clock has 5 rows:
 * </p>
 *
 * <li>First row means the top lamp is a pump which is blinking on/off every two
 * seconds
 * <li>Second row means 4 red lamps representing 5 hours each
 * <li>Third row means 4 red lamps representing 1 hour each
 * <li>Fourth row means 11 lamps each representing 5 minutes where every third
 * is red and all other are yellow
 * <li>Fifth row - 4 yellow lamps each representing 1 minute
 */
public class BerlinClock {
    private Character second;
    private Character[] firstHoursLine;
    private Character[] secondHoursLine;
    private Character[] firstMinutesLine;
    private Character[] secondMinutesLine;

    public BerlinClock(){
        this.second = YELLOW;
        this.firstHoursLine = new Character[]{RED, RED, RED, RED};
        this.secondHoursLine = new Character[]{RED, RED, RED, RED};
        this.firstMinutesLine = new Character[]{YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW};
        this.secondMinutesLine = new Character[]{YELLOW, YELLOW, YELLOW, YELLOW};
    }

    public Character getSecond() {
        return second;
    }

    public void setSecond(Character second) {
        this.second = second;
    }

    public Character[] getFirstHoursLine() {
        return firstHoursLine;
    }

    public void setFirstHoursLine(Character[] firstHoursLine) {
        this.firstHoursLine = firstHoursLine;
    }

    public Character[] getSecondHoursLine() {
        return secondHoursLine;
    }

    public void setSecondHoursLine(Character[] secondHoursLine) {
        this.secondHoursLine = secondHoursLine;
    }

    public Character[] getFirstMinutesLine() {
        return firstMinutesLine;
    }

    public void setFirstMinutesLine(Character[] firstMinutesLine) {
        this.firstMinutesLine = firstMinutesLine;
    }

    public Character[] getSecondMinutesLine() {
        return secondMinutesLine;
    }

    public void setSecondMinutesLine(Character[] secondMinutesLine) {
        this.secondMinutesLine = secondMinutesLine;
    }

    @Override
    public String toString() {
        StringBuilder builder  = new StringBuilder();
        builder.append(this.getSecond()).append(NEW_LINE)
                .append(CharArrayUtils.toString(this.getFirstHoursLine())).append(NEW_LINE)
                .append(CharArrayUtils.toString(this.getSecondHoursLine())).append(NEW_LINE)
                .append(CharArrayUtils.toString(this.getFirstMinutesLine())).append(NEW_LINE)
                .append(CharArrayUtils.toString(this.getSecondMinutesLine()));
        return builder.toString();
    }
}
