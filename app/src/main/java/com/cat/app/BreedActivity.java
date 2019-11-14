package com.cat.app;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.google.gson.Gson;


public class BreedActivity extends AppCompatActivity {
    private ImageView ivBreed;
    private String breedId;
    private SharedPreferences sp;
    private RequestQueue requestQueue;
    private TextView breedName;
    private TextView breedWeight;
    private TextView breedTemperament;
    private TextView tvDes;
    private TextView breedOrigin;
    private TextView breedLifeSpan;
    private TextView breedDogFriendLy;
    private TextView breedWiki;
    private BreedInfo.ItemBreed info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed);
         requestQueue = Volley.newRequestQueue(this);
        sp = getSharedPreferences("Breed", MODE_PRIVATE);
        breedId = getIntent().getStringExtra("id");
        ivBreed = findViewById(R.id.ivBreed);
        breedName = findViewById(R.id.breedname);
        breedWeight = findViewById(R.id.weight);
        breedTemperament = findViewById(R.id.temperament);
        tvDes = findViewById(R.id.info);
        breedOrigin = findViewById(R.id.origin);
        breedLifeSpan = findViewById(R.id.lifepan);
        breedWiki = findViewById(R.id.wikiurl);
        breedDogFriendLy = findViewById(R.id.dog_friendly);
        findViewById(R.id.ivFav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav();
            }
        });

        getInfo();

    }

    private void fav() {
        if (info==null){
            return;
        }
        boolean isFav= false;
        String breeds = sp.getString("breed","");
        String id = info.getId();
        String name = info.getId();
        String item = id+"-"+name;
        if (TextUtils.isEmpty(breeds)){
            sp.edit().putString("breed",item).commit();;
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
            return;
        }else{
            String[] arr = breeds.split("#");
            for (int i = 0; i < arr.length; i++) {
                String fav = arr[i];
                String favId = fav.split("-")[0];
                if (favId.equals(id)){
                    isFav = true;
                    break;
                }
            }
        }
        if (!isFav){
            sp.edit().putString("breed",breeds+"#"+item).commit();;
        }


    }


    private void getInfo(){
        String catApiUrl = "https://api.thecatapi.com/v1/images/search?breed_ids="+ breedId;
        Response.Listener<String> success = new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                BreedInfo[] breeds = new Gson().fromJson(response, BreedInfo[].class);
                BreedInfo breedInfo = breeds[0];
                info = breedInfo.getBreeds().get(0);
                breedName.setText(info.getName());
                breedWeight.setText("metric:"+info.getWeight().getMetric());
                breedWiki.setText("wiki:"+info.getWikipedia_url());
                breedTemperament.setText("temperament:"+info.getTemperament());
                breedDogFriendLy.setText("Dog friendly:"+info.getDog_friendly());
                breedOrigin.setText("Origin:"+info.getOrigin());
                breedLifeSpan.setText("Life span:"+info.getLife_span());
                tvDes.setText("Description:"+info.getDescription());
                setImage(breedInfo.getUrl(),breedInfo.getWidth(),breedInfo.getHeight());

            }
        };
        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BreedActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        };
        StringRequest request = new StringRequest(Request.Method.GET, catApiUrl, success,error );
        requestQueue.add(request);
    }

    private void setImage(String url,int w,int h) {
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                ivBreed.setImageBitmap(response);
            }
        },w , h, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(imageRequest);
    }




}
