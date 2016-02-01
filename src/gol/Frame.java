package gol;

import java.util.Arrays;

public class Frame {

	private boolean[][] gameMap;
	private int width;
	private int height;

	public Frame(int height, int width) {
		this.gameMap = new boolean[height][width];
		this.width = width;
		this.height = height;
	}

	public Frame(boolean[][] gameMap) {
		this(gameMap.length, gameMap[0].length);
		this.gameMap = gameMap;
	}

	@Override
	public String toString() {
		String kaart = "";
		// tagastab stringi, mis kujutab kaadri sisu.
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.gameMap[i][j]) {
					kaart += "X";
				} else {
					kaart += "-";
				}
			}
			kaart += "\n";
		}

		return kaart;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Frame)) {
			return false;
		}

		Frame nextMap = (Frame) obj;
		boolean check = Arrays.deepEquals(this.gameMap, nextMap.getGameMap());
		return check;
	}

	public boolean[][] getGameMap() {
		return this.gameMap;
	}

	public int getNeighbourCount(int x, int y) {

		// Tagastab raku kordinaatidega X ja Y naabrite arvu.
		// Võimalikud väärtused on 0-8

		int count = 0;
		if (cellInMap(x, y)) {
			int minRow = x == 0 ? 0 : x - 1;
			int maxRow = x == (this.height - 1) ? (this.height - 1) : x + 1;

			int minCol = y == 0 ? 0 : y - 1;
			int maxCol = y == (this.width - 1) ? (this.width - 1) : y + 1;

			for (int row_idx = minRow; row_idx <= maxRow; row_idx++) {
				for (int col_idx = minCol; col_idx <= maxCol; col_idx++) {
					if (this.gameMap[row_idx][col_idx] && !(row_idx == x && col_idx == y)) {
						count++;
					}
				}
			}
		}

		return count;
	}

	public boolean isAlive(int x, int y) {

		// Tõene, kui rakk kordinaatidega X ja Y on elus.
		if (cellInMap(x, y)) {
			return this.gameMap[x][y];
		}
		return false;
	}

	public boolean cellInMap(int x, int y) {
		return (x >= 0 && x <= this.height) && (y >= 0 && y <= this.width);

	}

	public void markAlive(int x, int y) {
		if (cellInMap(x, y)) {
			this.gameMap[x][y] = true;
		}
	}

	private boolean nextCellState(int x, int y) {
		int count = getNeighbourCount(x, y);
		if (count < 2) {
			return false;
		} else if (count < 3) {
			return this.isAlive(x, y);
		} else if (count == 3) {
			return true;
		} else {
			return false;
		}
	}

	public Frame nextFrame() {

		// Tagastab järgmise kaadri.

		// Looge uus, eelmisega sama suurusega, puhas kaader
		// Arvutage vana kaadri pealt iga raku järgmine seisund
		// (arvestades naabrite hulka) ja märkige see seis uude kaadrisse.
		// Tagastage uus kaader.

		boolean nextFrame[][] = new boolean[this.height][this.width];

		for (int x = 0; x < this.height; x++) {
			for (int y = 0; y < this.width; y++) {
				nextFrame[x][y] = this.nextCellState(x, y);
			}
		}
		return new Frame(nextFrame);
	}
}