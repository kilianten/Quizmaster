package thequizmaster.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import thequizmaster.Constants;
import thequizmaster.gamestates.MainGame;
import thequizmaster.objects.traps.StartButton;
import thequizmaster.objects.traps.TripWire;
import thequizmaster.quizmode.ChainGame;
import thequizmaster.quizmode.MainEvent;
import thequizmaster.quizmode.SawChallenge;

public class SpawnLevel extends Level {

	public SpawnLevel(String path, MainGame game) {
		super(path, game);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0,0, w, h, tiles, 0, w);
			findRooms();
			alterMap(w, h);
			game.quiz = findRandomMainEvent();
			populateRemainingRooms();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception: Could not load level file at " + path);
		}
	}

	private void populateRemainingRooms() {
		for(Room room: rooms){
			if(!room.isUsed){
				ArrayList<String> gamemodes = (ArrayList)Constants.GAMEMODES.clone();
				boolean eventFound = false;
				while(gamemodes.size() > 0 && eventFound == false){
					int randomGameModeIndex = random.nextInt(gamemodes.size());
					if(getGamemodeForRoom(gamemodes.get(randomGameModeIndex), room)){
						eventFound = true;
					} else {
						gamemodes.remove(randomGameModeIndex);
					}
				}
				if(eventFound == false){
					System.out.println("ERROR: Room could not be populated, dimensions: " + room.width + " * " + room.height);
				}
			}
		}
	}

	private MainEvent createMainEvent(String gamemode){
		Room room;
		switch(gamemode) {
			case "ChainGame":
				room = ChainGame.isSuitableRoomAvailable(rooms, ChainGame.minWidth, ChainGame.minHeight);
				if(room != null){
					room.isUsed = true;
					return new ChainGame(game.key, room, game);
				}
			default:
				return null;
		}
	}

	private boolean getGamemodeForRoom(String gamemode, Room room){
		switch(gamemode) {
			case "ChainGame":
				if(ChainGame.isRoomSuitable(room, ChainGame.minWidth, ChainGame.minHeight)){
					room.isUsed = true;
					room.event = "ChainGame";
					StartButton button = new StartButton( room, game, this);
					room.button = button;
					return true;
				}
			case "SawDifficulty":
				if(SawChallenge.isRoomSuitable(room, SawChallenge.minWidth, SawChallenge.minHeight)){
					room.isUsed = true;
					room.event = "SawDifficulty";
					StartButton button = new StartButton(room, game, this);
					room.button = button;
					return true;
				}
			default:
				return false;
		}
	}

	private MainEvent findRandomMainEvent() {
		ArrayList<String> gamemodes = (ArrayList)Constants.MAINEVENTGAMEMODES.clone();
		MainEvent event = null;
		while(gamemodes.size() > 0 && event == null){
			int randomGameModeIndex = random.nextInt(gamemodes.size());
			event = createMainEvent(gamemodes.get(randomGameModeIndex));
			gamemodes.remove(randomGameModeIndex);
			for(String gamemode: gamemodes){
				System.out.println(gamemode);
			}
		}
		if(event == null){
			System.out.println("ERROR: No Gamemode Could be Created. No rooms available that met specifications");
			System.exit(0);
		}
		return event;
	}

	private void findRooms() {
		for(int i = 0; i < tiles.length; i++) {
			if(isTopLeftCornerTile(i)) {
				int roomWidth = findRoomWidth(i);
				int roomHeight = findRoomHeight(i);
				if(isRoom(i, roomWidth, roomHeight)){
					rooms.add(new Room(i % width, i / width, roomWidth, roomHeight));
				}
			}
		}
	}

	public boolean isRoom(int index, int roomWidth, int height){
		if(roomWidth < 3 || height < 3) return false;
		int topRightCorner = index + roomWidth;
		for(int i = index; i < topRightCorner; i++){
			for(int h = 0; h < height; h++) {
				if(tiles[i + h * width] != 0XFFA4A4A7){
					return false;
				}
			}
		}
		return true;
	}

	public int findRoomHeight(int i){
		i++;
		int counter = 0;
		while(i / width < height && tiles[i] == 0XFFA4A4A7){
			i+= width;
			counter++;
		}
		return counter;
	}

	public int findRoomWidth(int i){
		i++;
		int counter = 0;
		while(i % width != 0 && tiles[i] == 0XFFA4A4A7){
			i++;
			counter++;
		}
		return counter + 1;
	}

	public boolean isTopLeftCornerTile(int i){
		return tiles[i] == 0XFFA4A4A7 && tiles[i - 1] == 0XFFb34949 && tiles[i - width] == 0XFFb34949;
	}
	
	private void findMainRoom() {

	}

	private void alterMap(int width, int h) {
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i] == 0XFFA4A4A7) {
				int randomTile = random.nextInt(400);
				if(randomTile <= 350) continue;
				else if(randomTile == 351) tiles[i] = 1;
				else if(randomTile <= 355) tiles[i] = 7;
				else if(randomTile <= 360) tiles[i] = 8;
				else if(randomTile <= 365) tiles[i] = 9;
				else if(randomTile <= 370) tiles[i] = 5;
				else if(randomTile <= 375) tiles[i] = 6;
				else if(randomTile <= 380) tiles[i] = 4;
				else if(randomTile <= 390) tiles[i] = 3;
				else if(randomTile <= 400) tiles[i] = 2;
			}
			if(tiles[i] == 0XFFb34949 || tiles[i] == 0XFF7b3a3a) {
				if(tiles[i - width] == 0Xff000000) {
					tiles[i - width] = 0XFFb34949;
				}
				if(tiles[i + width] == 0XFFA4A4A7 && tiles[i + width * 2] == 0XFFA4A4A7 && tiles[i + width * 3] == 0XFFb34949) {
					int chanceOfSpawingWire = random.nextInt(Constants.CHANCE_OF_SPAWNING_TRIPWIRE);
					if(chanceOfSpawingWire == 0) {
						TripWire trip = new TripWire(i % width * 32, i / width * 32 + 30);
						game.addAlwaysDrawOver(trip);
						addCollidableObject(trip);
					}
				}
			}
		}
	}

	protected void generateLevel() {
		
	}
	
}
