package com.example.logsign;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.logsign.models.PreferenceManager;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgbtn;
    Button button, takepicture;
    PreferenceManager preferenceManager;
    Intent camera;
    private DatePickerDialog datePickerDialog;
    private EditText dateOfBirthEditText;
    private EditText editTextAlamat; // Tambahkan ini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        imgbtn = findViewById(R.id.imageview);
        button = findViewById(R.id.signup_button);
        takepicture = findViewById(R.id.clickpicture);
        dateOfBirthEditText = findViewById(R.id.tanggalLahirPicker);
        editTextAlamat = findViewById(R.id.edtiAlamat); // Tambahkan ini
        preferenceManager = PreferenceManager.getInstance(this);
        button.setOnClickListener(this);
        takepicture.setOnClickListener(this);

        // Tambahkan OnClickListener ke EditText tanggalLahirPicker
        dateOfBirthEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.clickpicture) {
            imgmethod();
        } else if (view.getId() == R.id.signup_button) {
            // Mengambil nilai dari semua EditText
            EditText editTextName = findViewById(R.id.editTextName);
            EditText editTextEmail = findViewById(R.id.signup_email);
            EditText editTextNoHp = findViewById(R.id.signup_nohp);

            // Mengambil nilai dari RadioGroup untuk jenis kelamin
            RadioGroup radioGroupJenisKelamin = findViewById(R.id.radioGroup);
            int selectedId = radioGroupJenisKelamin.getCheckedRadioButtonId();
            RadioButton radioButtonJenisKelamin = findViewById(selectedId);
            String jenisKelamin = radioButtonJenisKelamin.getText().toString();

            // Mengambil nilai dari RadioGroup untuk agama
            RadioGroup radioGroupAgama = findViewById(R.id.radioGroupAgama);
            int selectedAgamaId = radioGroupAgama.getCheckedRadioButtonId();
            RadioButton radioButtonAgama = findViewById(selectedAgamaId);
            String agama = radioButtonAgama.getText().toString();

            // Membuat Intent
            Intent intent = new Intent(this, DashboardActivity3.class);

            // Menambahkan semua data ke Intent
            intent.putExtra("username", editTextName.getText().toString());
            intent.putExtra("email", editTextEmail.getText().toString());
            intent.putExtra("nohp", editTextNoHp.getText().toString());
            intent.putExtra("tanggalLahir", dateOfBirthEditText.getText().toString());
            intent.putExtra("jenisKelamin", jenisKelamin);
            intent.putExtra("alamat", editTextAlamat.getText().toString()); // Tambahkan ini
            intent.putExtra("agama", agama);

            // Memulai DashboardActivity3
            startActivity(intent);
            finish();
        }
    }

    private void imgmethod() {
        if ((ActivityCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        Manifest.permission.CAMERA,
                }, 123);
            }
        } else {
            camera = new Intent();
            camera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(camera, 118);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 118 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgbtn.setImageBitmap(photo);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();
            String encodedImage = android.util.Base64.encodeToString(b, android.util.Base64.DEFAULT);
            preferenceManager.setString("image_data", encodedImage);
            Toast.makeText(this, "Image saved in SharedPreferences", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Could not capture", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Izin diberikan, lanjutkan dengan pengambilan gambar
                camera = new Intent();
                camera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, 118);
            } else {
                // Izin ditolak, beri tahu pengguna
                Toast.makeText(this, "Permission denied. Cannot take a picture.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showDatePicker() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        dateOfBirthEditText.setText(selectedDate);
                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.show();
    }
}
