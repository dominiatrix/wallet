package ben.anzo.walletfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.uiautomator.UiDevice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddAccountActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button addaccount, backtohome;
    CircleImageView logo;
    int[] logos ={R.drawable.ecobanklogo,R.drawable.ubalogo,R.drawable.mtnlogo,R.drawable.boalogo};
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.example.android.testing.uiautomator.BasicSample";

    private static final int LAUNCH_TIMEOUT = 5000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    private UiDevice mDevice;
    File file;
    Spinner accountType;
    EditText accountId, money;
    List Type_of_Account = new ArrayList();
    FileOutputStream out = null;
    JSONObject jsonObject = new JSONObject();
    FileWriter fw;
    LocalDate date;
    String type;
    String filename = "C:\\WorkSpace\\AndroidStudioProjects\\WalletFinal\\app\\ounts.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        accountType = findViewById(R.id.accountTypetext);
        accountId = findViewById(R.id.accountIdtext);
        money = findViewById(R.id.moneytext);
        addaccount = findViewById(R.id.addaccounttext);
        backtohome = findViewById(R.id.backtohome);
        logo = findViewById(R.id.logo);








        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent Json = new Intent(AddAccountActivity.this, MainActivity.class);
               // startActivity(Json);
                if (type == "UBA") {
                    logo.setImageResource(logos[1]);

                }
                else if (type == "BOA") {
                    logo.setImageResource(logos[3]);
                }
                else if (type == "ECOBANK") {
                    logo.setImageResource(logos[0]);
                }
                else if (type == "MoMo") {
                    logo.setImageResource(logos[2]);
                }
            }
        });








        addaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(file.createNewFile()){
                      //  addaccount();
                        System.out.println(true);
                    }else{
                        System.out.println(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        type = adapterView.getSelectedItem().toString();

       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (type == "UBA") {
                   logo.setImageResource(logos[1]);

               }
               else if (type == "BOA") {
                   logo.setImageResource(logos[3]);
               }
               else if (type == "ECOBANK") {
                   logo.setImageResource(logos[0]);
               }
               else if (type == "MoMo") {
                   logo.setImageResource(logos[2]);
               }
           }
       });

        }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addaccount() throws JSONException, IOException {
        file = new File(getExternalFilesDir(null), "accounts.json");

            Account account = new Account("24", "42", "","");
        if (type == "UBA") {
            logo.setImageResource(logos[1]);


        }
        else if (type == "BOA") {
            logo.setImageResource(logos[3]);
        }
        else if (type == "ECOBANK") {
            logo.setImageResource(logos[0]);
        }
        else if (type == "MoMo") {
            logo.setImageResource(logos[2]);
        }
            JSONObject accountObj = new JSONObject();
            accountObj.put("Type_de_compte",account.accounttype);
            accountObj.put("Id",accountId);
            accountObj.put("Date",date);

            JSONObject comptes = new JSONObject();
            comptes.put("Compte",accountObj);
            ArrayList accountList = new ArrayList();

            accountList.add(comptes);
        try {


        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(accountList.toString());


            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        }




}


//  Toast.makeText(getBaseContext(), "File saved successfully!",
  //        Toast.LENGTH_SHORT).show();

