package com.example.chen.dramatic_tickets;


import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MovieDetail extends AppCompatActivity {

    String selectedMovieName = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        TextView mView;
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            selectedMovieName = extras.getString("selectedMovieName");
            mView = (TextView) findViewById(R.id.movie_chinese_name);
            mView.setText(selectedMovieName);
        }

        Button btn = (Button) findViewById(R.id.buyTicketInMovieDetail);
        clickBuyTicket(btn);
    }

    //这里跳转到选择影院界面
    public void clickBuyTicket(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MovieDetail.this, ChooseCinema.class);

                intent.putExtra("MovieName", selectedMovieName);
                MovieDetail.this.startActivity(intent);
            }
        });
    }
}