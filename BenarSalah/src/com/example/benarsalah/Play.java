package com.example.benarsalah;

import java.util.List;

import com.example.benarsalah.Soal;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
 
public class Play extends Activity{
 
	private TextView txtnama, txtno, txttanggal, txtwaktu, txtsoal;
    //private ImageView img;
    private RadioGroup rg;
    private RadioButton rdA, rdB, rdC;
 
    private int detik = 120000; // --> 10 menit
    private Button btnPrev, btnNext, btnSelesai;
    int jawabanYgDiPilih[] = null;
    int jawabanYgBenar[] = null;
    boolean cekPertanyaan = false;
    int urutanPertanyaan = 0;
    String noSalah = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
 
        TextView txtChild = (TextView)findViewById(R.id.child_txtPage);
        Button go = (Button)findViewById(R.id.child_btnPage);
 
        Button go1 = (Button)findViewById(R.id.button1);
		 
        go1.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Play.this, Play1.class);
                i.putExtra("pesan", "From Activity Main");
                startActivity(i);
            }
        });
        //menerima Intent yang dikirim
        Intent i = this.getIntent();
        txtChild.setText("This is child "+i.getStringExtra("pesan"));
 
        go.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
 
}