package com.example.tetris;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_game);
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });



    // Intentから難易度を取得
    Intent intent = getIntent();
    int difficulty = intent.getIntExtra("difficulty", 2);
    setupGame(difficulty);

    startResetButton.setOnClickListener(v -> startOrResetGame());
    exitButton.setOnClickListener(v -> finish());
  }

  Button startResetButton = findViewById(R.id.startResetButton);
  Button exitButton = findViewById(R.id.exitButton);

  int timeInterval; // ミリsecond
  boolean isPlaying = false;
  Game game = new Game(this, timeInterval);

  private void setupGame(int difficulty) {
    // 難易度に応じてゲームを初期化
    switch (difficulty) {
      case 1:
        // 簡単
        timeInterval = 2000;
        break;
      case 2:
        // 普通
        timeInterval = 1000;
        break;
      case 3:
        // 難しい
        timeInterval = 500;
        break;
    }
  }

  private void startOrResetGame() {
    if (!isPlaying) {
      // ゲームをスタート
      isPlaying = true;
//      startResetButton.setText(getString(R.string.reset));
      game.startGame();
    } else {
      // ゲームをリセット
      isPlaying = false;
//      startResetButton.setText(getString(R.string.start));
      game.resetGame();
    }
  }

}