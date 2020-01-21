package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Game {
    private Integer id;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("finish_time")
    private String finishTime;
    private Integer rows;
    private Integer cols;
    private Integer mines;
    @JsonProperty("cells_revealed")
    private Integer cellsRevealed;
    @JsonProperty("game_status")
    private Integer gameStatus;
    private Cell[][] grid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public Integer getMines() {
        return mines;
    }

    public void setMines(Integer mines) {
        this.mines = mines;
    }

    public Integer getCellsRevealed() {
        return cellsRevealed;
    }

    public void setCellsRevealed(Integer cellsRevealed) {
        this.cellsRevealed = cellsRevealed;
    }

    public Integer getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Integer gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}
