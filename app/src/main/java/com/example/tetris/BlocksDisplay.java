package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BlocksDisplay extends View {

  private float blockSize;
  private Paint paint = new Paint();
  private float leftDp, topDp, rightDp, bottomDp;

  public BlocksDisplay(Context context, AttributeSet attrs) {
    super(context, attrs);
    blockSize = context.getResources().getDimension(R.dimen.block_size);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawRect(leftDp, topDp, rightDp, bottomDp, paint);
  }

  public void setBlockCoordinates(int color, int top, int left) {
    paint.setColor(color);
    this.topDp = top * blockSize;
    this.leftDp = left * blockSize;
    this.bottomDp = (top + 1) * blockSize;
    this.rightDp = (left + 1) + blockSize;
    invalidate();
  }
}
