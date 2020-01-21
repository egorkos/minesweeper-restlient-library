package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cell {
    private boolean mine;
    private boolean revealed;
    private boolean flagged;
    @JsonProperty("mines_around")
    private Integer minesAround;

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public Integer isMinesAround() {
        return minesAround;
    }

    public void setMinesAround(Integer minesAround) {
        this.minesAround = minesAround;
    }
}
