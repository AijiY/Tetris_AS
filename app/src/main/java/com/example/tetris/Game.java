package com.example.tetris;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.content.Context;
import java.util.Timer;

public class Game {
  int timeInterval;
  private NextBlocksDisplay nextBlocksDisplay;
  private GameDisplay gameDisplay;
  private FourBlocksFactory fourBlocksFactory;
  private FourBlocksDrawer fourBlocksDrawerOnNextBlockDisplay;
  private FourBlocksDrawer fourBlocksDrawerOnGameDisplay;

  public Game(Activity activity, Context context, int timeInterval) {
//    timeInterval
    this.timeInterval = timeInterval;

//    constructor
    nextBlocksDisplay = (NextBlocksDisplay) activity.findViewById(R.id.nextBlocksDisplay);
    gameDisplay = (GameDisplay) activity.findViewById(R.id.gameDisplay);
    fourBlocksFactory = new FourBlocksFactory();
    fourBlocksDrawerOnNextBlockDisplay = new FourBlocksDrawer(context, nextBlocksDisplay);
    fourBlocksDrawerOnGameDisplay = new FourBlocksDrawer(context, gameDisplay);

  }

  public void makeFirstTwoBlocks() {
    //    first two blocks
    NextBlocks nextBlocks = fourBlocksFactory.createRandomNextBlocks();
//    convert
//    draw in game display
    fourBlocksDrawerOnNextBlockDisplay.draw(nextBlocks.getBlockTemplate());
  }

  public void startGame() {


//    timer start
    Timer timer = new Timer(timeInterval, new TimerListener());
    timer.start();
  }
}
