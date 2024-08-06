package com.example.tetris;

import android.content.Context;
import android.view.View;

public class FourBlocksDrawer {
  private BlocksDisplay display;

  public FourBlocksDrawer(Context context, BlocksDisplay display) {
    if (display instanceof NextBlocksDisplay) {
      this.display = (NextBlocksDisplay) display;
    } else if (display instanceof GameDisplay) {
      this.display = (GameDisplay) display;
    }
  }

  public void draw(FourBlocksTemplate blockTemplate) {
    int[][] shape = blockTemplate.getShape();
    int color = blockTemplate.getColor();
    int top = blockTemplate.getTop();
    int left = blockTemplate.getLeft();
    for (int i = 0; i < shape.length; i++) {
      for (int j = 0; j < shape[i].length; j++) {
        if (shape[i][j] == 1) {
          display.setBlockCoordinates(color, top + i, left + j);
        }
      }
    }
  }
}
