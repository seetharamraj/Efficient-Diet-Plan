package com.example.efficientdietplan;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Display extends AppCompatActivity {
    TextView t;
    DatabaseReference databaseReference;

    //  SQLiteDatabase db = g.getReadableDatabase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        DatabaseHelper g=new DatabaseHelper(this);
        t = (TextView) findViewById(R.id.textView);
        Intent i= getIntent();
        String gender = i.getStringExtra("message");
        String str2 = i.getStringExtra("message2");
        String str3 = i.getStringExtra("message3");
        String email = i.getStringExtra("message4");

        databaseReference = FirebaseDatabase.getInstance().getReference("details");
        String id=databaseReference.push().getKey();
        Details d=new Details(id,email,gender,str2,str3);
        databaseReference.child(id).setValue(d).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isComplete()){
                    Toast.makeText(Display.this, "Success",
                            Toast.LENGTH_LONG).show();
                }   else{
                    Toast.makeText(Display.this, "Authentication failed."+task.getException().getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });


                // t.setText(gender);
                Double Height = Double.parseDouble(str2);
        Double Weight=Double.parseDouble(str3);
        if(Height==5.10)
        {
            Height=5.99;
        }
        if(Height==4.10)
        {
            Height=4.99;
        }
        String idealweight=g.retrivie(Height,gender);

        String[] ss=idealweight.split("-");
        String w1=ss[0];
        String w2=ss[1];
        Double min=Double.parseDouble(w1);
        Double max=Double.parseDouble(w2);
        if(Weight<min)
        {
            t.setText("yor are in under weight and ideal weight is "+idealweight+
                    "\n Breakfast \n" +
                    "You can have one glass luke warm milk/ one cup tea/ one cup coffee/ fresh juice with one plate of flattened rice (poha)/upma, two egg omelette/two boiled eggs or three brown bread slices with jam or butter. Instead of all these, you can also eat two stuffed chapattis, stuffed with grated paneer or potato.\n" +
                    "\n" +
                    "It is important to have heavy or fulfilling breakfast as this gives you energy to perform your activities whole day. Breakfast should be a combination of food items containing proteins & carbohydrates, as they help in regaining & maintaining the energy level in the body. One should never skip breakfast.\n" +
                    "Lunch\n" +
                    "The second meal of your day must include a bowl of sweet curd, 2-3 chapattis with ghee on them, a bowl of rice, a dish made with green vegetables or a bowl full of dal (cereals), a plate of salad, containing good amount of tomato, cucumber, black olives, and grated cabbage. You can also take paneer instead of dal.\n" +
                    "\n" +
                    "This meal refreshes your body. Skipping or avoiding lunch can cause indigestion or gastric problems. Lunch helps in maintaining BMR level in the body. Adding good quantity of a variety of vegetables, makes your lunch healthy. You can shorten the quantity of lunch, but never skip it or you may feel starved by the time you reach home from work, making you overeat during dinner.\n" +
                    "\n" +
                    "Also read: Stay at a healthy weight\n" +
                    "\n" +
                    "Evening snack \n" +
                    "By this time, you may start feeling hungry again. Eat two slices of brown bread with cheese and one glass of banana shake/custard apple shake/mango shake or a cup of tea or coffee. Although, evening meal is not the main meal of the day, it rejuvenates your lost energy.\n" +
                    "\n" +
                    "Dinner \n" +
                    "In dinner, you can take one bowl of sweet or salted curd. 1- 2 chapattis with ghee, dry dish prepared with green vegetables (avoid curry dishes), one bowl of dal, a plate full of salad, etc. \n" +
                    "\n" +
                    "Your dinner must be nutritious, well portioned and include no item that takes time to get digested. Try to eat your dinner at least 2.5 hours before going to bed. Eating dinner keeps you from feeling hungry in the middle of night thus, preventing binge eating.\n" +
                    "\n");
        }
        if(Weight>=min && Weight<max)
        {
            t.setText("yor have perfect weight and your weight is "+Weight+
                    "\n These are the steps to maintain good health" +
                    "\n 1.Stay Hydrated\n" +
                    "2.Eat Plenty of Fruits and Vegetables\n" +
                    "\n" +
                    "3.Don’t Skip Your Meals\n" +
                    "\n" +
                    "4.Avoid Fatty, Processed Foods\n" +
                    "\n" +
                    "5.Include More Lean Meats, Low-Fat Dairy Products, and Whole Grains To Your Diet\n" +
                    "\n" +
                    " 6.Load Up on Good Fats ");
        }
        if(Weight>=max)
        {
            t.setText("yor are in over weight and ideal weight is "+idealweight+
                    "\n Early Morning (6:30 - 8:00 am):\n" +
                    "Start your day with exercises. It will not only help you burn some calories, but you will also be able to stay active throughout the day, burning even more calories. After your workout, add a cup of tea or coffee made from low fat skimmed milk. You can have a couple of fibre-rich biscuits with it. Preferably, start your day with a small bowl of cereals.\n" +
                    "\n" +
                    "Brunch (10:30 - 11:30 am):\n" +
                    "Weight loss doesn't have to come from hunger. Instead, it is best to eat something healthy at quick intervals. Before you feel hungry for your lunch, treat yourself to a fresh fruit such as an apple or orange. Keep shuffling your fruit during the week so that you get all the minerals and vitamins during the week.\n" +
                    "\n" +
                    "Lunch (1:00 - 2:00 p.m.):\n" +
                    "Eat a healthy but light lunch that is low in fat and calories. You can also drink a glass of water around 20 minutes before your lunch. It will reduce your hunger and keep you from overeating.\n" +
                    "\n" +
                    "Evening (4:00 - 6:00 p.m.):\n" +
                    "You can have a cup of tea or coffee along with healthy snacks. However, make sure you avoid sodas and sugary beverages that may appear tempting at this of the day.\n" +
                    "\n" +
                    "Dinner (7:00 - 8:00 p.m.):\n" +
                    "Drink a glass of water around 15 minutes before you intend to have your dinner. Now it's time for a light and healthy meal that is full of nutritional content. You can mention different low-calorie dishes for dinner on different days of the week.\n" +
                    "\n" +
                    "Post Dinner (10:00 - 10:30 p.m.):\n" +
                    "A couple of slices of a fresh fruit like apple or papaya. You can switch your fruits daily.");
        }

    }
}
