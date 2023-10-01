package com.example.logsign;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsign.adapter.MahasiswaAdapter;
import com.example.logsign.models.Mahasiswa;
import com.example.logsign.adapter.MahasiswaAdapter;
import com.example.logsign.models.Mahasiswa;

import java.util.ArrayList;

public class recycleViewActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private MahasiswaAdapter adapter;
private ArrayList<Mahasiswa> mahasiswaArrayList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycle_view);
    getSupportActionBar().setTitle("Recycle View");

    addData();

    recyclerView = findViewById(R.id.recycle_view);
    adapter = new MahasiswaAdapter(mahasiswaArrayList);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recycleViewActivity.this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
}
void addData(){
    mahasiswaArrayList = new ArrayList<>();
    mahasiswaArrayList.add(new Mahasiswa("Fajar", "E41220021", "081334394400"));
    mahasiswaArrayList.add(new Mahasiswa("Setia Nanda", "E41229922", "081337787765"));
    mahasiswaArrayList.add(new Mahasiswa("Mutiara", "E4122212", "081098778472"));
    mahasiswaArrayList.add(new Mahasiswa("Iconiy", "E41224354", "081748938562"));
    mahasiswaArrayList.add(new Mahasiswa("Firzy", "E41220021", "081334394400"));
    mahasiswaArrayList.add(new Mahasiswa("Afriyan", "E41229922", "081337787765"));
    mahasiswaArrayList.add(new Mahasiswa("Seto", "E4122212", "081098778472"));
    mahasiswaArrayList.add(new Mahasiswa("Sindi", "E41224354", "081748938562"));
    mahasiswaArrayList.add(new Mahasiswa("Pego", "E41220021", "081334394400"));
    mahasiswaArrayList.add(new Mahasiswa("Lose", "E41229922", "081337787765"));
    mahasiswaArrayList.add(new Mahasiswa("Winginanom", "E4122212", "081098778472"));
    mahasiswaArrayList.add(new Mahasiswa("Pending", "E41224354", "081748938562"));
    mahasiswaArrayList.add(new Mahasiswa("Banting", "E41224354", "081748938562"));
    mahasiswaArrayList.add(new Mahasiswa("Pebri", "E41224354", "081748938562"));
    mahasiswaArrayList.add(new Mahasiswa("Petal", "E41224354", "081748938562"));
    mahasiswaArrayList.add(new Mahasiswa("Landro", "E41224354", "081748938562"));
}
}