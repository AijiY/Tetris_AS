package com.example.tetris;

public class NextBlocks {
  private FourBlocksTemplate blockTemplate;

  public NextBlocks(FourBlocksTemplate blockTemplate) {
    this.blockTemplate = blockTemplate;
  }

  public FourBlocksTemplate getBlockTemplate() {
    return blockTemplate;
  }

  public void setBlockTemplate(FourBlocksTemplate blockTemplate) {
    this.blockTemplate = blockTemplate;
  }
}
