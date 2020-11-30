package com.example.edittext;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FilmActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText edit_text;
    private Button btn;
    private ListView itemsList;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        edit_text = findViewById(R.id.edit_text_film);
        btn = findViewById(R.id.btn_add_film);
        itemsList = findViewById(R.id.list_view_film);

        items = FileHelper.readDataFilm(this);

        adapter = new ArrayAdapter<String>(this, R.layout.list_view_layout, items);
        itemsList.setAdapter(adapter);

        btn.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Список фильмов");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_film:
                String itemEntered = edit_text.getText().toString();
                if (!(itemEntered.equals(""))) {
                    adapter.add(itemEntered);
                    edit_text.setText("");
                    FileHelper.writeDataFilm(items, this);
                    Toast.makeText(this, "Добавлен элемент в список", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    Toast.makeText(this, "Напишите текст", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelper.writeDataFilm(items, this);
        Toast.makeText(this, "Вы удалили элемент списка", Toast.LENGTH_SHORT).show();
    }
    //Кнопка
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
