package mpdam.p1.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<News> newsList=new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
        News News1=new News(R.drawable.interview,"Bassem Youssef GOES OFF on Piers Morgan \uD83C\uDDF5\uD83C\uDDF8 #bassemyoussef #palestine #piersmorgan");
        News News2=new News(R.drawable.maxresdefault,"An IBM Quantum Computer Will Soon Pass the 1,000-Qubit Mark\n" +
                "Uploaded: Dec 24, 2022");
        News News3=new News(R.drawable.test,"Photos: Palestine solidarity rallies around the world | Gaza News");
        News News4=new News(R.drawable.jazira,"Al Jazeera condemns killing of journalist Wael Al-Dahdouh’s family in Gaza");

        newsList.add(News1);
        newsList.add(News2);
        newsList.add(News3);
        newsList.add(News4);

        adapter = new MyAdapter(this, newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


}