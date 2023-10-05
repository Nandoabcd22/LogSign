package com.example.logsign;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logsign.models.PreferenceManager;

public class DashboardActivity3 extends AppCompatActivity {
    ImageView imageView;
    TextView textViewUsername, textViewEmail, textViewNoHp, textViewTanggalLahir, textViewJenisKelamin, textViewAlamat, textViewAgama;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard3);

        imageView = findViewById(R.id.img1);
        textViewUsername = findViewById(R.id.fullNameTextView);
        textViewEmail = findViewById(R.id.emailTextView);
        textViewNoHp = findViewById(R.id.noHpTextView);
        textViewTanggalLahir = findViewById(R.id.tanggalLahirTextView);
        textViewJenisKelamin = findViewById(R.id.jenisKelaminTextView);
        textViewAlamat = findViewById(R.id.alamatTextView);
        textViewAgama = findViewById(R.id.agamaTextView);

        preferenceManager = PreferenceManager.getInstance(this);

        String previouslyEncodedImage = preferenceManager.getString("image_data");

        if (!previouslyEncodedImage.equalsIgnoreCase("")) {
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            imageView.setImageBitmap(bitmap);
        }

        // Mengambil data yang dikirim dari SignupActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            String email = extras.getString("email");
            String nohp = extras.getString("nohp");
            String tanggalLahir = extras.getString("tanggalLahir");
            String jenisKelamin = extras.getString("jenisKelamin");
            String alamat = extras.getString("alamat");
            String agama = extras.getString("agama");

            // Menampilkan data yang diterima di komponen UI
            textViewUsername.setText("Full Name: " + username);
            textViewEmail.setText("Email: " + email);
            textViewNoHp.setText("No HP: " + nohp);
            textViewTanggalLahir.setText("Tanggal Lahir: " + tanggalLahir);
            textViewJenisKelamin.setText("Jenis Kelamin: " + jenisKelamin);
            textViewAlamat.setText("Alamat: " + alamat);
            textViewAgama.setText("Agama: " + agama);
        }
    }
}
