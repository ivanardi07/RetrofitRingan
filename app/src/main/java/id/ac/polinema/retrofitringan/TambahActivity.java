package id.ac.polinema.retrofitringan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TambahActivity extends AppCompatActivity {
    EditText etNim, etNama, etAlamat, etNoTelp;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_activity);

        Button btn = findViewById(R.id.tambah);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNim = findViewById(R.id.etNim);
                etNama = findViewById(R.id.etNama);
                etAlamat = findViewById(R.id.etAlamat);
                etNoTelp = findViewById(R.id.etNoTelp);
                radioGroup = findViewById(R.id.radioGroupJk);

                String nim = etNim.getText().toString();
                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();
                RadioButton selected = findViewById(radioGroup.getCheckedRadioButtonId());
                String jenis_kelamin = selected.getText().toString();
                String no_telp = etNoTelp.getText().toString();

                if (TextUtils.isEmpty(nim) || TextUtils.isEmpty(nama) || TextUtils.isEmpty(alamat) || TextUtils.isEmpty(jenis_kelamin)
                 || TextUtils.isEmpty(no_telp)){
                    Toast.makeText(getApplicationContext(), "Lengkapi Seluruh Data", Toast.LENGTH_LONG).show();
                } else {
                    Post post = new Post(nim, nama, alamat, jenis_kelamin, no_telp);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://192.168.43.233:8080/api/siswa/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
                    Call<ResponseBody> call = jsonPlaceHolderApi.createPost(post);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Berhasil Menambahkan Data", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Auth Failed", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });
    }
}
