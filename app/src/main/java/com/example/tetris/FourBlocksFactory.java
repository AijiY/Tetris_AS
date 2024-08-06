package com.example.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FourBlocksFactory {
  private final List<FourBlocksTemplate> templates;

  public FourBlocksFactory() {
    templates = new ArrayList<>();
    initializeTemplates();
  }

  private void initializeTemplates() {
    // ブロックテンプレートを初期化
    templates.add(new FourBlocksTemplate(new int[][]{
        {1, 1, 1, 1},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    }, 0x00FF00,
        0, 0)); // 緑色

    // 赤色
    templates.add(new FourBlocksTemplate(new int[][]{
        {1, 1, 1, 1},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    }, 0xFF0000,
        0, 0)); // 赤色

    // オレンジ色
    templates.add(new FourBlocksTemplate(new int[][]{
        {0, 1, 1, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    }, 0xFFA500,
        0, 0)); // オレンジ色

    // 青色
    templates.add(new FourBlocksTemplate(new int[][]{
        {1, 1, 0, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    }, 0x0000FF,
        0, 0)); // 青色

    // シアン色
    templates.add(new FourBlocksTemplate(new int[][]{
        {1, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    }, 0x00FFFF,
        0, 0)); // シアン色

    // マゼンタ色
    templates.add(new FourBlocksTemplate(new int[][]{
        {1, 1, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    }, 0xFF00FF,
        0, 0)); // マゼンタ色
  }

  public NextBlocks createRandomNextBlocks() {
    Random random = new Random();
    FourBlocksTemplate randomTemplate = templates.get(random.nextInt(templates.size()));
    return new NextBlocks(randomTemplate);
  }
}
