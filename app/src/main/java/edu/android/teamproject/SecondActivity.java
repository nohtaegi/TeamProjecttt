package edu.android.teamproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final int REQ_CODE = 1000;
    public static final int PICK_FROM_CAMERA = 1;
    private Button btn_gallery, btn_picture;
    public static Bitmap bit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        btn_gallery = (Button) findViewById(R.id.btn_gallery);
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_CAMERA);
            }
        });

        btn_picture = (Button) findViewById(R.id.btn_picture);
        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQ_CODE);
            }
        });
    }

    public void startCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQ_CODE);

    } // end startCamera

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQ_CODE && resultCode == RESULT_OK) {
            Bundle bundle =data.getExtras();

            if (bundle !=null) {
                bit = (Bitmap) bundle.get("data");
                Intent nextI = new Intent(this, MainActivity.class);
                startActivity(nextI);
            } else  {
                Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode==PICK_FROM_CAMERA) {
            Bundle bundle = data.getExtras();

            if (bundle !=null) {

            } else {

            }
        } else  if (1==1) {

        }



    }
}
