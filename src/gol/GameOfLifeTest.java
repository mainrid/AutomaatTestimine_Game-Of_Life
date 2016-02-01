package gol;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class GameOfLifeTest {
	
	@Test
	public void makeCellAliveTest() {
		Frame game= new Frame(5,5);
		game.markAlive(2, 2);
		assertThat(game.isAlive(2, 2), is(true));		
	}

// countCellNeighBoursTest is using below game map:
//	------
//	--XX-- 
//	-X--X- 
//	--XX-- 
//	------	
	
	@Test
	public void countCellNeighbours() {
		Frame gameMap= new Frame(5,6);
		gameMap.markAlive(1, 2);
		gameMap.markAlive(1, 3);
		gameMap.markAlive(2, 1);
		gameMap.markAlive(2, 4);
		gameMap.markAlive(3, 2);
		gameMap.markAlive(3, 3);
		assertThat(gameMap.getNeighbourCount(2, 2), is(5));		
	}
	
	
	@Test
	public void ifCellInMapReturnsTrue() {
		Frame gameMap= new Frame(5,6);
		assertThat(gameMap.cellInMap(5, 6), is(true));		
	}
	
	@Test
	public void ifCellNotInMapReturnsFalse() {
		Frame gameMap= new Frame(5,6);
		assertThat(gameMap.cellInMap(5, 7), is(false));		
	}
	
	@Test
	public void comparingTwoIdenticalGameMapsReturnsTrue() {
		Frame gameMap= new Frame(5,6);
		gameMap.markAlive(1, 2);
		gameMap.markAlive(1, 3);
		gameMap.markAlive(2, 1);
		
		Frame comareToGameMap= new Frame(5,6);
		comareToGameMap.markAlive(1, 2);
		comareToGameMap.markAlive(1, 3);
		comareToGameMap.markAlive(2, 1);
		
		assertThat(gameMap.equals(comareToGameMap), is(true));		
	}
	
	@Test
	public void comparingTwoNotIdenticalGameMapsReturnsFalse() {
		Frame gameMap= new Frame(5,6);
		gameMap.markAlive(2, 2);
		gameMap.markAlive(1, 3);
		gameMap.markAlive(2, 1);
		
		Frame comareToGameMap= new Frame(5,6);
		comareToGameMap.markAlive(1, 2);
		comareToGameMap.markAlive(1, 3);
		comareToGameMap.markAlive(2, 1);
		
		assertThat(gameMap.equals(comareToGameMap), is(false));	
	}
	
	@Test
	public void comparingGameMapWithNullReturnsFalse() {
		Frame gameMap= new Frame(5,6);
		gameMap.markAlive(2, 2);
		gameMap.markAlive(1, 3);
		gameMap.markAlive(2, 1);
		
		assertThat(gameMap.equals(null), is(false));	
	}
	
//	The next gameMap is used for ifNextFrameIsCorrectReturnsTrue() test
//	-X---- --X---
//	--XX-- ---X--
//	-XX--- -XXX--
//	------ ------
	
	@Test
	public void ifNextFrameIsCorrectReturnsTrue() {
		Frame initialMap= new Frame(4,6);
		initialMap.markAlive(0, 1);
		initialMap.markAlive(1, 2);
		initialMap.markAlive(1, 3);
		initialMap.markAlive(2, 1);
		initialMap.markAlive(2, 2);
		
		Frame shouldBeSecondFrame= new Frame(4,6);
		shouldBeSecondFrame.markAlive(0, 2);
		shouldBeSecondFrame.markAlive(1, 3);
		shouldBeSecondFrame.markAlive(2, 1);
		shouldBeSecondFrame.markAlive(2, 2);
		shouldBeSecondFrame.markAlive(2, 3);	
		
		assertThat(initialMap.nextFrame().equals(shouldBeSecondFrame), is(true));	
	}
	
}
