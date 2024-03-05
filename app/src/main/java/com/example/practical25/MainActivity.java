package com.example.practical25;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private float currentRotation = 0;
    private float currentScale = 1.0f;
    private float currentAlpha = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_rotate_clockwise) {
            rotateImageClockwise();
            return true;
        } else if (itemId == R.id.action_rotate_anticlockwise) {
            rotateImageAntiClockwise();
            return true;
        } else if (itemId == R.id.action_zoom_in) {
            zoomInImage();
            return true;
        } else if (itemId == R.id.action_zoom_out) {
            zoomOutImage();
            return true;
        } else if (itemId == R.id.action_fade_in) {
            fadeInImage();
            return true;
        } else if (itemId == R.id.action_fade_out) {
            fadeOutImage();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }




    private void rotateImageClockwise() {
        currentRotation += 90;
        imageView.setRotation(currentRotation);
        Toast.makeText(this, "Rotated Clockwise", Toast.LENGTH_SHORT).show();
    }

    private void rotateImageAntiClockwise() {
        currentRotation -= 90;
        imageView.setRotation(currentRotation);
        Toast.makeText(this, "Rotated Anti-clockwise", Toast.LENGTH_SHORT).show();
    }

    private void zoomInImage() {
        currentScale += 0.1f;
        imageView.setScaleX(currentScale);
        imageView.setScaleY(currentScale);
        Toast.makeText(this, "Zoomed In", Toast.LENGTH_SHORT).show();
    }

    private void zoomOutImage() {
        currentScale -= 0.1f;
        imageView.setScaleX(currentScale);
        imageView.setScaleY(currentScale);
        Toast.makeText(this, "Zoomed Out", Toast.LENGTH_SHORT).show();
    }

    private void fadeInImage() {
        currentAlpha += 0.1f;
        imageView.setAlpha(currentAlpha);
        Toast.makeText(this, "Faded In", Toast.LENGTH_SHORT).show();
    }

    private void fadeOutImage() {
        currentAlpha -= 0.1f;
        imageView.setAlpha(currentAlpha);
        Toast.makeText(this, "Faded Out", Toast.LENGTH_SHORT).show();
    }
}
