package com.example.tetris;


public class FourBlocksTemplate {
  private int[][] shape; // ブロックの形状を2D配列で表現
  private int color; // ブロックの色
  private int top; // ブロックの位置
  private int left; // ブロックの位置

  public FourBlocksTemplate(int[][] shape, int color, int top, int left) {
    this.shape = shape;
    this.color = color;
    this.top = top;
    this.left = left;
  }

  public int[][] getShape() {
    return shape;
  }

  public void setShape(int[][] shape) {
    this.shape = shape;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public int getTop() {
    return top;
  }

  public void setTop(int top) {
    this.top = top;
  }

  public int getLeft() {
    return left;
  }

  public void setLeft(int left) {
    this.left = left;
  }
}
