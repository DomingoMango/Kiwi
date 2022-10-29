package com.example.kiwis;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
        private Queue queue;
        private EditText etIdent;
        private Button btnAdd,btnRemove,btnPrint;
        private TextView tvAll;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etIdent=findViewById(R.id.etIdent);
            btnAdd=findViewById(R.id.btnAdd);
            btnPrint=findViewById(R.id.btnPrint);
            btnRemove=findViewById(R.id.btnRemove);
            tvAll=findViewById(R.id.tvAll);
            queue = new Queue();
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int input =Integer.parseInt(etIdent.getText().toString().trim());
                    queue.add(input);
                    etIdent.setText("");
                }
            });
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvAll.setText(queue.remove() + " Ha sido atendido");
                }
            });
            btnPrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvAll.setText("Los que estan son: " + queue.print());
                }
            });
        }
    }