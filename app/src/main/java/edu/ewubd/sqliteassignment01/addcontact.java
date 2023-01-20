package edu.ewubd.sqliteassignment01;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;

public class addcontact extends AppCompatActivity {

    EditText name, email, phone_home, phone_office;
    ImageView image;

    String keyoneTime = "";
    String saved = "";
    String  newString = "";
    int c=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        name = findViewById(R.id.name_display_id);
        email =  findViewById(R.id.email_display_id);
        phone_home = findViewById(R.id.phone_home_display_id);
        phone_office = findViewById(R.id.phone_office_display_id);
        image = findViewById(R.id.image_view_id);


        Bundle extras = getIntent().getExtras();
        newString = extras.getString("STRING_I_NEED");
        System.out.println("new"+newString);

        if(c==1){
            load(newString);
            saved = newString;
            c++;
        }else{
            load(saved);
        }

        //rup1669399450669
    }

    public void load(String key1){

        KeyValueDB kv = new KeyValueDB(this);

        String v = kv.getValueByKey(key1);

        String []value= v.split("___");

        for(int i=0; i<value.length; i++){
            System.out.println(value[0]);
            System.out.println(value[1]);
            System.out.println(value[2]);
            name.setText(value[0]);
            email.setText(value[1]);
            phone_home.setText(value[2]);
            phone_office.setText(value[3]);
            String str_image =value[4];
            byte[] bytes= Base64.decode(str_image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            image.setImageBitmap(bitmap);

        }
    }
}