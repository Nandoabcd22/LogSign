package com.example.logsign;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logsign.adapter.MahasiswaAdapter;
import com.example.logsign.models.Mahasiswa;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_home, container, false);

        addData();

        recyclerView = root.findViewById(R.id.recycle_view);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return root;
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