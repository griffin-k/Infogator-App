package com.infogator.pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class CityDetails extends AppCompatActivity {

    ShapeableImageView mainimage, attr1img, attr2img, food1img, food2img;
    TextView city, description, duration, timetovisit, attr1name, attr1des, attr2name, attr2des, food1name, food1des, food2name, food2des;
    Button locationbtn, locationbtn2;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        mainimage = findViewById(R.id.citydetails_image);
        attr1img = findViewById(R.id.citydetails_place1image);
        attr2img = findViewById(R.id.citydetails_place2image);
        food1img = findViewById(R.id.citydetails_food1image);
        food2img = findViewById(R.id.citydetails_food2image);
        city = findViewById(R.id.citydetails_name);
        description = findViewById(R.id.citydetails_description);
        duration = findViewById(R.id.citydetails_tripduration);
        timetovisit = findViewById(R.id.citydetails_besttime);
        attr1name = findViewById(R.id.citydetails_place1name);
        attr2name = findViewById(R.id.citydetails_place2name);
        food1name = findViewById(R.id.citydetails_food1name);
        food2name = findViewById(R.id.citydetails_food2name);
        attr1des = findViewById(R.id.citydetails_place1description);
        attr2des = findViewById(R.id.citydetails_place2description);
        food1des = findViewById(R.id.citydetails_food1description);
        food2des = findViewById(R.id.citydetails_food2description);
        locationbtn = findViewById(R.id.citydetails_getlocationbtn);


        String city_str = getIntent().getStringExtra("putextra_city");

        if (city_str.equals("Hunza")) {
            city.setText("Hunza , KpK");



            attr1name.setText("Satpara");
            attr1des.setText(" is a historical building");
            attr1img.setImageResource(R.drawable.satpara);



            attr2name.setText("Deosoi Park");
            attr2des.setText("is a historical building");
            attr2img.setImageResource(R.drawable.deosai);


            food1name.setText("Tumara Tea");
            food1des.setText("A very delicious sweet");
            food1img.setImageResource(R.drawable.tumoro);


            food2name.setText("Chapshura");
            food2des.setText("A popular street food");
            food2img.setImageResource(R.drawable.chapshuro);



            description.setText("Located in Gilgit Baltistan, the Hunza Valley is one of Pakistan’s hidden gems. This isolated valley is nestled between the Himalayas and the Karakoram mountain peaks. This is one of the best places to visit in Pakistan because of its lush farmlands. Here you can find markhors, ounces, ibexes, and red foxes. In this valley, a glorious view awaits you, and the locals are warm and friendly.");


            location = "https://goo.gl/maps/JV2C8KSDh3ZXpNrm8";


            timetovisit.setText("April to September");
            duration.setText("2 to 3 Days");


            mainimage.setImageResource(R.drawable.hunza);
        }




        if (city_str.equals("Attabad")) {
            city.setText("Attabad , KpK");



            attr1name.setText("Baltit");
            attr1des.setText(" is a historical building");
            attr1img.setImageResource(R.drawable.baltit);



            attr2name.setText("ShahUsir");
            attr2des.setText("is a historical building");
            attr2img.setImageResource(R.drawable.shahusir);


            food1name.setText("Deram");
            food1des.setText("A very delicious sweet");
            food1img.setImageResource(R.drawable.dirham);


            food2name.setText("Harisa");
            food2des.setText("A popular street food");
            food2img.setImageResource(R.drawable.harisa);



            description.setText("This beautiful lake which provides tranquil waters was originated as a result of a landslide in January 2010 in Attabad Village. The lake has vivid blue waters that pierce through the hilly land of Hunza Valley The lake is one of the most popular tourist places in Pakistan, offering exciting experiences like skiing, boating, catching fishes and others.");


            location = "https://goo.gl/maps/9tBUeMmKDRczWxHV7";


            timetovisit.setText("March to June");
            duration.setText("2 to 3 Days");


            mainimage.setImageResource(R.drawable.attabad);
        }



        if (city_str.equals("Sawat")) {
            city.setText("Sawat , Malakand");



            attr1name.setText("Kalam");
            attr1des.setText(" is a historical building");
            attr1img.setImageResource(R.drawable.kalam);



            attr2name.setText("Mahodhand");
            attr2des.setText("is a historical building");
            attr2img.setImageResource(R.drawable.mahodhand);


            food1name.setText("Kabab");
            food1des.setText("A very delicious sweet");
            food1img.setImageResource(R.drawable.cahplikabab);


            food2name.setText("Tikkay");
            food2des.setText("A popular street food");
            food2img.setImageResource(R.drawable.tikkay);



            description.setText("Despite its tragic history, Swat Valley’s present situation is very promising. There’s something fairytale-like about this spectacular valley in Pakistan’s Khyber Pakhtunkhwa province. Being one the most beautiful places to visit in Pakistan among all other attractions, this valley has great weather and friendly locals. Visitors can enjoy trekking, hiking, backpacking, or simply enjoy in the natural environment.");


            location = "https://goo.gl/maps/frCNsZUc97dWYJQE6";


            timetovisit.setText(" April to May");
            duration.setText("2 to 3 Days");


            mainimage.setImageResource(R.drawable.swat);
        }



        if (city_str.equals("Naran")) {
            city.setText("Naran , KpK");



            attr1name.setText("Piyala Lake");
            attr1des.setText(" is a historical building");
            attr1img.setImageResource(R.drawable.piyalalake);



            attr2name.setText("Kunhar");
            attr2des.setText("is a historical building");
            attr2img.setImageResource(R.drawable.kunhar);


            food1name.setText("Biryani");
            food1des.setText("A very delicious sweet");
            food1img.setImageResource(R.drawable.biryani);


            food2name.setText("Pulao");
            food2des.setText("A popular street food");
            food2img.setImageResource(R.drawable.pulao);



            description.setText("Naran and Kaghan are two amazing places to visit in Pakistan which are located in Khyber Pakhtunkhwa. They are amazing places to explore for those who love nature. You will find beautiful rivers, stretches of fields, snowcapped peaks, and picturesque lakes in these areas. Each year, thousands of tourists come to this valley from all over the world.");


            location = "https://goo.gl/maps/mLcETeaUCQBXzexa9";


            timetovisit.setText("April to September");
            duration.setText("2 to 3 Days");


            mainimage.setImageResource(R.drawable.narran);
        }



        if (city_str.equals("Badshai")) {
            city.setText("Badshai , Lahore");



            attr1name.setText("Lahore Fort");
            attr1des.setText(" is a historical building");
            attr1img.setImageResource(R.drawable.lhrfort);



            attr2name.setText("Dehli Gate");
            attr2des.setText("is a historical building");
            attr2img.setImageResource(R.drawable.delhigate);


            food1name.setText("Naan Chana");
            food1des.setText("A very delicious sweet");
            food1img.setImageResource(R.drawable.nanchana);


            food2name.setText("Halwa Puri");
            food2des.setText("A popular street food");
            food2img.setImageResource(R.drawable.halwapuri);



            description.setText("Originally built during the 1670s, Badshahi Mosque is a monument of the Mughal Empire, which ruled over the Indian subcontinent for nearly three centuries. Located in Lahore, this mosque is a great representation of Mughal architecture, with four minarets and three domes forming the courtyard. The mosque is a UNESCO World Heritage Site. The monument truly justifies being one of the beautiful tourist places in Pakistan.");


            location = "https://goo.gl/maps/LMuiAHt6T9hDBd7n8";


            timetovisit.setText("Except June and July.");
            duration.setText("2 to 3 Days");


            mainimage.setImageResource(R.drawable.badshahi);
        }



        if (city_str.equals("Mohenjo Daro")) {
            city.setText("Mohenjo Daro , Larkana");



            attr1name.setText("RaniKot");
            attr1des.setText(" is a historical fort");
            attr1img.setImageResource(R.drawable.ranikot);



            attr2name.setText("Karunjhar");
            attr2des.setText("is a historical lake");
            attr2img.setImageResource(R.drawable.karunjhar);


            food1name.setText("Chap Chola");
            food1des.setText("A very delicious food");
            food1img.setImageResource(R.drawable.chapchola);


            food2name.setText("Sahi Bhaji");
            food2des.setText("A popular street food");
            food2img.setImageResource(R.drawable.sahiphaji);



            description.setText("Mohenjo-daro, located in Sindh, a province in southeastern part of the country, that is among the famous places to visit in Pakistan. It is home to the Sindh people and a historical site dating back to 2500 BCE. The ruins and mounds were discovered to be part of an ancient civilization called the Indus Valley civilization. Those who love history will be fascinated by the engineering and urban planning that was far ahead of their time.");


            location = "https://goo.gl/maps/xT1oRH9S5W3byEd36";


            timetovisit.setText("whole year");
            duration.setText("2 to 3 Days");


            mainimage.setImageResource(R.drawable.mohen);
        }





        locationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(location)));
            }
        });





    }
}



