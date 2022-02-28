package ben.anzo.walletfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton gotoaddaccount;
    Button search ;
    EditText idsearch;
    private  RecyclerView mrecyclerView;
    private List<Object> viewItems = new ArrayList<>();
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       gotoaddaccount =(FloatingActionButton) findViewById(R.id.gotoaddaccount);

   // search = (Button) findViewById(R.id.search);
   // idsearch = (EditText) findViewById(R.id.idsearch);


    mrecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    mrecyclerView.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(this);

    mrecyclerView.setLayoutManager(layoutManager);


    madapter = new RecyclerAdapter(this,viewItems);

    mrecyclerView.setAdapter(madapter);

        try {
            addMenuItemsFromJson();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        gotoaddaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Json = new Intent(MainActivity.this,AddAccountActivity.class);
                startActivity(Json);
            }
        });


    }

    public void addMenuItemsFromJson() throws JSONException {
        try {

            String jsonDataString = readJsonDataFromFile();
            JSONArray accountArray = new JSONArray(jsonDataString);
            for (int i = 0; i < accountArray.length(); i++) {
                JSONObject account = accountArray.getJSONObject(i);

                String type = account.getString("type");
                String date = account.getString("date");
                String money = account.getString("money");
                String accounlogo = account.getString("logo");
               // int accountlogo = Integer.valueOf(accounlogo);
                Account compte = new Account(type, money, date,"");
                viewItems.add(compte);

            }
        }catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    private String readJsonDataFromFile() throws IOException {
        InputStream inputStream =null;
        StringBuilder stringBuilder = new StringBuilder();

       try {
           String jsonDataString = null;
           inputStream = getResources().openRawResource(R.raw.lescomptes);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
           while((jsonDataString = bufferedReader.readLine()) != null){
               stringBuilder.append(jsonDataString);
           }
       }finally {
           if (inputStream == null) {
               inputStream.close();
           }
       }
       return new String(stringBuilder);

     }



 }


