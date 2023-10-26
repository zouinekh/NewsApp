package mpdam.p1.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class newsDetails extends AppCompatActivity {
    ImageView image;
    Button sharButton;
    TextView title;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        Intent intent = getIntent();
        News news = intent.getParcelableExtra("news");
        image=findViewById(R.id.imageView2);
        title=findViewById(R.id.textView3);
        description=findViewById(R.id.textView);
        sharButton=findViewById(R.id.button);
        image.setImageResource(news.getImage());
        title.setText(news.getTitle());
        description.setText("News refers to the information about current events or recent happenings that is reported by journalists and broadcasted through various media channels. It includes reporting on a wide range of topics, such as politics, sports, entertainment, and more. The purpose of news is to keep the public informed and updated on what is going on around the world.\n "+
                "so don't trust anything you find");
        sharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(news.getTitle(),description.getText().toString());
            }
        });
    }

    public void sendMail(String subject,String content){
        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,content);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"chose email client : "));

        // i tried to send also the image but i couldn't do it

    }
}