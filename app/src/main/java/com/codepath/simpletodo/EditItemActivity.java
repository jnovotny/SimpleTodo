package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Edit Item Below");
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String name = getIntent().getStringExtra("name");
        position = getIntent().getExtras().getInt("position");
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText(name);
        editText.setSelection(editText.getText().length());
    }

    public void onSaveEditItem(View view) {
        EditText editText = (EditText)findViewById(R.id.editText);
        String name = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name", name);
        intent.putExtra("position", position);
        setResult(RESULT_OK, intent);
        finish();
    }
}
