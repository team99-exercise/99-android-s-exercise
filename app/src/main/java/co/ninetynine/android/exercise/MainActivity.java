package co.ninetynine.android.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Timber.plant(new Timber.DebugTree());
    setContentView(R.layout.activity_main);
  }
}
